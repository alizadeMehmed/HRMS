package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementWithDetailsDto {
	private String companyName;
	private String titleName;
	private int openPositionCount;
	private LocalDate postingDate;
	private LocalDate lastRegisterDate;
	
	
}
