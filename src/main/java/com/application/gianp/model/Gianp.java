package com.application.gianp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="gianp")
public class Gianp {

	@Id
	@Column(name="idgianp")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idgianp;
	
	@Column(name="message")
	private String message;
	

	public Integer getIdgianp() {
		return idgianp;
	}

	public void setIdgianp(Integer idgianp) {
		this.idgianp = idgianp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString(){
		return "idgianp="+idgianp+", message="+message;
	}
}
