package com.byteslounge.ejb;

import java.util.List;

import javax.ejb.Local;

import com.byteslounge.model.Product;

@Local
public interface ShoppingCart {

	void addProduct(Product product);
	
	void completePurchase();
	
	List<Product> getProducts();
}
