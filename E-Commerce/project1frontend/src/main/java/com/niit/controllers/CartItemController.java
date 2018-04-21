package com.niit.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.model.CartItem;
import com.niit.model.Product;
import com.niit.model.User;
import com.niit.services.CartItemService;
import com.niit.services.ProductService;



@Controller
public class CartItemController {
@Autowired
private CartItemService cartItemService;
@Autowired
private ProductService productService;

	@RequestMapping(value="/cart/addtocart/{id}")
	public String addToCart(@PathVariable int id,@AuthenticationPrincipal Principal principal,
				@RequestParam int requestedQuantity){
		String email=principal.getName();//return the email id of the logged in user
		User user=cartItemService.getUser(email);
		Product product=productService.getProduct(id);
		List<CartItem> cartItems=user.getCartItems();
		
		//if the selected product already exists in cartitem table,only update quantity
		//new cartItem object neet not be crated
		//cartitem -> quantity,totalprice,user,product
		for(CartItem cartItem:cartItems){
			if(cartItem.getProduct().getId()==id){
				cartItem.setQuantity(requestedQuantity);
				cartItem.setTotalPrice(requestedQuantity * product.getPrice());
				cartItemService.saveOrUpdateCartItem(cartItem);//update
			}
		}
		CartItem cartItem=new CartItem();
		cartItem.setQuantity(requestedQuantity);
		cartItem.setTotalPrice(requestedQuantity * product.getPrice());
		cartItem.setUser(user);
		cartItem.setProduct(product);
		cartItemService.saveOrUpdateCartItem(cartItem);
		return "redirect:/cart/purchasedetails";
	}
	
	@RequestMapping(value="/cart/purchasedetails")
	public String getPurchaseDetails(@AuthenticationPrincipal Principal principal,Model model){
		String email=principal.getName();
		User user=cartItemService.getUser(email);
		List<CartItem> cartItems=user.getCartItems();//list of cartitems/products
		model.addAttribute("cartItems",cartItems);
		return "cart";
	}
	
	@RequestMapping(value="/cart/deletecartitem/{cartItemId}")
	public String removeCartItem(@PathVariable int cartItemId){
		cartItemService.removeCartItem(cartItemId);
		return "redirect:/cart/purchasedetails";
	}
}















