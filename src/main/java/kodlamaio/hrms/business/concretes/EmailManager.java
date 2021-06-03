package kodlamaio.hrms.business.concretes;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailService;

@Service
public class EmailManager implements EmailService {
	private static final String mailPattern = "^[A-Z0-9._+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)?$";
	private static Pattern pattern = Pattern.compile(mailPattern, Pattern.CASE_INSENSITIVE);
	
	@Override
	public boolean isEmailValid(String email) {
		if (!email.isEmpty()) {
			return pattern.matcher(email).find();
		}
		
		return false;
	}
	@Override
	public void sendMail(String email) {
		System.out.println("Mail gönderildi" + email);
	}
	@Override
	public boolean isEmailActivated(String email) {
		// Email Activation Simulation
		//Buraya daha sonra doğrulama kodu ile ilgili işlemler yapılacak
		//Doğrulama kodu oluşturma ve isActivated bölümüne giriş yapılacak
		return true;
	}
	
	

	

	
	

}
