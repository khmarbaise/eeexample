package com.byteslounge.ejb;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;

import org.apache.log4j.Logger;

import com.byteslounge.model.Product;

@Stateful(name="ShoppingCartBean")
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 30)
public class ShoppingCartBean implements ShoppingCart {
	private static final Logger LOGGER = Logger.getLogger(ShoppingCartBean.class);

	private List<Product> products;
	
	@PostConstruct
	private void init(){
		products = new ArrayList<Product>();
	}
	
	@Override
	public void addProduct(Product product){
		products.add(product);
	}
	
	@Override
//	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void completePurchase(){
		for(Product product : products){
			LOGGER.info("Persisting:" + product);
		}
		products.clear();
	}

	@Override
	public List<Product> getProducts() {
		return products;
	}
}
