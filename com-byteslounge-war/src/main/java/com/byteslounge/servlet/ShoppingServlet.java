package com.byteslounge.servlet;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.byteslounge.ejb.ShoppingCart;
import com.byteslounge.model.Product;

@WebServlet(name = "shoppingServlet", urlPatterns = { "/shopping" })
public class ShoppingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB(beanName = "ShoppingCartBean")
	private ShoppingCart shoppingCartBean;

	private static final String HEAD = "<html>\n" 
			+ "<head>\n"
			+ "  <title>Shopping Center</title>\n"
			+ "</head>\n"
			+ "<body>\n"
			+ "<a id=\"links:complete\" href=\"{0}/shopping?complete=yes\">Complete Shopping tour</a></br>\n"
			+ "<a id=\"links:show\" href=\"{0}/shopping?show=true\">Show shopping list</a></br>\n"
			+ "</br>\n"
			+ "</br>\n"
			+ "</br>\n"
			;
	private static final String FOOT = "</body>\n"
			+ "</html>\n";

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String contextPath = request.getContextPath();
		String result = MessageFormat.format(HEAD, contextPath);

		response.getOutputStream().print(result);
		
		String productName = request.getParameter("product");
		if (productName != null && productName.length() > 0) {
			// Product is present in the HTTP request.
			// Let's add it to the shopping cart
			Product product = new Product();
			product.setDescription(productName);
			shoppingCartBean.addProduct(product);
			response.getOutputStream().print("Added " + product.toString() + " to the shopping list.</br>\n");
		}

		String persist = request.getParameter("complete");
		if (persist != null && persist.equalsIgnoreCase("yes")) {
			List<Product> products = shoppingCartBean.getProducts();
			StringBuilder sb = new StringBuilder("Product list</br>\n");
			
			for (Product product : products) {
				sb.append("Product: " + product.toString() + "</br>\n");
			}

			if (products.size() == 0) {
				sb.append("does not contain any product.</br>\n");
			}

			response.getOutputStream().print(sb.toString());
			shoppingCartBean.completePurchase();
		}

		Boolean show = Boolean.valueOf(request.getParameter("show"));
		if (show) {
			List<Product> products = shoppingCartBean.getProducts();
			StringBuilder sb = new StringBuilder("Product list</br>\n");
			
			for (Product product : products) {
				sb.append("Product: " + product.toString() + "</br>\n");
			}

			if (products.isEmpty()) {
				sb.append("does not contain any product.</br>\n");
			}
			response.getOutputStream().print(sb.toString());
		}
		
		response.getOutputStream().print(FOOT);
		response.getOutputStream().close();
	}

}
