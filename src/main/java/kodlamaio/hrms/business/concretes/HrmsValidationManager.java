package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.HrmsValidationService;

@Service
public class HrmsValidationManager implements HrmsValidationService {

	@Override
	public boolean isValid() {
		System.out.println("Hrms ile doğrulama gerçekleştirildi");
		return true;
	}

	

}
