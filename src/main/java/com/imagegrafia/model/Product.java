package com.imagegrafia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
//@ToString(exclude = {"images"})
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String category;
	private String descriptions;
	private float price;
	private float quantity;
	private String unit;
	private float stock;
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private List<ProductImage> images;
	
	//review or comments
	//star rating

}

//name: 'Cabbage',
//mrp: 20,
//quantity: [1, 2],
//unit: 'KG',
//orderQuantity: 0,
//selectedQuantity: '',
//images: ['/assets/images/cabbage.jpg']
