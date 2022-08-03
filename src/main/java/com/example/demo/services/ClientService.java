package com.example.demo.services;

import java.util.List;


import com.example.demo.dto.ClientDTO;
import com.example.demo.model.Client;

public interface ClientService {


	List<ClientDTO> getAllClient();
	ClientDTO saveClient(ClientDTO c);
	ClientDTO getClientById(Long id) throws Exception;
	
	String deleteClientById(Long id) throws Exception;
	void deleteAll();
	 
	ClientDTO updateClient(ClientDTO c, Long id) throws Exception;
	List<Client> getAllClient_parPage(int page );
	
	
	
}
