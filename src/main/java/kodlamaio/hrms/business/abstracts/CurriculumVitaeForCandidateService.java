package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CurriculumVitaeForCandidate;
import kodlamaio.hrms.entities.dtos.CvWithCandidateAndEducationDto;
import kodlamaio.hrms.entities.dtos.CvWithCandidateAndExperienceWithDetailsDto;

public interface CurriculumVitaeForCandidateService {
	DataResult<List<CvWithCandidateAndEducationDto>> getCvWithCandidateAndEducationOrderByGraduateYear();
	DataResult<List<CvWithCandidateAndExperienceWithDetailsDto>> getCvWithCandidateAndExperienceWithDetailsOrderByExperienceYear();
	DataResult<List<CurriculumVitaeForCandidate>> getAll();
	Result add(CurriculumVitaeForCandidate curriculumVitaeForCandidate);
	
	
}
