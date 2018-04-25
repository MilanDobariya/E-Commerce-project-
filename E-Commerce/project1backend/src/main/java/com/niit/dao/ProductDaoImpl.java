package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;
import com.niit.model.Product;
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
	@Autowired
private SessionFactory sessionFactory;
	     public ProductDaoImpl(){
	    	 System.out.println("productDaoImpl bean created");
	     }
	     
	public List<Product> getAllProducts() {
		System.out.println(" *ProductDaoImpl first created bean in sessionfactory");
		Session session=sessionFactory.getCurrentSession();
		System.out.println("ProductDaoImpl after created bean session factory");
		String hqlString="from Product";//Product is name of the entity
		System.out.println("ProductDaoImpl after string");
		//HQL - from Product
		//SQL - select * from product_s180396
		Query query=session.createQuery(hqlString);
		System.out.println("ProductDaoImpl ater query");
		List<Product> products=query.list();
		return products;
	}


	
	public Product getProduct(int id) {
		Session session =sessionFactory.getCurrentSession();
		//API - session.get(EntityClassObject,PrimaryKey)
		//select * from TableToWhich entity is mapped where PrimaryKey=?
		Product product=(Product)session.get(Product.class, id);
		//select * from product_s180396 where id=?
		return product;
		
	}


	
	public void deleteProduct(int id) {
		Session session=sessionFactory.getCurrentSession();
		Product product=(Product)session.get(Product.class, id);
		//select * from product_s180396 where id=1
		
		session.delete(product);
		//delete from product_s180396 where id=1;
		
	}



	public void saveOrUpdateProduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		System.out.println("Id of product"+product.getId());
		session.saveOrUpdate(product);
		System.out.println("after inserting id of product "+product.getId());
	}

	public List<Category> getAllCategories() {
		Session session=sessionFactory.getCurrentSession();
		//select * from category_s180396
		Query query=session.createQuery("from Category");
		List<Category> categories=query.list();
		return categories;
	}


	/*public void saveProduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		System.out.println("Id of the product"+ product.getId());
		session.save(product);
		System.out.println("after inserting id of product is"+ product.getId());
		}	
	public void updateProduct(Product product) {
		Session session =sessionFactory.getCurrentSession();
		System.out.println("Id of the product "+product.getId());
		session.update(product);//insert into product_s180396 values(?,....)
		System.out.println("after inserting id of product is "+product.getId());
		*/
	}


