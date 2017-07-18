package com.xyinc.poi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_poi")
public class Poi implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name")
	@NotNull
	@Size(min = 3)
	private String name;
	
	@Column(name = "coordinateX")
	@NotNull
	@Min(0)
	private Integer coordinateX;
	
	@Column(name = "coordinateY")
	@NotNull
	@Min(0)
	private Integer coordinateY;
	
	
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
	
	public Integer getCoordinateX() {
		return coordinateX;
	}
	
	public void setCoordinateX(Integer coordinateX) {
		this.coordinateX = coordinateX;
	}
	
	public Integer getCoordinateY() {
		return coordinateY;
	}
	
	public void setCoordinateY(Integer coordinateY) {
		this.coordinateY = coordinateY;
	}
}
