package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PersonCheckService;
@Service
public class PersonCheckManager implements PersonCheckService {

	@Override
	public boolean checkIfRealPerson(String identityNumber, String firstName, String lastName, int birthYear) {

		// Mernis Check Simulation
		return true;
	}

}
