package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobTitleDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	JobAdvertisement getByIsActive(boolean isActive);

	List<JobAdvertisement> getByIsActiveAndEmployerName(boolean isActive, String employerName);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobTitleDto(em.name, jt.titleName, ja.openPositionCount, ja.postingDate, ja.lastRegisterDate) From JobAdvertisement ja Inner Join ja.employer em Inner Join ja.jobTitle jt")
	List<JobAdvertisementWithEmployerWithJobTitleDto> getJobAdvertisementWithEmployerWithJobTitleDetails();
}
