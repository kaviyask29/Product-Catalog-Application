package com.crud.Operations.crud.operation;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProductService {
	@Autowired
	ProductRepository repo;
	
	public List<Product> getProduct() {
		return repo.findAll();
	}
	public Product getProductById(int prod_id) {
		 return repo.findById(prod_id).orElse(null);
	}
	

	public void addProduct(Product prod) {
		repo.save(prod);
	}
	public void updateProduct(Product prod) {
		// TODO Auto-generated method stub
		repo.save(prod);
	}
	public boolean deleteProduct(int prod_id) {
		// TODO Auto-generated method stub
		if(repo.existsById(prod_id)) {
			repo.deleteById(prod_id);
			return true;
		}
		return false;
	}
	}
	
	


