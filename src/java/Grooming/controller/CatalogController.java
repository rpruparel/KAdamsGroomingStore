
package Grooming.controller;

import Grooming.model.Product;
import Grooming.connection.ProductDB;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;package Grooming.controller;

import Grooming.model.Product;
import Grooming.connection.ProductDB;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rohit Ruparel
 */
public class CatalogController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		String productCode;
		productCode = request.getParameter("productCode");
		String catalogCategory;
		catalogCategory = request.getParameter("catalogCategory");
		int categoryCheck = 0;

		if (productCode != null && productCode != "") {

			ProductDB prodDB = new ProductDB();
			List < Product > productGroup = prodDB.getProducts();
			Product product = null;
			int n;

			for (n = 0; n < productGroup.size(); n++) {
				product = productGroup.get(n);
				if (productCode.equals(product.getProductCode())) {
					categoryCheck = 1;
				}
				if (categoryCheck == 1) {
					break;
				}
			}

			if (categoryCheck != 1) {
				response.sendRedirect("CatalogController?catalogCategory=All Products");
				return;
			}

			request.setAttribute("product", product);
			RequestDispatcher selectedProduct;
			selectedProduct = request.getRequestDispatcher("item.jsp");
			selectedProduct.forward(request, response);
		} else if (catalogCategory != null && catalogCategory != "") {

			ProductDB ProdDB = new ProductDB();
			List < Product > productGroup = ProdDB.getProducts();
			List < Product > categoryGroup = new ArrayList < Product > ();
			Product product;
			String category = null;
			int n;

			if (catalogCategory.equals("All Products")) {
				categoryGroup = ProdDB.getProducts();
				category = "All Products";
			} else {
				for (n = 0; n < productGroup.size(); n++) {
					product = productGroup.get(n);
					if (catalogCategory.equals(product.getCatalogCategory())) {
						categoryGroup.add(product);
						categoryCheck = 1;
						category = catalogCategory;
					}
				}

				if (categoryCheck != 1) {
					response.sendRedirect("CatalogController?catalogCategory=All Products");
					return;
				}

			}
			request.setAttribute("categoryGroup", categoryGroup);
			request.setAttribute("category", category);
			RequestDispatcher selectedCategory;
			selectedCategory = request.getRequestDispatcher("catalog.jsp");
			selectedCategory.forward(request, response);
		} else {
			response.sendRedirect("CatalogController?catalogCategory=All%20Products");
			return;
		}
	}

}
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rohit Ruparel
 */
public class CatalogController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String productCode;
        productCode = request.getParameter("productCode");
        String catalogCategory;
        catalogCategory = request.getParameter("catalogCategory");
        int categoryCheck = 0;

        if (productCode != null && productCode != "") {

            ProductDB prodDB = new ProductDB();
            List< Product> productGroup = prodDB.getProducts();
            Product product = null;
            int n;

            for (n = 0; n < productGroup.size(); n++) {
                product = productGroup.get(n);
                if (productCode.equals(product.getProductCode())) {
                    categoryCheck = 1;
                }
                if (categoryCheck == 1) {
                    break;
                }
            }

            if (categoryCheck != 1) {
                response.sendRedirect("CatalogController?catalogCategory=All Products");
                return;
            }

            request.setAttribute("product", product);
            RequestDispatcher selectedProduct;
            selectedProduct = request.getRequestDispatcher("item.jsp");
            selectedProduct.forward(request, response);
        } else if (catalogCategory != null && catalogCategory != "") {

            ProductDB ProdDB = new ProductDB();
            List<Product> productGroup = ProdDB.getProducts();
            List<Product> categoryGroup = new ArrayList<Product>();
            Product product;
            String category = null;
            int n;

            if (catalogCategory.equals("All Products")) {
                categoryGroup = ProdDB.getProducts();
                category = "All Products";
            } else {
                for (n = 0; n < productGroup.size(); n++) {
                    product = productGroup.get(n);
                    if (catalogCategory.equals(product.getCatalogCategory())) {
                        categoryGroup.add(product);
                        categoryCheck = 1;
                        category = catalogCategory;
                    }
                }

                if (categoryCheck != 1) {
                    response.sendRedirect("CatalogController?catalogCategory=All Products");
                    return;
                }

            }
            request.setAttribute("categoryGroup", categoryGroup);
            request.setAttribute("category", category);
            RequestDispatcher selectedCategory;
            selectedCategory = request.getRequestDispatcher("catalog.jsp");
            selectedCategory.forward(request, response);
        } else {
            response.sendRedirect("CatalogController?catalogCategory=All%20Products");
            return;
        }
    }

}
