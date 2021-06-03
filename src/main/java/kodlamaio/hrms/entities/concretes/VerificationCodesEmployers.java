package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "verification_code_employers")
@PrimaryKeyJoinColumn(name= "id")
public class VerificationCodesEmployers extends VerifcationCode{

	@Column(name = "employer_id")
	private int employerId;


}