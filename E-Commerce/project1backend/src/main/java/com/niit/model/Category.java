package com.niit.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
//If category class has to mapped with the table name category_s180396
@Table(name="category_s180396")
public class Category {//Table name is Category_s180396
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String categoryname;
@OneToMany(mappedBy="category")//Product entity we have property named category
private List<Product> products;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCategoryname() {
	return categoryname;
}
public void setCategoryname(String categoryname) {
	this.categoryname = categoryname;
}
@Override
	public String toString() {
		return "Id: " + this.id + " " + "cn: "+this.categoryname; 
	}

}
