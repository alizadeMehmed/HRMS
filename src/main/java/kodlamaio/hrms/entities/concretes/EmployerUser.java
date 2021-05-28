package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employer")
@PrimaryKeyJoinColumn(name="user_id")
public class EmployerUser extends User {

	@Column(name = "employerId")
	private int id;
	
	@Column(name = "companyName")
	private String companyName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "website")
	private String webSite;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "isEmailVerified")
	private boolean isEmailVerified;
	
	@Column(name = "isHrmsVerified")
	private boolean isHrmsVerified;
    
	private String passwordRepeat;
}
