package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvWithCandidateAndEducationDto {
   private int id;
   private String firstName;
   private String lastName;
   private String facultyName;
   private String schoolName;
   private String graduateDate;
   
}
