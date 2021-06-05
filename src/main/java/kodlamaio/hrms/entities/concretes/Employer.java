package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name= "id")
@Table(name = "employers")
public class Employer extends User {

	@Column(name = "company_name")
	@NotNull
	@NotBlank
	private String companyName;
	
	@Column(name = "web_address")
	@NotNull
	@NotBlank
	private String webAddress;
	
	@Column(name = "phone_number")
	@NotNull
	@NotBlank
	private String phoneNumber;
	
	@ManyToOne()
	@JoinColumn(name= "job_advertisement_id")
	private JobAdvertisement jobAdvertisement;
	
}