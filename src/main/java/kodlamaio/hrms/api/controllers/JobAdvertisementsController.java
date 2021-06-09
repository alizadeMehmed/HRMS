package kodlamaio.hrms.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithDetailsDto;

@RestController
@RequestMapping("/api/jobposting")
public class JobAdvertisementsController {
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}

	@GetMapping("/getAllIsActive")
	public DataResult<List<JobAdvertisementWithDetailsDto>> getByIsActive() {
		return this.jobAdvertisementService.getByIsActive(true);
	}

	@GetMapping("/getJobAdvertisementWithDetails")
	public DataResult<List<JobAdvertisementWithDetailsDto>> getJobAdvertisementWithDetails() {
		return this.jobAdvertisementService.jobAdvertisementWithDetails();
	}

	@GetMapping("/getByPostingDateAscending")
	public DataResult<List<JobAdvertisementWithDetailsDto>> getAllSortedByPostingDateAsc() {
		return this.jobAdvertisementService.getAllSortedByPostingDateAsc();
	}
	
	@GetMapping("/getByPostingDateDescending")
	public DataResult<List<JobAdvertisementWithDetailsDto>> getAllSortedByPostingDateDesc(){
		return this.jobAdvertisementService.getAllSortedByPostingDateDesc();
	}
	@GetMapping("/getByCompanyName")
	public DataResult<List<JobAdvertisementWithDetailsDto>> getAllByIsActiveAndEmployer(String companyName){
		return this.jobAdvertisementService.getAllByIsActiveAndEmployer(true, companyName);
		
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
		
	}
	

	
}
