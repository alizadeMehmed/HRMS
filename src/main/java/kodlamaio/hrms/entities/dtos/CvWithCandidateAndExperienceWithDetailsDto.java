package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvWithCandidateAndExperienceWithDetailsDto {
   
	public int id;
	public String firstName;
	public String lastName;
	public String identityNumber;
	public String experienceName;
	public int experienceYear;
	public String details;
}
