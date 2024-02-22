package com.example.restdemo.model;

import jakarta.persistence.Entity; //Here in my case, I tried to import javax.persistence, but It shows, It doesn’t exist. So I found the following solution. I hope. It will help in your case as well. The main reason for this problem is the replacement of javax with jakarta. Therefore the solution is to add the following dependency to your pom.xml.
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cloud_vendor_info") //if nothing specified then table with class name will be created
public class CloudVendor {
	
	@Id
	private String vendorId;  // In DB, we should find columns like vendor_id
	private String vendorName;
	private String vendorAddress;
	private String vendorPhoneNumber;
	

	public CloudVendor() {
	}

	public CloudVendor(String vendorId, String vendorName, String vendorAddress,
	String vendorPhoneNumber)
	{
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorAddress = vendorAddress;
		this.vendorPhoneNumber = vendorPhoneNumber;
	}
	public String getvendorId()
	{
		return vendorId;
	}
	public void setvendorId(String vendorId) {
		this.vendorId = vendorId ;	
	}
	
	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getVendorPhoneNumber() {
		return vendorPhoneNumber;
	}

	public void setVendorPhoneNumber(String vendorPhoneNumber) {
		this.vendorPhoneNumber = vendorPhoneNumber;
	}
	
}
