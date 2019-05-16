package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	private String prodName;
	
	private String manufacturer;
	
	private Double prodPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(Double prodPrice) {
		this.prodPrice = prodPrice;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", prodName=" + prodName + ", manufacturer=" + manufacturer + ", prodPrice="
				+ prodPrice + "]";
	}
	

}
