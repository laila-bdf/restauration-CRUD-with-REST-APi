package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Plat {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Float prix;
	private String nom;
	private String typePlat;
	private String description;
	

	/*@JsonIgnore
	@ManyToMany(mappedBy ="plats")*/
	@OneToMany(mappedBy="p")
	private List<Repas> commandes = new ArrayList<Repas>();
	
	
	@ManyToMany(mappedBy ="plats_m")
	private List<Menu> menus = new ArrayList<Menu>();
	
	public Plat(Float prix, String nom, String typePlat, String description) {
		super();
		this.prix = prix;
		this.nom = nom;
		this.typePlat = typePlat;
		this.description = description;
	}
	
	
}
