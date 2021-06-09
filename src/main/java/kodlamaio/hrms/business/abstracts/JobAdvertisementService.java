package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithDetailsDto;

@Service
public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdvertisement);

	DataResult<List<JobAdvertisement>> getAll();

	DataResult<List<JobAdvertisementWithDetailsDto>> jobAdvertisementWithDetails();

	DataResult<List<JobAdvertisementWithDetailsDto>> getByIsActive(boolean isActive);

	DataResult<List<JobAdvertisementWithDetailsDto>> getAllByIsActiveAndEmployer(boolean isActive, String companyName);

	DataResult<List<JobAdvertisementWithDetailsDto>> getAllSortedByPostingDateAsc();
	
	DataResult<List<JobAdvertisementWithDetailsDto>> getAllSortedByPostingDateDesc();
	
}
