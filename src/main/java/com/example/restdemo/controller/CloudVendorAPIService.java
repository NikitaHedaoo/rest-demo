package com.example.restdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restdemo.model.CloudVendor;

import lombok.extern.java.Log;


// @RestController : to tell Spring that this is our Rest controller class
// @RequestMapping : to map context path as /cloudvendor
@Log
@RestController
@RequestMapping("/cloudvendor") 
public class CloudVendorAPIService {

	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(CloudVendorAPIService.class.getName());
	
	//method for getting values
	//will search based on vendor id
	//will return complete object
	//@GetMapping annotation tells Spring this is the get API/service
	
	CloudVendor cloudVendor;
	
	@GetMapping("/")
	public String getMsg() {
		return "Welcome to Cloud Vendor API Service";
	}
	
	
	@GetMapping("{vendorId}")
	public CloudVendor getCloudVendorDetails(String vendorId) {
				
		return cloudVendor;
//				new CloudVendor("C1","Vendor 1",
//				"Address 1","xxxxx");
	}
	
	@PostMapping
	public String createCloudVendor(@RequestBody CloudVendor cloudVendor) {
		this.cloudVendor = cloudVendor;
		log.info("Cloud vendor " + cloudVendor.getvendorId() + " created successfully");
		return "Cloud vendor created successfully";
	}
	
}
