package kodlamaio.hrms.business.abstracts;

public interface PersonCheckService {
	boolean checkIfRealPerson(String nyNumber, String firstName, String lastName, int birthYear);
}
