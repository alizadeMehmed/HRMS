package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.JobTitle;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithDetailsDto;

@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementWithDetailsDto"
			+ "(e.companyName, t.titleName, j.openPositionCount, j.postingDate, j.lastRegisterDate)"
			+ "From JobAdvertisement j " + "Inner Join j.jobTitles t " + "Inner Join j.employers e")
	List<JobAdvertisementWithDetailsDto> getByIsActive(boolean isActive);

	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementWithDetailsDto"
			+ "(e.companyName, t.titleName, j.openPositionCount, j.postingDate, j.lastRegisterDate)"
			+ "From JobAdvertisement j " + "Inner Join j.jobTitles t " + "Inner Join j.employers e")
	List<JobAdvertisementWithDetailsDto> getByIsActiveAndEmployers_companyName(boolean isActive, String companyName);

	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementWithDetailsDto"
			+ "(e.companyName, t.titleName, j.openPositionCount, j.postingDate, j.lastRegisterDate)"
			+ "From JobAdvertisement j " + "Inner Join j.jobTitles t " + "Inner Join j.employers e")
	List<JobAdvertisementWithDetailsDto> getByIsActiveOrderByPostingDateAsc(boolean isActive);

	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementWithDetailsDto"
			+ "(e.companyName, t.titleName, j.openPositionCount, j.postingDate, j.lastRegisterDate)"
			+ "From JobAdvertisement j " + "Inner Join j.jobTitles t " + "Inner Join j.employers e")
	List<JobAdvertisementWithDetailsDto> getByIsActiveOrderByPostingDateDesc(boolean isActive);

	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementWithDetailsDto"
			+ "(e.companyName, t.titleName, j.openPositionCount, j.postingDate, j.lastRegisterDate)"
			+ "From JobAdvertisement j " + "Inner Join j.jobTitles t " + "Inner Join j.employers e")
	List<JobAdvertisementWithDetailsDto> getJobAdvertisementWithEmployersAndJobTitlesDetails();

	
}
