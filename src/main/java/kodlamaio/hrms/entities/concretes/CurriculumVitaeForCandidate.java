package kodlamaio.hrms.entities.concretes;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "curriculum_vitaes")
public class CurriculumVitaeForCandidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_id")
	private int id;

	@Column(name="git_hub_address")
	private String gitHubAddress;
	
	@Column(name="linked_in_address")
	private String linkedInAddress;
	
	@Column(name="it_techniques")
	private String itTechniques;
	
	@Column(name="programming_language")
	private String programmingLanguage;
	
	@Column(name= "details")
	private String detail;
	
	@OneToMany(mappedBy ="curriculumVitaeForCandidate")
	private List<Candidate> candidates;
	
	@OneToMany(mappedBy="curriculumVitaeForCandidate")
	private List<Experience> experiences;
	
	@OneToMany(mappedBy="curriculumVitaeForCandidate")
	private List<CandidateEducation> educations;
	
	@OneToMany(mappedBy="curriculumVitaeForCandidate")
	private List<Language> languages;	
	
	@OneToMany(mappedBy="curriculumVitaeForCandidate")
	private List<Image> images;	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
