package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ApplicantUserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ApplicantUser;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantUsersController {

	private ApplicantUserService applicantUserService;

	@Autowired
	public ApplicantUsersController(ApplicantUserService applicantUserService) {
		super();
		this.applicantUserService = applicantUserService;
	}

	@GetMapping("/getall")
	public DataResult<List<ApplicantUser>> getAll() {
		return this.applicantUserService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody ApplicantUser applicantUser) {
		return this.applicantUserService.add(applicantUser);

	}

}
