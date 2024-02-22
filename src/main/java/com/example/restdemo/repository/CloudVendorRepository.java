package com.example.restdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restdemo.model.CloudVendor;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String>{

//JpaRepository provides methods to save in db

}
