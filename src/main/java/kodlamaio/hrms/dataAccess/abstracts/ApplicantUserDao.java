package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ApplicantUser;

public interface ApplicantUserDao extends JpaRepository<ApplicantUser, Integer> {
	boolean existsByEmail(String email);
	boolean existsByNationalId(String nationalId);
	

}
