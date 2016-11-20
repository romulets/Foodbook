package com.foodbook.repositories;

import org.springframework.stereotype.Repository;

import com.foodbook.models.Address;

@Repository
public class AddressRepository extends AbstractRepository<Address> {

	public AddressRepository() {
		super(Address.class);
	}
	
}
