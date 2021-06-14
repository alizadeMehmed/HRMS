package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidate_educations")
public class CandidateEducation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "school_name")
	private String schoolName;
	
	@Column(name = "faculty_name")
	private String facultyName;
	
	@Column(name = "graduate_date")
	private String graduateDate;
	
	@ManyToOne()
	@JoinColumn(name= "curriculum_vitae_id")
	private CurriculumVitaeForCandidate curriculumVitaeForCandidate;
	
	@ManyToOne()
	@JoinColumn(name= "candidate_id")
	private Candidate candidate;
}