package com.example.demo.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ClientDTO;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.mapper.ClientMapper;
import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;

@Service
public class ClientService {

	public static Logger log = LoggerFactory.getLogger(ClientService.class);

	@Autowired
	private ClientRepository clientrepository;
	
	@Autowired
	private ClientMapper clientMapper;

	
	public Page<Client> findAll(Pageable page) {
		return clientrepository.findAll(page);
	}

	public ClientDTO findById(Long id) {
		Optional<Client> oClient = clientrepository.findById(id);
		if (oClient.isPresent()) {
			return clientMapper.toDTO(oClient.get());
		} else {
			log.error("Client with id [{id}] not found", id);
			throw new EntityNotFoundException("client not found");
		}
	}

	public ClientDTO save(ClientDTO client) {
		return clientMapper.toDTO(clientrepository.save(clientMapper.toEntity(client)));
	}

	public ClientDTO updateClient(ClientDTO client, Long id) {

		findById(id);
		client.setId(id);	
		log.info("Client with id" + id + "updated");
		return clientMapper.toDTO(clientrepository.save(clientMapper.toEntity(client)));

	}

	public String deleteClientById(Long id) {
		findById(id);
		clientrepository.deleteById(id);
		log.info("Client with id" + id + "deleted");
		return "Done";
	}


}
