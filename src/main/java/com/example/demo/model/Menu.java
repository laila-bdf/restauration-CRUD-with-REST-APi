package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Menu {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date_menu;
	

	@ManyToMany
	@JoinTable(
			name = "plat_menu",
			joinColumns = @JoinColumn(name="menu_id"),
			inverseJoinColumns = @JoinColumn(name= "plat_id")
			)
	private List<Plat> plats_m = new ArrayList<Plat>();
	
	public Menu(Date date_menu) {
		super();
		this.date_menu = date_menu;
	}
	
	
}
