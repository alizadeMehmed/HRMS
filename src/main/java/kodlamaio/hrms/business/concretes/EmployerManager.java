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
	public Result add(Employer employer) {
		if (fieldIsNull(employer)) {
			return new ErrorResult("T??m alanlar zorunludur");
		}
		if (isEmailCompanyEmail(employer) == false) {
			return new ErrorResult("Girmi?? oldu??unuz eposta, web sitesi ile ayn?? domaine sahip olmal??d??r.");
		}
		if (!emailService.isEmailValid(employer.getEmail())) {
			return new ErrorResult("Email adresi hatal??d??r");
		}
		if (employerDao.existsByEmail(employer.getEmail())) {
			return new ErrorResult("Girmi?? oldu??unuz email sisteme kay??tl??d??r");
		}
		if (emailService.isEmailActivated(employer.getEmail()) == false) {
			// Burada HrmsConfirms tablolar??na ekleme yap??lacak
			return new ErrorResult("L??tfen Mailinize Gelen Aktivasyon Linkine T??klay??n??z");
//		} else if (emailService.isEmailActivated(employerUser.getEmail())) {
//			//Burada HrmsConfirms tablolar??na ekleme yap??lacak
		}
		if (hrmsValidationService.isValid() == false) {
			return new ErrorResult("HRMS Do??rulamas?? Yap??lamad??. L??tfen Bilgi i??lem birimine m??racaat ediniz!");
		}
		this.employerDao.save(employer);
		return new SuccessResult("???? Veren Eklendi: ");

	}
}
