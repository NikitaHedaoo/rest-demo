package com.example.restdemo.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.restdemo.model.CloudVendor;
import com.example.restdemo.repository.CloudVendorRepository;
import com.example.restdemo.service.CloudVendorService;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {
	
	//we need this instance because repository is a layer which is actually talking to db
	CloudVendorRepository cloudVendorRepository;

	//Autowiring using constructor
	public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
		this.cloudVendorRepository = cloudVendorRepository;
	}
	
	@Override
	public String createCloudVendor(CloudVendor cloudVendor) {
		//More business logic
		cloudVendorRepository.save(cloudVendor); //saves a given entity to the db
		return "Creation Success";
	}

	@Override
	public String updateCloudVendor(CloudVendor cloudVendor) {
		//More business logic
		cloudVendorRepository.save(cloudVendor); //update also saves a given entity to the db
		return "Updation Success";
	}

	@Override
	public String deleteCloudVendor(String cloudVendorId) {
		// Be very careful
		//More business logic
		cloudVendorRepository.deleteById(cloudVendorId);
		return "Deletion Success";
	}

	@Override
	public CloudVendor getCloudVendor(String cloudVendorId) {
		//More business logic
		CloudVendor cloudVendor = cloudVendorRepository.findById(cloudVendorId).get();
		return cloudVendor;
	}

	@Override
	public List<CloudVendor> getAllCloudVendor() {
		//More business logic
		List<CloudVendor> cloudVendorList = cloudVendorRepository.findAll();
		return cloudVendorList;
	}

}
