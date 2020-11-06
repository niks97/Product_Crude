package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;

import com.model.Product;

@Controller
public class ProductDao
{
	@Autowired
	private HibernateTemplate hierHibernateTemplate;
	
	//create
	@Transactional
	public void createProduct(Product product)
	{
		this.hierHibernateTemplate.save(product);
	}
	
	//get all Product
	
	public List<Product> getProducts()
	{
		List<Product> products=this.hierHibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	//delete the Sinle Product
	@Transactional
	public void deleteProduct(int pid)
	{
		Product p=this.hierHibernateTemplate.load(Product.class, pid);
		this.hierHibernateTemplate.delete(p);
		
	}
	
	//get Sigle Product
	
	public Product getProduct(int pid)
	{
		return this.hierHibernateTemplate.get(Product.class, pid);
	}
}
