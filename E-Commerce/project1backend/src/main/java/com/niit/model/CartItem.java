package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CartItem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int cartitemid;
private int quantity;
private double totalPrice;
@ManyToOne
private User user;
@ManyToOne
private Product product;
public int getCartitemid() {
	return cartitemid;
}
public void setCartitemid(int cartitemid) {
	this.cartitemid = cartitemid;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(double totalPrice) {
	this.totalPrice = totalPrice;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}

}

