package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateEducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateEducation;

@RestController
@RequestMapping("/api/candidateeducations")
public class CandidateEducationsController {
	CandidateEducationService candidateEducationService;
	
	@Autowired
	public CandidateEducationsController(CandidateEducationService candidateEducationService) {
		super();
		this.candidateEducationService = candidateEducationService;
	}
	
	@GetMapping("/getByFacultyNameOrderByGraduateYearDesc")
	public DataResult<List<CandidateEducation>> getByFacultyNameOrderByGraduateYearDesc(String facultyName){
			
		return this.candidateEducationService.getByFacultyNameOrderByGraduateYearDesc(facultyName);
		
	}
	
}
