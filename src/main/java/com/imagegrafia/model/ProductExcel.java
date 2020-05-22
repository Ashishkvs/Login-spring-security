package com.imagegrafia.model;

import lombok.Data;

@Data
public class ProductExcel {
	private int id;
	
	private String sno;
	private String itemCode;
	private String barCode;
	private String itemName;
	private String rate;
	private String withGstRate;
	private String mrp;
	private String margin;
	private String brandName;
	private String department;
	private String mainCategory;
	private String subCategory;
	private String category;
}
