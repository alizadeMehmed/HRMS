package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ApplicantUserService;
import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.business.abstracts.PersonCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ApplicantUserDao;
import kodlamaio.hrms.entities.concretes.ApplicantUser;


@Service
public class ApplicantUserManager implements ApplicantUserService {

	PersonCheckService personCheckService;
	ApplicantUserDao applicantUserDao;
	EmailService emailService;
	@Autowired
	public ApplicantUserManager(ApplicantUserDao applicantUserDao, EmailService emailService,
			PersonCheckService personCheckService) {
		super();
		this.applicantUserDao = applicantUserDao;
		this.emailService = emailService;
		this.personCheckService = personCheckService;
	}

	@Override
	public DataResult<List<ApplicantUser>> getAll() {

		return new SuccessDataResult<List<ApplicantUser>>(this.applicantUserDao.findAll(), "Data listelendi");
	}

	public boolean fieldsIsNull(ApplicantUser applicantUser) {

		if (applicantUser.getFirstName().equals(null) || applicantUser.getLastName().equals(null)
				|| applicantUser.getBirthYear() == 0 || applicantUser.getNationalId().equals(null)
				|| applicantUser.getEmail().equals(null) || applicantUser.getPassword().equals(null)
				|| applicantUser.getPasswordRepeat().equals(null)) {
			return true;
		}

		return false;

	}

	@Override
	public Result add(ApplicantUser applicantUser) {

		if (this.fieldsIsNull(applicantUser)) {
			return new ErrorResult("Tüm alanlar zorunludur.");
		}
		if (!emailService.isEmailValid(applicantUser.getEmail())) {
			return new ErrorResult("Email adresi hatalıdır");
		}
		if (personCheckService.checkIfRealPerson(applicantUser.getNationalId(), applicantUser.getFirstName(),
				applicantUser.getFirstName(), applicantUser.getBirthYear()) == false) {
			applicantUser.setVerified(false);
			return new ErrorResult("Bilgiler Geçersizdir");
			
		} else if (personCheckService.checkIfRealPerson(applicantUser.getNationalId(), applicantUser.getFirstName(),
				applicantUser.getFirstName(), applicantUser.getBirthYear())) {
			applicantUser.setVerified(true);
			System.out.println("Mernis Doğrulaması Yapıldı");
		}
		if (applicantUserDao.existsByEmail(applicantUser.getEmail())) {
			return new ErrorResult( "Girmiş olduğunuz email sisteme kayıtlıdır");
		}
		if (applicantUserDao.existsByNationalId(applicantUser.getNationalId())) {
			return new ErrorResult("Girmiş olduğunuz Tc Kimlik No sisteme kayıtlıdır");
		}
		if (emailService.isEmailActivated(applicantUser.getEmail()) == false) {
			applicantUser.setEmailActivated(false);
			return new ErrorResult("Lütfen Mailinize Gelen Aktivasyon Linkine Tıklayınız");
		} else if (emailService.isEmailActivated(applicantUser.getEmail())) {
			applicantUser.setEmailActivated(true);
		}

		this.applicantUserDao.save(applicantUser);
		return new SuccessResult("İş arayan Eklendi: ");
	}

}



