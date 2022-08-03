package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Commande {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date_commande;
	private Float prix_total;
	private String mode_payement;
	private String status;
	
	@ManyToOne
	private Client clt;
	
	/*@ManyToMany
	@JoinTable(
			name = "repas",
			joinColumns = @JoinColumn(name="cmd_id"),
			inverseJoinColumns = @JoinColumn(name= "plat_id")
			)*/
	@OneToMany(mappedBy ="p")
	private List<Repas> plats = new ArrayList<Repas>();
	
	public Commande(Date date_commande, Float prix_total, String mode_payement, String status) {
		super();
		this.date_commande = date_commande;
		this.prix_total = prix_total;
		this.mode_payement = mode_payement;
		this.status = status;
	}
	
	
	

}
