package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.business.abstracts.EmployerUserService;
import kodlamaio.hrms.business.abstracts.HrmsValidationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerUserDao;
import kodlamaio.hrms.entities.concretes.EmployerUser;


@Service
public class EmployerUserManager implements EmployerUserService {

	private EmployerUserDao employerUserDao;
	private EmailService emailService;
	private HrmsValidationService hrmsValidationService;
	
	@Autowired
	public EmployerUserManager(EmployerUserDao employerUserDao, EmailService emailService, HrmsValidationService hrmsValidationService) {
		super();
		this.employerUserDao = employerUserDao;
		this.emailService = emailService;
		this.hrmsValidationService = hrmsValidationService;

	}

	public boolean fieldIsNull(EmployerUser employerUser) {
		if (employerUser.getCompanyName().equals(null) || employerUser.getWebSite().equals(null)
				|| employerUser.getEmail().equals(null) || employerUser.getPhoneNumber().equals(null)
				|| employerUser.getPassword().equals(null) || employerUser.getPasswordRepeat().equals(null)) {
			return true;
		}

		return false;
	}

	public boolean isEmailCompanyEmail(EmployerUser employerUser) {
		String emailDomain= employerUser.getEmail().substring(employerUser.getEmail().lastIndexOf("@") + 1);
		String websiteDomain= employerUser.getWebSite().substring(employerUser.getEmail().lastIndexOf("@") + 1);
	
		if(emailDomain != websiteDomain) {
			return false;
		}
		return true;
	}

	@Override
	public DataResult<List<EmployerUser>> getAll() {
		return new SuccessDataResult<List<EmployerUser>>(this.employerUserDao.findAll(), "Data listelendi");
	}

	@Override
	public Result add(EmployerUser employerUser) {
		if (fieldIsNull(employerUser)) {
			return new ErrorResult("Tüm alanlar zorunludur");
		}
		if (!isEmailCompanyEmail(employerUser)) {
			return new ErrorResult("Girmiş olduğunuz eposta, web sitesi ile aynı domaine sahip olmalıdır.");
		}
		if (!emailService.isEmailValid(employerUser.getEmail())) {
			return new ErrorResult("Email adresi hatalıdır");
		}
		if (employerUserDao.existsByEmail(employerUser.getEmail())) {
			return new ErrorResult("Girmiş olduğunuz email sisteme kayıtlıdır");
		}
		if (emailService.isEmailActivated(employerUser.getEmail())== false) {
			employerUser.setEmailVerified(false);
			return new ErrorResult("Lütfen Mailinize Gelen Aktivasyon Linkine Tıklayınız");
		} else if (emailService.isEmailActivated(employerUser.getEmail())) {
			employerUser.setEmailVerified(true);
		}
		if (!hrmsValidationService.isValid()== false) {
			employerUser.setEmailVerified(false);
			return new ErrorResult("HRMS Doğrulaması Yapılamadı. Lütfen Bilgi işlem birimine müracaat ediniz!");
		} else if (hrmsValidationService.isValid()) {
			employerUser.setEmailVerified(true);
		}
		this.employerUserDao.save(employerUser);
		return new SuccessResult("İş Veren Eklendi: ");
	}
}



