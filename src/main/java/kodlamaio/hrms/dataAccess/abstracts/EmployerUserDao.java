package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.EmployerUser;

@Repository
public interface EmployerUserDao extends JpaRepository<EmployerUser, Integer>{
	boolean existsByEmail(String email);
	
}
