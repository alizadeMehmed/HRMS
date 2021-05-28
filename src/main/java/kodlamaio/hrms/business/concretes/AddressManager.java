package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AdressService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.AddressDao;
import kodlamaio.hrms.entities.concretes.Address;

@Service
public class AddressManager implements AdressService{

	private AddressDao addressDao;
	
	@Autowired
	public AddressManager(AddressDao addressDao) {
		super();
		this.addressDao = addressDao;
	}

	@Override
	public DataResult<List<Address>> getAll() {
		return new SuccessDataResult<List<Address>>(this.addressDao.findAll(), "Data listelendi");
	}

	
	@Override
	public Result add(Address address) {
		this.addressDao.save(address);
		return new SuccessResult("Adress eklendi");
	}

	

}
