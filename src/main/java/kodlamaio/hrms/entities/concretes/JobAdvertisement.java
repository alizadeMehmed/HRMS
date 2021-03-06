package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_advertisements")
@Entity
public class JobAdvertisement {

	public JobAdvertisement(@NotNull @NotBlank String description, @NotNull @NotBlank int openPositionCount,
			LocalDate lastRegisterDate, List<JobTitle> jobTitles, List<City> cities) {
		super();
		this.description = description;
		this.openPositionCount = openPositionCount;
		this.lastRegisterDate = lastRegisterDate;
		this.jobTitles = jobTitles;
		this.cities = cities;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_advertisement_id")
	@NotNull
	@NotBlank
	private int id;

	@Column(name = "job_advertisement_name")
	@NotNull
	@NotBlank
	private String name;

	@Column(name = "job_description")
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

	@Column(name = "posting_date")
	private LocalDate postingDate = LocalDate.now();

	@Column(name = "last_register_date")
	private LocalDate lastRegisterDate;

	@Column(name = "is_active")
	private boolean isActive;

	@OneToMany(mappedBy = "jobAdvertisement")
	private List<JobTitle> jobTitles;

	@OneToMany(mappedBy = "jobAdvertisement")
	private List<City> cities;

	@OneToMany(mappedBy = "jobAdvertisement")
	private List<Employer> employers;

}