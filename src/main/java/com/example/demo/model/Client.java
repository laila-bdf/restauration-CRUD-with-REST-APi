package com.example.demo.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@Entity
public class Client {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="NOM")
	private String nom;
	private String prenom;
	private Date dateNaiss;
	
	//@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name = "rec", referencedColumnName ="id" )
	@OneToMany(mappedBy = "clt" , cascade = CascadeType.ALL)
	private List<Commande> commandes = new ArrayList<Commande>();
	
	
	
	public Client( String nom, String prenom, Date dateNaiss) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaiss = dateNaiss;
	}
	
}

