package com.nykdev.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//table cliente
@Entity
@Table(name = "tb_clients")
public class Clients {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String cpf;
	private String UrlFoto;
	
	public Clients() {
		
	}
	
	public Clients(Long id, String name, String cpf, String urlFoto) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		UrlFoto = urlFoto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getUrlFoto() {
		return UrlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		UrlFoto = urlFoto;
	}
	
	
	
	

}
