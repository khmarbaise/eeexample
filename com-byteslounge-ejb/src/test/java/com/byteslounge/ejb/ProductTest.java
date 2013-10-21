package com.byteslounge.ejb;

import static org.fest.assertions.Assertions.assertThat;

import org.testng.annotations.Test;

import com.byteslounge.model.Product;

public class ProductTest {

	@Test
	public void shouldReturnTheCorrectDescriptionAndId() {
		Product p = new Product();
		p.setDescription("This is the description");
		assertThat(p.toString()).isEqualTo("id:0 desc: This is the description");
	}
}
