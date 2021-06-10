package kodlamaio.hrms.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithDetailsDto;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;

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
//	@PostMapping("/add")
//	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
//		return this.jobAdvertisementService.add(jobAdvertisement);
		
//	}
	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisement jobAdvertisement) {
		return ResponseEntity.ok(this.jobAdvertisementService.add(jobAdvertisement));
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError: exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları");
		return errors;
		
	}
	@PostMapping(value= "delete")
	public Result deletebyName(@RequestParam String name) {
		return this.jobAdvertisementService.deleteByName(name);
		
	}
	@PostMapping(value= "deactivate")
	public Result deactivate(@RequestParam String name) {
		return this.jobAdvertisementService.deleteByName(name);
		
	}
	
	
}
