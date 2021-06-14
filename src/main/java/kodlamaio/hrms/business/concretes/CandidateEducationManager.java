package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.CandidateEducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateEducationDao;
import kodlamaio.hrms.entities.concretes.CandidateEducation;

@Service
public class CandidateEducationManager implements CandidateEducationService {

	private CandidateEducationDao candidateEducationDao;

	@Autowired
	public CandidateEducationManager(CandidateEducationDao candidateEducationDao) {
		super();
		this.candidateEducationDao = candidateEducationDao;
			}

	@Override
	public DataResult<List<CandidateEducation>> getByFacultyNameOrderByGraduateYearDesc(String facultyName) {

		
			return new SuccessDataResult<List<CandidateEducation>>(
					this.candidateEducationDao.getByFacultyNameOrderByGraduateDateDesc(facultyName));
		}

	@Override
	public Result add(CandidateEducation candidateEducation) {
		if (candidateEducation.getGraduateDate().isEmpty() || candidateEducation.getGraduateDate().isBlank()) {
			candidateEducation.setGraduateDate("Devam ediyor");
		}
		this.candidateEducationDao.save(candidateEducation);
		return new SuccessResult("Adaya ait eğitim bilgileri eklenmiştir. ");
	}

}
