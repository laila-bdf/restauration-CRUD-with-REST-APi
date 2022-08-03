package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ClientDTO;
import com.example.demo.exception.EntityNotFound;
import com.example.demo.mapper.ClientMapper;
import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientrepository;
	
	public static Logger log= LoggerFactory.getLogger(ClientServiceImpl.class);
	
	@Override
	public List<ClientDTO> getAllClient() {
		log.info("get all client");
		return clientrepository.findAll().stream().map(
				e-> ClientMapper.toDTO(e)).collect(Collectors.toList());
				
	}
	
	@Override
	public List<Client> getAllClient_parPage(int page) {
	
		return clientrepository.findAll(PageRequest.of(page, 5)).getContent();
				
	}
	
	@Override
	public ClientDTO getClientById(Long id)  throws Exception {

		Optional<Client> clientFD = clientrepository.findById(id);
		
		if(clientFD.isPresent()) {
			return ClientMapper.toDTO(clientFD.get());
		}
		else {
			log.error("client with id " + id + " not found");
			throw new EntityNotFound("client not found");
		}
		
	}

	
	
	@Override
	public ClientDTO saveClient(ClientDTO c) {
		//Client client = modelMapper.map(c, Client.class);
		return ClientMapper.toDTO(clientrepository.save(ClientMapper.toEntity(c)));
	}

	

	@Override
	public ClientDTO updateClient(ClientDTO c , Long id) throws Exception {
		
//		Optional<Client> clientOP = clientrepository.findById(id);
//		if(clientOP.isPresent()) {
//			c.setId(id);
//			return modelMapper.map(clientrepository.save(c), ClientDTO.class);
//		}
//		else {
//			throw new EntityNotFound("Update : client not found");
//		}
		
		clientrepository.findById(id).orElseThrow(()->new EntityNotFound("Update : client not found"));
		Client client =clientrepository.findById(id).get();
		c.setId(id);
		if(c.getNom() == null || c.getNom().equals("")  ) {
			log.info("Nom de clien est null");
			c.setNom(client.getNom());
		}
		if(c.getPrenom() == null || c.getPrenom().equals("")) {
			log.info("Nom de clien est null");
			c.setPrenom(client.getPrenom());
		}
		if ( c.getDateNaiss() == null ) {
			log.info("Nom de clien est null");
			c.setDateNaiss(client.getDateNaiss());
		}
		
		log.info("Client with id" + id + "updated");
		return ClientMapper.toDTO(clientrepository.save(ClientMapper.toEntity(c)));
	
	}

	@Override
	public String deleteClientById(Long id) throws Exception {
//		try {
//			clientrepository.deleteById(id);
//		} catch (Exception e) {	
//			throw new EntityNotFound("client not found");
//		}	
		clientrepository.findById(id).orElseThrow(()->new EntityNotFound("Delete : client not found"));
		clientrepository.deleteById(id);
		log.info("Client with id" + id + "deleted");
		return "Done";
	}
	
	

	@Override
	public void deleteAll() {
		clientrepository.deleteAll();
		
	}
	

}
