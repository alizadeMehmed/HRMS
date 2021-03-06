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
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_titles")
public class JobTitle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int titleId;

	@Column(name = "title")
	private String titleName;
	
	//İlerleyen süreçte OneToOne ilişkilendirmesi yapılacak
	@Column(name = "employer_id")
	private int employerId;
	
	@ManyToOne()
	@JoinColumn(name= "job_advertisement_id")
	private JobAdvertisement jobAdvertisement;
	
	@ManyToOne()
	@JoinColumn(name= "experience_id")
	private Experience experience;
}
