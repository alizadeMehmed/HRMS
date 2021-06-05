package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobTitleDto;

public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisementWithEmployerWithJobTitleDto>> JobAdvertisementWithEmployerWithJobTitleDetails();
	List<JobAdvertisement> getByIsActive(boolean isActive);
	List<JobAdvertisement> getAllSortedByPostingDate();
	List<JobAdvertisement> getAllByIsActiveAndEmployer();
}
