package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "candidates")
public class Candidate extends User {
	
	@Column(name = "first_name")
	@NotNull
	@NotBlank
	private String firstName;
	
	@Column(name = "last_name")
	@NotNull
	@NotBlank
	private String lastName;
	
	@Column(name = "birth_year")
	@NotNull
	@NotBlank
	private int birthYear;
	
	@Column(name = "identity_number")
	@NotNull
	@NotBlank
	private String identityNumber;
	
	@ManyToOne()
	@JoinColumn(name= "curriculum_vitae_id")
	private CurriculumVitaeForCandidate curriculumVitaeForCandidate;
	
	@OneToMany(mappedBy= "candidate")
	private List<CandidateEducation> candidateEducations;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "experience_id")
	private Experience experience;
	
}
