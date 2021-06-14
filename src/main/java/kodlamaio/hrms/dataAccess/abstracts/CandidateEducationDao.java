package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.CandidateEducation;

@Repository
public interface CandidateEducationDao extends JpaRepository<CandidateEducation, Integer>{
	
	List<CandidateEducation> getByFacultyNameOrderByGraduateDateDesc(String facultyName);
	
	
	
}
