package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "experiences")
public class Experience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "experience_id")
	private int id;

	@Column(name = "experience_name")
	private String experienceName;

	@OneToMany(mappedBy = "experience")
	private List<JobTitle> jobTitles;

	@Column(name = "year_of_employment")
	private String yearOfEmployment;

	@Column(name = "year_off")
	private String yearOff;
	
	@Column(name = "experience_year")
	private int experienceYear;

	@Column(name = "details")
	private String details;
	
	@ManyToOne()
	@JoinColumn(name= "curriculum_vitae_id")
	private CurriculumVitaeForCandidate curriculumVitaeForCandidate;
	
	@OneToOne(mappedBy = "experience")
	private Candidate candidate;
}
