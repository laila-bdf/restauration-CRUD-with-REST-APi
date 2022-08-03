package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.example.demo.dto.ClientDTO;
import com.example.demo.services.ClientServiceImpl;

@SpringBootTest
class ClientControllerTest {

	@Autowired
	private ClientController clientController;

	@MockBean
	ClientServiceImpl clientService;
	
	
	@Test
	public void testallclient_OK() {
		
	}
	
	@Test
	public void testSave_Ok() {

		ClientDTO expectedClient = new ClientDTO();
		expectedClient.setNom("anas");
		expectedClient.setPrenom("anas");
		when(clientService.saveClient(any(ClientDTO.class))).thenReturn(expectedClient);

		ResponseEntity<ClientDTO> returnedClient = clientController.save(expectedClient);
		
		assertEquals(expectedClient.getNom(),returnedClient.getBody().getNom());
		

	}
	

	@Test
	public void testGetClientById_Pass() throws Exception {
		ClientDTO client = new  ClientDTO();
		client.setNom("bouadif");
		client.setPrenom("laila");
		client.setDateNaiss(new Date(0));
		
		when(clientService.getClientById(any(Long.class))).thenReturn(client);
		
		
		ResponseEntity<ClientDTO> returnedClient = clientController.getClientById(1L);
		
		assertNotNull(returnedClient);
		assertEquals(client.getNom(), returnedClient.getBody().getNom() );
		
		
	}

}
