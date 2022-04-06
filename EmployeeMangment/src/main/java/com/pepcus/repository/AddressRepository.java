package com.pepcus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pepcus.model.Address;
@Repository
public interface  AddressRepository extends JpaRepository<Address,Long>{
	
}