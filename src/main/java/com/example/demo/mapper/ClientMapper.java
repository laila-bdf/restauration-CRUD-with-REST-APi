package com.example.demo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.ClientDTO;
import com.example.demo.model.Client;

@Component
public class ClientMapper {
	
	@Autowired
	private  ModelMapper modelMapper;
	
	public  Client toEntity(ClientDTO clientDTO){
		return modelMapper.map(clientDTO ,Client.class);
	}

	public  ClientDTO toDTO(Client client) {
		return modelMapper.map(client ,ClientDTO.class);
	}
}
