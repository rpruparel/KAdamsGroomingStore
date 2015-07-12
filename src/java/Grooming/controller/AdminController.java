package Grooming.controller;

import Grooming.connection.OrderDB;
import Grooming.model.Order;
import Grooming.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rohit Ruparel
 */
public class AdminController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		HttpSession session = request.getSession();
		String action = null;
		action = request.getParameter("action");
		if (action == "") {
			response.sendRedirect("https://tomcat-unccrruparel.rhcloud.com/KAdamsGroomingStore/admin.jsp");
			return;
		}

		if (action.equals("viewOrders")) {
			OrderDB orderDB = new OrderDB();
			List < Order > orderGroup;
			orderGroup = orderDB.getOrders();
			request.setAttribute("theOrders", orderGroup);
			RequestDispatcher userOrders;
			userOrders = request.getRequestDispatcher("orderlist.jsp");
			userOrders.forward(request, response);
		} else {
			response.sendRedirect("https://tomcat-unccrruparel.rhcloud.com/KAdamsGroomingStore/admin.jsp");
			return;
		}
	}
}