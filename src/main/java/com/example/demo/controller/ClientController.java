package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ClientDTO;
import com.example.demo.services.ClientService;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

	@Autowired
	private ClientService clientservice;

	@GetMapping
	public ResponseEntity<Page<ClientDTO>> findAll(Pageable page) {
		return new ResponseEntity<>(clientservice.findAll(page), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
		return new ResponseEntity<>(clientservice.findById(id), HttpStatus.OK);
	}

	@PostMapping
	ResponseEntity<ClientDTO> save(@RequestBody ClientDTO client) {
		return new ResponseEntity<>(clientservice.save(client), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	ResponseEntity<String> delete(@PathVariable Long id) {
		clientservice.deleteClientById(id);
		return new ResponseEntity<>("Done: Client deleted successfully", HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClientDTO> updateClient(@RequestBody ClientDTO client, @PathVariable Long id) {
		return ResponseEntity.accepted().body(clientservice.updateClient(client, id));
	}

}
