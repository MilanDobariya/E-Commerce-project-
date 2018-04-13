package com.niit.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.services.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;

	public ProductController() {
		System.out.println("productcontroller bean is cratected");
	}

	// http://localhost:8080/project1frontend/all/getproducts
	@RequestMapping(value = "/all/getproducts")
	public ModelAndView getAllProducts() {
		List<Product> products = productService.getAllProducts();
		System.out.println("after entering frontend");
		// 1st parameter - logical view name - productlist
		// 2nd parameter - model attribute name - refer it in jsp page
		// 3rd parameter - model [data] list of products
		// /WEB-INF/views/productlist.jsp
		return new ModelAndView("productlist", "productsAttr", products);
	}
	@RequestMapping(value="/all/getproduct/{id}")
	public ModelAndView getProduct(@PathVariable int id){//id=1,2,3
		//pass this id to service -> service has to pass the id to Dao -> select * from product where id=1
		System.out.println("Product Id is"+id);
		Product product=productService.getProduct(id);
		System.out.println("product is "+product);
		
		return new ModelAndView("productdetails","product" ,product);
		//1st parameter productdetailes - view name - jsp file name
		//2nd parameter product - model attribute - in jsp page to display the data
		//3rdf parameter prduct - model - data[1 1000.0 product description for toy car 12]
		//product =[1 1000.0 product description for toy car toy car 12
	}
	
	@RequestMapping(value="/admin/deleteproduct/{id}")
	public String deleteProduct(@PathVariable int id)
	{
		productService.deleteProduct(id);
		return "redirect:/all/getproducts";
	}
	
	/*@RequestMapping(value="/admin/getproductform")
	public ModelAndView getProductForm(){
		return new ModelAndView("productform","product",new Product());
	}*/
	
	@RequestMapping(value="/admin/getproductform")
	public String getProductForm(Model model){//model to send data to the view
		//Two model attributes
		//product =new Product();
		//categories = List<Category>
		List<Category> categories=productService.getAllCategories();
		model.addAttribute("product",new Product());
		model.addAttribute("categories",categories);
		System.out.println("Size of category list " + categories.size());
		return "productform";
	}
	@RequestMapping(value="/admin/updateproductform/{id}")
	public ModelAndView getUpdateProductForm(@PathVariable int id,Model model){
		List<Category> categories=productService.getAllCategories();
		model.addAttribute("categories",categories);
		Product product=productService.getProduct(id);
		return new ModelAndView("updateproductform","product",product);
	}
	
	@RequestMapping(value="/admin/saveproduct")
	public String saveProduct(@Valid @ModelAttribute(name="product") Product product,BindingResult result,Model model,HttpRequest request){
		if(result.hasErrors()){//hasErrors return true if product details in not valid
			model.addAttribute("categories",productService.getAllCategories());
			return "productform";
		}
		System.out.println("New Product Details" + product);
		productService.saveProduct(product);
		MultipartFile prodImage=product.getImage();//image uploaded in the productform.jsp
		if(prodImage!=null && !prodImage.isEmpty()){
		//how to get rootdirectory
		
			String rootdirectory=request.getServletContext().getRealPath("/");
		System.out.println("Root Directory "+rootdirectory);
		//create path
		Path paths=Paths.get(rootdirectory+"WEB-INF/resources/images/"+product.getId()+".png");
		
		try{
		//it throws checked exception
		prodImage.transferTo(new File(paths.toString()));
		} catch(IllegalStateException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}

		}
		return "redirect:/all/getproducts";
	
	}
	@RequestMapping(value="/admin/updateproduct")
	public String updateProduct(@Valid @ModelAttribute(name="product") Product product,BindingResult result,Model model){
		if(result.hasErrors()){
			model.addAttribute("categories",productService.getAllCategories());
			return "updateproductform";
		}
		System.out.println("New Product Details " + product);
		productService.updateProduct(product);
		return "redirect:/all/getproducts";
	}
	
}


