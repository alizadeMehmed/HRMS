package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ApplicantUser;


public interface ApplicantUserService {
	DataResult<List<ApplicantUser>> getAll();
	Result add(ApplicantUser applicantuser);
}
