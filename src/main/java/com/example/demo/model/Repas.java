package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
@Entity
public class Repas implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RepasKey id;
	
	@SuppressWarnings("unused")
	private Integer nbrPlats;
	
	@ManyToOne
	@MapsId("platId")
	private Plat p;
	
	@ManyToOne
	@MapsId("commandeId")
	private Commande c;

	
	
}
