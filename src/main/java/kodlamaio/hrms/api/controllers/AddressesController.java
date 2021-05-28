package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AdressService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Address;

@RestController
@RequestMapping("/api/addresses")
public class AddressesController {

	private AdressService adressService;

	public AddressesController(AdressService adressService) {
		super();
		this.adressService = adressService;
	}
	
	@GetMapping
	public DataResult<List<Address>> getAll(){
		return this.adressService.getAll();
	}
	
	@PostMapping
	public Result add(Address address) {
		return this.adressService.add(address);
	}

}
