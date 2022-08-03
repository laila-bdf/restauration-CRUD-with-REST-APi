package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RepasKey implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Column(name="plat_id")
	private Long platId;
	
	@Column(name="commande_id")
	private Long commandeId;
}
