package kodlamaio.hrms.business.concretes;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceDao;
import kodlamaio.hrms.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService {

	ExperienceDao experienceDao;

	public ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	@Override
	public DataResult<List<Experience>> getAll() {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll(), "Data eklendi");
	}

	@Override
	public Result add(Experience experience) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		String formattedDate = format.format(new Date());
		int expYearCont = Integer.parseInt(formattedDate) - Integer.parseInt(experience.getYearOfEmployment());
		int expYear = Integer.parseInt(experience.getYearOff()) - Integer.parseInt(experience.getYearOfEmployment());

		if (experience.getYearOff().isBlank() || experience.getYearOff().isEmpty()) {
			experience.setYearOff("Devam ediyor");
			experience.setExperienceYear(expYearCont);
		} else {
			experience.setExperienceYear(expYear);
		}
		this.experienceDao.save(experience);
		return new SuccessResult("Adaya ait tecrübe bilgileri eklenmiştir");
	}

}
