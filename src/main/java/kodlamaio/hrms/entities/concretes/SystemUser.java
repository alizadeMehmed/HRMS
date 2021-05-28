package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "systemUser")

public class SystemUser extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "systemUserId")
	private int id;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "birthYear")
	private int birthYear;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;

	@Column(name = "TcKimlikNo")
	private String nationalId;
	
	private String passwordRepeat;
	
}
