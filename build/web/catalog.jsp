<%-- Document : catalog Created on : 15 Sep, 2014, 8:58:36 PM Author : Acer --%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList" %>
<%@page import="Grooming.model.Product" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <title>
            Neal Adam's
        </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/Style.css" type='text/css' rel='stylesheet' />
    </head>

    <body class="Background">
        <div class="Headers">
            <%@include file="/header.jsp" %>
        </div>

        <%@include file="/user-navigation.jsp" %>
        <%@include file="/site-navigation.jsp" %>
        <%List<Product> categoryGroup = (List) request.getAttribute("categoryGroup");
                                String category = (String) request.getAttribute("category"); %>

        <div class="Main">
            <a href='index.jsp'> Home </a>
            >
            <a href='CatalogController?catalogCategory=All%20Products'> Catalog </a>
            <div class="bodytext">
                <br>Category:
                <a href='CatalogController?catalogCategory=All%20Products'> All Products </a>
                |
                <a href='CatalogController?catalogCategory=Mens%20Accessories'> Mens Accessories </a>
                |
                <a href='CatalogController?catalogCategory=Mens%20Clothing'> Mens Clothing </a>
                


                <% if (category.equals("All Products")) {%>

                <h2>
                    All Products
                </h2>
                <div class="bodytext">

                    <% for (int n = 0; n < categoryGroup.size(); n++) {
                                                        Product product = categoryGroup.get(n);
                                                        if (!category.equals(product.getCatalogCategory())) {%>
                    <h2>
                        <%= product.getCatalogCategory()%>
                    </h2>
                    <% category = product.getCatalogCategory();
                                                        }%>
                    <a href="CatalogController?productCode=<%=product.getProductCode()%>">
                        <%=product.getProductName()%>
                    </a>
                    <br>
                    <% } %>
                    </div>
                    

                        <%} else {%>
                        
                        <div class="bodytext">
                            <h2>
                                <%=category%>
                            </h2>
                            <% for (int n = 0; n < categoryGroup.size(); n++) {
                                                Product product = categoryGroup.get(n);%>
                            <a href="CatalogController?productCode=<%=product.getProductCode()%>">
                                <%=product.getProductName()%>
                            </a>
                            <br>
                            <% } %>
                        </div>
                        
                        <% }%>
                    
                
            </div>
        </div>
        <%@include file="/footer.jsp" %>
    </body>

</html>