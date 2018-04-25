package com.niit.services;

import com.niit.model.CartItem;
import com.niit.model.CustomerOrder;
import com.niit.model.User;

public interface CartItemService {
 void saveOrUpdateCartItem(CartItem cartItem);
 void removeCartItem(int cartItemId);
 User getUser(String email);
CustomerOrder createOrder(User user);
}
