package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.HrmsValidationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmailService emailService;
	private HrmsValidationService hrmsValidationService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailService emailService,
			HrmsValidationService hrmsValidationService) {
		super();
		this.employerDao = employerDao;
		this.emailService = emailService;
		this.hrmsValidationService = hrmsValidationService;

	}

	public boolean fieldIsNull(Employer employer) {
		if (employer.getCompanyName().equals(null) || employer.getWebAddress().equals(null)
				|| employer.getEmail().equals(null) || employer.getPhoneNumber().equals(null)
				|| employer.getPassword().equals("") || employer.getPasswordRepeat().equals(null)) {
			return true;
		}

		return false;
	}

	public boolean isEmailCompanyEmail(Employer employerUser) {
		String emailDomain = employerUser.getEmail().substring(employerUser.getEmail().lastIndexOf("@") + 1);
		
		if (!emailDomain.equals(employerUser.getWebAddress())) {
			return false;
		}
		return true;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data eklendi");
	}

	@Override
	public Result add(Employer employerUser) {
		if (fieldIsNull(employerUser)) {
			return new ErrorResult("Tüm alanlar zorunludur");
		}
		if (isEmailCompanyEmail(employerUser) == false) {
			return new ErrorResult("Girmiş olduğunuz eposta, web sitesi ile aynı domaine sahip olmalıdır.");
		}
		if (!emailService.isEmailValid(employerUser.getEmail())) {
			return new ErrorResult("Email adresi hatalıdır");
		}
		if (employerDao.existsByEmail(employerUser.getEmail())) {
			return new ErrorResult("Girmiş olduğunuz email sisteme kayıtlıdır");
		}
		if (emailService.isEmailActivated(employerUser.getEmail()) == false) {
			// Burada HrmsConfirms tablolarına ekleme yapılacak
			return new ErrorResult("Lütfen Mailinize Gelen Aktivasyon Linkine Tıklayınız");
//		} else if (emailService.isEmailActivated(employerUser.getEmail())) {
//			//Burada HrmsConfirms tablolarına ekleme yapılacak
		}
		if (hrmsValidationService.isValid() == false) {
			return new ErrorResult("HRMS Doğrulaması Yapılamadı. Lütfen Bilgi işlem birimine müracaat ediniz!");
		}
		this.employerDao.save(employerUser);
		return new SuccessResult("İş Veren Eklendi: ");

	}
}
