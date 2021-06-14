package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.CurriculumVitaeForCandidate;
import kodlamaio.hrms.entities.dtos.CvWithCandidateAndEducationDto;
import kodlamaio.hrms.entities.dtos.CvWithCandidateAndExperienceWithDetailsDto;

@Repository
public interface CurriculumVitaeForCandidateDao extends JpaRepository<CurriculumVitaeForCandidate, Integer>{

	@Query("Select new kodlamaio.hrms.entities.dtos.CvWithCandidateAndEducationDto"
			+ "(cv.id, cnd.firstName, cnd.lastName, edu.schoolName, edu.facultyName, edu.graduateDate) "
			+ "From CurriculumVitaeForCandidate cv "
			+ "Inner Join cv.candidates cnd "
			+ "Inner Join cv.educations edu "
			+ "Order By edu.graduateDate desc ")
	List<CvWithCandidateAndEducationDto> getCvWithCandidateAndEducationOrderByGraduateDate();
	
	
	
	@Query("Select new kodlamaio.hrms.entities.dtos.CvWithCandidateAndExperienceWithDetailsDto"
			+ "(cv.id, cnd.firstName, cnd.lastName, cnd.identityNumber, exp.experienceName, "
			+ "exp.experienceYear, exp.details) "
			+ "From CurriculumVitaeForCandidate cv "
			+ "Inner Join cv.candidates cnd "
			+ "Inner Join cv.experiences exp "
			+ "Order By exp.experienceYear desc")
	List<CvWithCandidateAndExperienceWithDetailsDto> getCvWithCandidateAndExperienceWithDetailsOrderByExperienceYear();
	
	
	@Query("From CurriculumVitaeForCandidate cv "
			+ "Inner Join cv.candidates cnd "
			+ "Inner Join cv.experiences exp "
			+ "where cnd.identityNumber= : identityNumber")
	List<CurriculumVitaeForCandidate> getByIdentityNumber(String identityNumber);
}
