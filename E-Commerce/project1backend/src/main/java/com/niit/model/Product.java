package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity  //mapped with Product relational table
@Table(name="product_s180396")
public class Product {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
@NotEmpty(message="ProductName cannot be blank(*)")
private String productname;
@NotEmpty(message="Product description is required(*)")
private String productdescription;
@Min(value=1,message="minimum quantity must be 1")
private int quantity;
@Min(value=1,message="minimum price must be 1")
private double price;
@ManyToOne
@JoinColumn(name="cid")
//FK category_id
private Category category;
@Transient//not persistent
private MultipartFile image;
public Product() {
System.out.println("product object created");
}

public int getId() {
	System.out.println("getId");
	return id;
}
public void setId(int id) {
	System.out.println("setId");
	this.id = id;
}
public String getProductname() {
	System.out.println("getProductname");
	return productname;
}
public void setProductname(String productname) {
	System.out.println("setProductname");
	this.productname = productname;
}
public String getProductdescription() {
	System.out.println("getproductdescription");
	return productdescription;
}
public void setProductdescription(String productdescription) {
	System.out.println("set productdescription");
	this.productdescription = productdescription;
}
public int getQuantity() {
	System.out.println("getQuantity");
	return quantity;
}
public void setQuantity(int quantity) {
	System.out.println("setQuantity");
	this.quantity = quantity;
}
public double getPrice() {
	System.out.println("getPrice");
	return price;
}
public void setPrice(double price) {
	System.out.println("setPrice");
	this.price = price;
}

public Category getCategory() {
	System.out.println("getCategory");
	return category;
}
public void setCategory(Category category) {
	System.out.println("setCategory");
	this.category = category;
}


public MultipartFile getImage() {
	System.out.println("getImage");
	return image;
}
public void setImage(MultipartFile image) {
	System.out.println("setImage");
	this.image = image;
}
@Override
	public String toString() {
		return "[" + this.id + " " + this.productname + " " + this.productdescription + " " + this.price + " " + this.quantity + " ]";
	}
}

