package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "test")
@ApiModel("PruebaUser")
public class User {
	

	@Id
	private int id;
	
	@NotEmpty
	@ApiModelProperty(value="Nombre de usuario", example="Manolo")
	private String name;
	
	
	@ApiModelProperty (value = "Fecha", example = "1997-01-01 00:00:00")
	private Date fecha;
	
	
	public User(int id, String name, Date fecha) {
		super();
		this.id = id;
		this.name = name;
		this.fecha = fecha;
	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", fecha=" + fecha + "]";
	}
	
	
}
