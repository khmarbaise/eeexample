package com.byteslounge.model;

import java.io.Serializable;

//@Entity
//@Table(name = "PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	@Column(nullable = false)
	private Long id;

//	@Column(nullable = false)
	private String description;

	public Product() {
		id = new Long(0L);
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("id:");
		sb.append(Long.toString(getId()));
		sb.append(" desc: ");
		sb.append(getDescription());
		return sb.toString();
	}
}
