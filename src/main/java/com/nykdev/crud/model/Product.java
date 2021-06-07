package com.nykdev.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idcon;
	private String name;
	private String categoria;
	
	public Product() {
		super();
	}


	public Product(long idcon, String name, String categoria) {
		super();
		this.idcon = idcon;
		this.name = name;
		this.categoria = categoria;
	}


	public long getIdcon() {
		return idcon;
	}

	public void setIdcon(long idcon) {
		this.idcon = idcon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
	

}
