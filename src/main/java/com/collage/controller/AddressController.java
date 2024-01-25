package com.collage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.collage.entity.Address;
import com.collage.repository.AddressRepo;

@RestController
public class AddressController {

	@Autowired
	public AddressRepo AddressRepo;
	
	@PostMapping("/save-address")
	public String addAddress(@RequestBody Address address) {
		AddressRepo.save(address);
		return "Address save Successfully";
	}
	@GetMapping("/get-address")
	public List<Address> getAddress(){
		return AddressRepo.findAll();
	}
	
	@DeleteMapping("/delete-address-by-cityname")
	public String deleteAddress(@RequestParam("cityName") String cityName) {
		AddressRepo.deleteCityByName(cityName);
		return "Address deleted Succsessfully...";
	}
	
	@PutMapping("/update-pincode")
	public String updatePinCode(@RequestParam String oldpin, @RequestParam String newpin) {
		int updatecount = AddressRepo.updatePincode(oldpin, newpin);
		return updatecount + " Pin Code update Succsessfully ";
	}
	
	
}
