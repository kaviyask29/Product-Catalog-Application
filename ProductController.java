package com.crud.Operations.crud.operation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	ProductService service;
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getproduct() {
	List<Product>list=service.getProduct();
	return new ResponseEntity<>(list,HttpStatus.OK);
	}
	@GetMapping("/products/{prod_id}")
	public ResponseEntity<Product> getProductById(@PathVariable int prod_id) {
		Product product= service.getProductById(prod_id);
		if(product==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(product,HttpStatus.FOUND);
	}
	@PostMapping("/products")
	public ResponseEntity<String> addProduct(@RequestBody Product prod) {
	    System.out.println("Received Product: " + prod);
	    service.addProduct(prod);
	    return new ResponseEntity<>("Product Added Successfully",HttpStatus.CREATED);
	}
	@PutMapping("/products")
	public ResponseEntity<String> updateProduct(@RequestBody Product prod) {
		service.updateProduct(prod);
		return new ResponseEntity<>("Product Catalog Updated...",HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/products/{prod_id}")	
	public ResponseEntity<String> deleteProduct(@PathVariable int prod_id) {
		boolean res= service.deleteProduct(prod_id);
		if(res) {
		 return new ResponseEntity<>("Product Deleted..",HttpStatus.FOUND);
		}
       return new  ResponseEntity<>("Not Found Id",HttpStatus.NOT_FOUND);
	}
}
