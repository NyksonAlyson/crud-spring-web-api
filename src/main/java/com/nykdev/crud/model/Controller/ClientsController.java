package com.nykdev.crud.model.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nykdev.crud.model.Clients;
import com.nykdev.crud.repository.ClientsRepository;


@RestController
@RequestMapping(value = "/clients")
public class ClientsController {
	
	@Autowired
	ClientsRepository clientsRepository;

	@GetMapping 
	public ResponseEntity<List<Clients>> findClients(){
		List<Clients> findClients = clientsRepository.findAll();
		return ResponseEntity.ok(findClients);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Clients>findByiD(@PathVariable Long id){
		return clientsRepository.findById(id);
	}
	
	@DeleteMapping(path = "/{id}")
	public void ExcluirClients(@PathVariable Long id) {
		clientsRepository.deleteById(id);
	}
	
	@PutMapping
	public Clients AlterarClients(@Valid Clients clients) {
		clientsRepository.save(clients);
		return clients;
	}
	@PostMapping
	public Clients insertClients(@RequestBody @Valid Clients clients) {
		clientsRepository.save(clients);
		return clients;
	}
}
