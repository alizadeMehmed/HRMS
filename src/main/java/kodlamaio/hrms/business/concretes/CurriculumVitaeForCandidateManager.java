package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeForCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CurriculumVitaeForCandidateDao;
import kodlamaio.hrms.entities.concretes.CurriculumVitaeForCandidate;
import kodlamaio.hrms.entities.dtos.CvWithCandidateAndEducationDto;
import kodlamaio.hrms.entities.dtos.CvWithCandidateAndExperienceWithDetailsDto;

@Service
public class CurriculumVitaeForCandidateManager implements CurriculumVitaeForCandidateService {

	CurriculumVitaeForCandidateDao cvForCandidateDao;

	@Autowired
	public CurriculumVitaeForCandidateManager(CurriculumVitaeForCandidateDao cvForCandidateDao) {
		super();
		this.cvForCandidateDao = cvForCandidateDao;
	}

	@Override
	public DataResult<List<CvWithCandidateAndEducationDto>> getCvWithCandidateAndEducationOrderByGraduateYear() {
		return new SuccessDataResult<List<CvWithCandidateAndEducationDto>>(
				this.cvForCandidateDao.getCvWithCandidateAndEducationOrderByGraduateDate(), "Cvler listelendi");
	}

	@Override
	public DataResult<List<CvWithCandidateAndExperienceWithDetailsDto>> getCvWithCandidateAndExperienceWithDetailsOrderByExperienceYear() {
		return new SuccessDataResult<List<CvWithCandidateAndExperienceWithDetailsDto>>(
				this.cvForCandidateDao.getCvWithCandidateAndExperienceWithDetailsOrderByExperienceYear(),
				"Cvler listelendi");

	}

	@Override
	public DataResult<List<CurriculumVitaeForCandidate>> getAll() {
		return new SuccessDataResult<List<CurriculumVitaeForCandidate>>(this.cvForCandidateDao.findAll());
	}

	@Override
	public Result add(CurriculumVitaeForCandidate curriculumVitaeForCandidate) {
		this.cvForCandidateDao.save(curriculumVitaeForCandidate);
		return new SuccessResult("Adaya ait cv girişi başarıyla tamamlandı");
	}

	@Override
	public DataResult<List<CurriculumVitaeForCandidate>> getByIdentityNumber(String identityNumber) {
		return new SuccessDataResult<List<CurriculumVitaeForCandidate>>(this.cvForCandidateDao.getByIdentityNumber(identityNumber));
	}

}
