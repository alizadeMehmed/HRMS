package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "users")

public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@NotNull
	@NotBlank
	private int id;

	@Column(name = "job_advertisement_name")
	@NotNull
	@NotBlank
	private String name;

	@Column(name = "job_advertisement_description")
	@NotNull
	@NotBlank
	private String description;

	@Column(name = "min_salary")
	private double minSalary;

	@Column(name = "max_salary")
	private double maxSalary;
	
	@Column(name = "open_position_count")
	@NotNull
	@NotBlank
	private int openPositionCount;
	
	@Column(name= "posting_date")
	private LocalDate postingDate;
	
	@Column(name= "last_register_date")
	private LocalDate lastRegisterDate;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@OneToMany(mappedBy= "employer")
	private List<Employer> employers;
	
	@OneToMany(mappedBy= "job_titles")
	private List<JobTitle> jobtitles;
	
	@OneToMany(mappedBy= "cities")
	private List<City> cities;
}