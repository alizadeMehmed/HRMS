package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.JobTitle;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithDetailsDto;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}
	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		List<City> cities = jobAdvertisement.getCities();
		List<JobTitle> jobTitles = jobAdvertisement.getJobTitles();
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı eklendi");
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.findAll(), "Data Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisementWithDetailsDto>> getByIsActive(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisementWithDetailsDto>>(
				this.jobAdvertisementDao.getByIsActive(isActive), "Data Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisementWithDetailsDto>> getAllSortedByPostingDateAsc() {
		return new SuccessDataResult<List<JobAdvertisementWithDetailsDto>>(
				this.jobAdvertisementDao.getByIsActiveOrderByPostingDateAsc(true), "Data Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisementWithDetailsDto>> getAllByIsActiveAndEmployer(boolean isActive, String companyName) {
				return new SuccessDataResult<List<JobAdvertisementWithDetailsDto>>(
				this.jobAdvertisementDao.getByIsActiveAndEmployers_companyName(true, companyName), "Data Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisementWithDetailsDto>> jobAdvertisementWithDetails() {
		return new SuccessDataResult<List<JobAdvertisementWithDetailsDto>>(
				this.jobAdvertisementDao.getJobAdvertisementWithEmployersAndJobTitlesDetails(), "Data Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisementWithDetailsDto>> getAllSortedByPostingDateDesc() {
		return new SuccessDataResult<List<JobAdvertisementWithDetailsDto>>(
				this.jobAdvertisementDao.getByIsActiveOrderByPostingDateDesc(true), "Data Listelendi");
	}

}
