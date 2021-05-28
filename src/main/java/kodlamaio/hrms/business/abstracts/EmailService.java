package kodlamaio.hrms.business.abstracts;

public interface EmailService {
	
	boolean isEmailValid(String email);
	void sendMail(String message);
	boolean isEmailActivated(String email);
}
