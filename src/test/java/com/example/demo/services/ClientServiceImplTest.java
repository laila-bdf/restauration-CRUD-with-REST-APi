package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.ClientDTO;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.Client;


@SpringBootTest
class ClientServiceImplTest {

		@Autowired
		private ClientService clientService;
		
		
		
		@AfterEach
		public  void cleanUpEach(){
			clientService.deleteAll();
		}
		
		
		@Test
		public void testGetAllClient_Pass() {
		
			List<ClientDTO> clientList = buildClients() ;
			clientList.forEach(e ->clientService.saveClient(e) );
			
			List<ClientDTO> savedList = clientService.getAllClient();
	        
			assertEquals(clientList.size(),savedList.size());
		}
		
		@Test
		public void testGetAllClient_parPage_Pass() {
		
			List<ClientDTO> clientList = buildClients() ;
			clientList.forEach(e ->clientService.saveClient(e) );
			
			List<Client> savedList = clientService.getAllClient_parPage(0,2);
	        
			assertEquals(clientList.size(),savedList.size());
		}
		
		
		@Test
		public void testSaveClient_Pass()
		{	
			ClientDTO expecetedClient = new  ClientDTO();
			expecetedClient.setNom("nomTest");
			expecetedClient.setPrenom("prenom");
			expecetedClient.setDateNaiss(new Date(0));
			
			ClientDTO savedClient = clientService.saveClient(expecetedClient);
			
			assertNotNull(savedClient);
			assertNotNull(savedClient.getId());
			assertEquals(expecetedClient.getNom(), savedClient.getNom());
			assertEquals(expecetedClient.getPrenom(), savedClient.getPrenom());
			assertEquals(expecetedClient.getDateNaiss(), savedClient.getDateNaiss());					
		}
		
		@Test
		public void testSaveClient_Fail() {
			
		}
		
		@Test
		public void testUpdateClient_Pass() throws Exception
		{	
			ClientDTO expecetedClient = new  ClientDTO();
			expecetedClient.setNom("nomTest");
			expecetedClient.setPrenom("prenom");
			expecetedClient.setDateNaiss(new Date(0));
			
			ClientDTO savedClient = clientService.saveClient(expecetedClient);
			
			ClientDTO clientUpdated = savedClient;
			clientUpdated.setNom("nom updated");
			
			ClientDTO cl_updated = clientService.updateClient(clientUpdated, clientUpdated.getId());
			
			assertNotNull(cl_updated);
			assertEquals(clientUpdated.getId(), cl_updated.getId());
			assertEquals(clientUpdated.getNom(), cl_updated.getNom());
			assertEquals(clientUpdated.getPrenom(), cl_updated.getPrenom());
			assertEquals(clientUpdated.getDateNaiss(), cl_updated.getDateNaiss());				
		}

