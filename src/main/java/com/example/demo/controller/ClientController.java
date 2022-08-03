package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ClientDTO;
import com.example.demo.model.Client;
import com.example.demo.services.ClientService;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

		
		@Autowired
		private ClientService clientservice;
		
		@GetMapping
	    public ResponseEntity<List<ClientDTO>> allclient()
	    {		return new ResponseEntity<>(clientservice.getAllClient(),HttpStatus.OK);		
			
	    }
		@GetMapping("/page")
		public ResponseEntity<List<Client>> getAllClient_parPage(@RequestParam("page") int page ) {
			return new ResponseEntity<>(clientservice.getAllClient_parPage(page),HttpStatus.OK);
		}
		
		
		@GetMapping("{id}")
		public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) throws Exception  {
				return new ResponseEntity<>(clientservice.getClientById(id),HttpStatus.OK);		
		}
		
		@PostMapping
		ResponseEntity<ClientDTO> save(@RequestBody ClientDTO c)
		{
		        return new  ResponseEntity<>(clientservice.saveClient(c),HttpStatus.CREATED);
		}
		
		@DeleteMapping("{id}")
		ResponseEntity<String> delete(@PathVariable Long id) throws Exception
		{
			clientservice.deleteClientById(id);;
		    return  new ResponseEntity<>("Done: Client deleted successfully",HttpStatus.OK);
		}
		
		@PutMapping("{id}")
		public ResponseEntity<ClientDTO> updateClient(@RequestBody ClientDTO c ,@PathVariable Long id) throws Exception {
			return ResponseEntity.accepted().body(clientservice.updateClient(c, id));
}
	
}
