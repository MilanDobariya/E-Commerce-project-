package com.niit.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class User {
	@Id
private String email;
private String password;
private boolean enabled;
@OneToOne(mappedBy="user")
private Customer customer;
@OneToOne(mappedBy="user",cascade=CascadeType.ALL)
private Authorities authorities;
@OneToMany(mappedBy="user",fetch=FetchType.EAGER)
private List<CartItem> cartItems;
public User(){
	System.out.println("User object is created");
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public boolean isEnabled() {
	return enabled;
}
public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public Authorities getAuthorities() {
	return authorities;
}
public void setAuthorities(Authorities authorities) {
	this.authorities = authorities;
}
public List<CartItem> getCartItems() {
	return cartItems;
}
public void setCartItems(List<CartItem> cartItems) {
	this.cartItems = cartItems;
}

}
