package com.example.demo.mapper;

import org.modelmapper.ModelMapper;

import com.example.demo.dto.ClientDTO;
import com.example.demo.model.Client;

public class ClientMapper {
	private static ModelMapper modelMapper=new ModelMapper();
	
	public static Client toEntity(ClientDTO clientDTO){
		return modelMapper.map(clientDTO ,Client.class);
	}

	public static ClientDTO toDTO(Client client) {
		return modelMapper.map(client ,ClientDTO.class);
	}
}
