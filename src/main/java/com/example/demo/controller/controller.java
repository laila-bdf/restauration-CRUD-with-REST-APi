package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;

@RestController
public class controller {

	@Autowired
	private ClientRepository clientrepository;
	
	
	@GetMapping("/clients")
	public List<Client> clients() {
		return clientrepository.findAll();
	}
	
	@GetMapping("/client/{id}")
	public Client findById(@PathVariable Long id) throws Exception{
	return clientrepository.findById(id).orElseThrow(()->new Exception("Client n'existe pas"));
	}
	
	@PostMapping()
	public Client saveClient(@RequestBody Client c) {
		return clientrepository.save(c);
	}
	
	@PutMapping("/{id}")
	public Client updateOrsaveClient(@RequestBody Client c ,@PathVariable Long id) {
		return clientrepository.findById(id).map(x->{
			x.setNom(c.getNom());
			x.setPrenom(c.getPrenom());
			return clientrepository.save(x);
		}).orElseGet(()->{
			c.setId(id);
			return clientrepository.save(c);
		});
	}
	
	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable Long id) {
		clientrepository.deleteById(id);
	}
	
	@PutMapping("/client/{idClient}/categorie/{idCategorie}")
	public Client cat_client(@PathVariable Long idClient, @PathVariable Long idCategorie) {
		
		Client cl = clientrepository.findById(idClient).get();
		//Categorie cate = categorierepository.findById(idCategorie).get();
		
	//	cl.getCat().add(cate);
		return clientrepository.save(cl);
		
	}
	
}