package com.pet_shop.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Chip {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int codigo;
	private String local_colocacao;
	private String status;
	
	public Chip(Long id, int codigo, String local_colocacao, String status) {
		this.id = id;
		this.codigo = codigo;
		this.local_colocacao = local_colocacao;
		this.status = status;
	}
	
	public Chip () {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getLocal_colocacao() {
		return local_colocacao;
	}

	public void setLocal_colocacao(String local_colocacao) {
		this.local_colocacao = local_colocacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
