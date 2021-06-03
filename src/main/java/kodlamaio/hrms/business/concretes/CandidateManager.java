package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.business.abstracts.PersonCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private PersonCheckService personCheckService;
	private CandidateDao candidateDao;
	EmailService emailService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, EmailService emailService,
			PersonCheckService personCheckService) {
		super();
		this.candidateDao = candidateDao;
		this.emailService = emailService;
		this.personCheckService = personCheckService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {

		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data eklendi");
	}

	public boolean fieldsIsNull(Candidate candidate) {

		if (candidate.getFirstName().equals(null) || candidate.getLastName().equals(null)
				|| candidate.getBirthYear() == 0 || candidate.getIdentityNumber().equals(null)
				|| candidate.getEmail().equals(null) || candidate.getPassword() == null
				|| candidate.getPasswordRepeat().equals(null)) {
			return true;
		}

		return false;

	}

	@Override
	public Result add(Candidate candidate) {

		if (this.fieldsIsNull(candidate)) {
			return new ErrorResult("Tüm alanlar zorunludur.");
		}
		if (!candidate.getPassword().equals(candidate.getPasswordRepeat()))  {
			return new ErrorResult("Şifreler eşleşmemektedir");
		}
		if (!emailService.isEmailValid(candidate.getEmail())) {
			return new ErrorResult("Email adresi hatalıdır");
		} else {
			emailService.sendMail(candidate.getEmail());
		}

		if (personCheckService.checkIfRealPerson(candidate.getIdentityNumber(), candidate.getFirstName(),
				candidate.getFirstName(), candidate.getBirthYear()) == false)

		{
			return new ErrorResult("Bilgiler Geçersizdir");

		} else if (personCheckService.checkIfRealPerson(candidate.getIdentityNumber(), candidate.getFirstName(),
				candidate.getFirstName(), candidate.getBirthYear())) {
			System.out.println("Mernis Doğrulaması Yapıldı");
		}
		if (candidateDao.existsByEmail(candidate.getEmail())) {
			return new ErrorResult("Girmiş olduğunuz email sisteme kayıtlıdır");
		}
		if (candidateDao.existsByIdentityNumber(candidate.getIdentityNumber())) {
			return new ErrorResult("Girmiş olduğunuz Tc Kimlik No sisteme kayıtlıdır");
		}
		if (emailService.isEmailActivated(candidate.getEmail()) == false) {
			return new ErrorResult("Lütfen Mailinize Gelen Aktivasyon Linkine Tıklayınız");
		} else if (emailService.isEmailActivated(candidate.getEmail())) {
			// Verification Coduna bir ekleme yapılacak
		}

		this.candidateDao.save(candidate);
		return new SuccessResult("İş arayan Eklendi: ");
	}

}