		@Test
		public void testUpdateClient_Fail() throws Exception 
		{
			ClientDTO client = new  ClientDTO();
			client.setNom("hane");
			client.setPrenom("hanae");
			client.setDateNaiss(new Date(0));
			
			assertThrows(EntityNotFoundException.class, ()-> {clientService.updateClient(client, 0L);});
		}
		@Test
		public void testUpdateClient_NomisNull_Pass() throws Exception {
			
			
			ClientDTO expecetedClient = new  ClientDTO();
			expecetedClient.setNom("nomTest");
			expecetedClient.setPrenom("prenom");
			expecetedClient.setDateNaiss(new Date(0));
			
			ClientDTO savedClient = clientService.saveClient(expecetedClient);
			
			ClientDTO updatedClient = new  ClientDTO();
			updatedClient.setId(savedClient.getId());
			updatedClient.setPrenom("prenom");
			updatedClient.setDateNaiss(new Date(0));
			
			
			ClientDTO cl_updated = clientService.updateClient(updatedClient, updatedClient.getId());
			
			assertNotNull(cl_updated);
			assertEquals(updatedClient.getId(), cl_updated.getId());
			assertEquals(savedClient.getNom(), cl_updated.getNom());
			assertEquals(updatedClient.getPrenom(), cl_updated.getPrenom());
			assertEquals(updatedClient.getDateNaiss(), cl_updated.getDateNaiss());

		}
		@Test
		public void testUpdateClient_PrenomisNull_Pass() throws Exception {
			
			
			ClientDTO expecetedClient = new  ClientDTO();
			expecetedClient.setNom("nomTest");
			expecetedClient.setPrenom("prenom");
			expecetedClient.setDateNaiss(new Date(0));
			
			ClientDTO savedClient = clientService.saveClient(expecetedClient);
			
			ClientDTO updatedClient = new  ClientDTO();
			updatedClient.setId(savedClient.getId());
			updatedClient.setNom("Nom");
			updatedClient.setDateNaiss(new Date(0));
			
			
			ClientDTO cl_updated = clientService.updateClient(updatedClient, updatedClient.getId());
			
			assertNotNull(cl_updated);
			assertEquals(updatedClient.getId(), cl_updated.getId());
			assertEquals(updatedClient.getNom(), cl_updated.getNom());
			assertEquals(savedClient.getPrenom(), cl_updated.getPrenom());
			assertEquals(updatedClient.getDateNaiss(), cl_updated.getDateNaiss());

		}
		@Test
		public void testUpdateClient_DateisNull_Pass() throws Exception {
			
			
			ClientDTO expecetedClient = new  ClientDTO();
			expecetedClient.setNom("nomTest");
			expecetedClient.setPrenom("prenom");
			expecetedClient.setDateNaiss(new Date(0));
			
			ClientDTO savedClient = clientService.saveClient(expecetedClient);
			
			ClientDTO updatedClient = new  ClientDTO();
			updatedClient.setId(savedClient.getId());
			updatedClient.setPrenom("prenom");
			updatedClient.setNom("Nom");
			
			ClientDTO cl_updated = clientService.updateClient(updatedClient, updatedClient.getId());
			
			assertNotNull(cl_updated);
			assertEquals(updatedClient.getId(), cl_updated.getId());
			assertEquals(updatedClient.getNom(), cl_updated.getNom());
			assertEquals(updatedClient.getPrenom(), cl_updated.getPrenom());
			assertEquals(savedClient.getDateNaiss(), cl_updated.getDateNaiss());

		}
		@Test
		public void testUpdateClient_NomisEmpty_Pass() throws Exception {
			
			
			ClientDTO expecetedClient = new  ClientDTO();
			expecetedClient.setNom("nomTest");
			expecetedClient.setPrenom("prenom");
			expecetedClient.setDateNaiss(new Date(0));
			
			ClientDTO savedClient = clientService.saveClient(expecetedClient);
			
			ClientDTO updatedClient = new  ClientDTO();
			updatedClient.setId(savedClient.getId());
			updatedClient.setPrenom("prenom");
			updatedClient.setDateNaiss(new Date(0));
			updatedClient.setNom("");
			
			ClientDTO cl_updated = clientService.updateClient(updatedClient, updatedClient.getId());
			
			assertNotNull(cl_updated);
			assertEquals(updatedClient.getId(), cl_updated.getId());
			assertEquals(savedClient.getNom(), cl_updated.getNom());
			assertEquals(updatedClient.getPrenom(), cl_updated.getPrenom());
			assertEquals(updatedClient.getDateNaiss(), cl_updated.getDateNaiss());

		}
		@Test
		public void testUpdateClient_PrenomisEmpty_Pass() throws Exception {
			
			
			ClientDTO expecetedClient = new  ClientDTO();
			expecetedClient.setNom("nomTest");
			expecetedClient.setPrenom("prenom");
			expecetedClient.setDateNaiss(new Date(0));
			
			ClientDTO savedClient = clientService.saveClient(expecetedClient);
			
			ClientDTO updatedClient = new  ClientDTO();
			updatedClient.setId(savedClient.getId());
			updatedClient.setPrenom("");
			updatedClient.setDateNaiss(new Date(0));
			updatedClient.setNom("Nom");
			
			ClientDTO cl_updated = clientService.updateClient(updatedClient, updatedClient.getId());
			
			assertNotNull(cl_updated);
			assertEquals(updatedClient.getId(), cl_updated.getId());
			assertEquals(updatedClient.getNom(), cl_updated.getNom());
			assertEquals(savedClient.getPrenom(), cl_updated.getPrenom());
			assertEquals(updatedClient.getDateNaiss(), cl_updated.getDateNaiss());

		}
		
		@Test
		public void testGetClientById_Pass() throws Exception {
			ClientDTO client = new  ClientDTO();
			client.setNom("bouadif");
			client.setPrenom("laila");
			client.setDateNaiss(new Date(0));
			
			ClientDTO savedClient = clientService.saveClient(client);
			
			ClientDTO foundClient =clientService.getClientById(savedClient.getId());
			
			assertNotNull(foundClient);
			assertEquals(foundClient.getId(), savedClient.getId());
			
			
		}
		
		@Test
		public void testGetClientById_Fail() {
			 assertThrows(EntityNotFoundException.class, ()-> clientService.getClientById(0L));
		}
		
		
		@Test
		public void testDeleteClientById_Pass() throws Exception {
			ClientDTO expecetedClient = new  ClientDTO();
			expecetedClient.setNom("bdf");
			expecetedClient.setPrenom("safae");
			expecetedClient.setDateNaiss(new Date(0));
			
			ClientDTO savedClient = clientService.saveClient(expecetedClient);
			clientService.deleteClientById(savedClient.getId());
			
			 assertThrows(EntityNotFoundException.class, ()-> clientService.getClientById(savedClient.getId()));
				
			
		}
		@Test
		public void testDeleteClientById_Fail() {
			 assertThrows(EntityNotFoundException.class, ()-> clientService.deleteClientById(0L));
				
		}
		
		
		private List<ClientDTO> buildClients() {
	    	ClientDTO client1 = new ClientDTO();
	    	client1.setNom("bouadif");
	    	client1.setPrenom("ayoub");
	    	ClientDTO client2 = new ClientDTO();
	    	client2.setNom("bouadif");
	    	client2.setPrenom("safae");
			List<ClientDTO> cltList = Arrays.asList(client1, client2);
			return cltList;
		}

		
		
}
