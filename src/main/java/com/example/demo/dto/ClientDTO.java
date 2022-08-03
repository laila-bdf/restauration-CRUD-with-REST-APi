package com.example.demo.dto;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class ClientDTO {

	private long id;
	private String nom;
	private String prenom;
	private Date dateNaiss;
	public ClientDTO(String nom, String prenom, Date dateNaiss) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaiss = dateNaiss;
	}
	
	
}
