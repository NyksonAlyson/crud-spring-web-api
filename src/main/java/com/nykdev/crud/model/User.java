package com.nykdev.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idcon;
	private String name;
	private String cpf;
	private String email;
	
	public User() {
		
	}
	
	public User(long idcon, String name, String cpf, String email) {
		super();
		this.idcon = idcon;
		this.name = name;
		this.cpf = cpf;
		this.email=email;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
