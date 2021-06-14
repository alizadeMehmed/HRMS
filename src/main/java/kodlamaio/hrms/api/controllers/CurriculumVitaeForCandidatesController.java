package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeForCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CurriculumVitaeForCandidate;
import kodlamaio.hrms.entities.dtos.CvWithCandidateAndEducationDto;
import kodlamaio.hrms.entities.dtos.CvWithCandidateAndExperienceWithDetailsDto;

@RestController
@RequestMapping("/api/cvsforcandidatecontroller")
public class CurriculumVitaeForCandidatesController {

	private CurriculumVitaeForCandidateService curriculumVitaeForCandidateService;

	@Autowired
	public CurriculumVitaeForCandidatesController(
			CurriculumVitaeForCandidateService curriculumVitaeForCandidateService) {
		super();
		this.curriculumVitaeForCandidateService = curriculumVitaeForCandidateService;

	}

	@GetMapping("/getall")
	public DataResult<List<CurriculumVitaeForCandidate>> getAll() {
		return this.curriculumVitaeForCandidateService.getAll();
	}

	@GetMapping("/getCvOrderByGraduateYear")
	DataResult<List<CvWithCandidateAndEducationDto>> getCvWithCandidateAndEducationOrderByGraduateYear() {
		return this.curriculumVitaeForCandidateService.getCvWithCandidateAndEducationOrderByGraduateYear();
	}
	
	@GetMapping("/getCvOrderByExperienceYear")
	DataResult<List<CvWithCandidateAndExperienceWithDetailsDto>> getCvWithCandidateAndExperienceWithDetailsOrderByExperienceYear() {
		return this.curriculumVitaeForCandidateService.getCvWithCandidateAndExperienceWithDetailsOrderByExperienceYear();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CurriculumVitaeForCandidate curriculumVitaeForCandidate) {
		return this.curriculumVitaeForCandidateService.add(curriculumVitaeForCandidate);
	}
}
