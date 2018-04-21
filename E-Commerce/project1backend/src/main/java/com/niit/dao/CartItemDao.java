package com.niit.dao;

import com.niit.model.CartItem;
import com.niit.model.User;

public interface CartItemDao {
	void saveOrUpdateCartItem(CartItem cartItem);
	void removeCartItem(int cartItemId);
	User getUser(String email);
	
}
