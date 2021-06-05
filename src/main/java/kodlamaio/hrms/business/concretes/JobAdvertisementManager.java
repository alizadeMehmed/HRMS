package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobTitleDto;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;


public class JobAdvertisementManager implements JobAdvertisementService{

	JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobAdvertisement> getByIsActive(boolean isActive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobAdvertisement> getAllSortedByPostingDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobAdvertisement> getAllByIsActiveAndEmployer() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public DataResult<List<JobAdvertisementWithEmployerWithJobTitleDto>> JobAdvertisementWithEmployerWithJobTitleDetails() {
		return new SuccessDataResult<List<JobAdvertisementWithEmployerWithJobTitleDto>>
		(this.jobAdvertisementDao.getJobAdvertisementWithEmployerWithJobTitleDetails(), "Data Listelendi");
	}

	
	}


