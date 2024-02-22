package com.example.restdemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restdemo.model.CloudVendor;
import com.example.restdemo.service.CloudVendorService;

import lombok.extern.java.Log;


// @RestController : to tell Spring that this is our Rest controller class responsible to expose all th Rest APIs
// @RequestMapping : to map context path as /cloudvendor
@Log
@RestController
@RequestMapping("/cloudvendor") 
public class CloudVendorController {

	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(CloudVendorController.class.getName());
	
	//method for getting values
	//will search based on vendor id
	//will return complete object
	//@GetMapping annotation tells Spring this is the get API/service
	
	//CloudVendor cloudVendor; not required
	
	CloudVendorService cloudVendorService;
	
	public CloudVendorController(CloudVendorService cloudVendorService) {
		this.cloudVendorService = cloudVendorService;
	}


	@GetMapping("/")
	public String getMsg() {
		return "Welcome to Cloud Vendor API Service";
	}
	
	// Read specific cloud vendor details from DB
	@GetMapping("{vendorId}")
	public CloudVendor getCloudVendorDetails(@PathVariable("vendorId")String vendorId) {
		return cloudVendorService.getCloudVendor(vendorId)	;
	}
	// Read all cloud vendor details from DB
	@GetMapping()
	public List<CloudVendor> getAllCloudVendorDetails(@PathVariable("vendorId")String vendorId) {
		return cloudVendorService.getAllCloudVendors();
	}
	
	@PostMapping
	public String createCloudVendor(@RequestBody CloudVendor cloudVendor) {
		cloudVendorService.createCloudVendor(cloudVendor) ;
		log.info("Cloud vendor " + cloudVendor.getvendorId() + " created successfully");
		return "Cloud vendor created successfully";
	}
	
	@PutMapping
	public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
		cloudVendorService.updateCloudVendor(cloudVendor) ;
		log.info("Cloud Vendor "+ cloudVendor.getvendorId() + " updated sccessfully");
		return "Cloud Vendor updated successfully";
	}

	@DeleteMapping("{vendorId}")
	public String deleteCloudVendorDetails(@PathVariable("vednorId")String vendorId) {
		cloudVendorService.deleteCloudVendor(vendorId);
		log.info("Cloud vendor deleted successfully");
		return "Cloud vendor deleted successfully";
	}
}
