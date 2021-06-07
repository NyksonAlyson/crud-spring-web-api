package com.nykdev.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nykdev.crud.model.Clients;

public interface ClientsRepository extends JpaRepository<Clients, Long> {
	
	public Iterable<Clients>findByNameContaining(String findNAME);

}
