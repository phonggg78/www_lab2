package vn.edu.iuh.fit.lab1_vanquangphong_week2.frontend.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.lab1_vanquangphong_week2.frontend.model.CustomerModel;

import java.io.IOException;

@WebServlet("/customerController")
public class CustomerControllers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        CustomerModel customerModel = new CustomerModel();

        String action = req.getParameter("action");
        if(action.equals("getAllCustomer")){
            res.sendRedirect("customer.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        CustomerModel customerModel = new CustomerModel();

        String action = req.getParameter("action");

        if(action.equals("addCust")){
            customerModel.insertCust(req, res);
//            res.sendRedirect("customer.jsp");
        }
        else if(action.equals("updateCust")) {
            customerModel.updateCust(req, res);
//            res.sendRedirect("customer.jsp");
        }
        else if(action.equals("deleteCust")){
            customerModel.deleteCust(req, res);
//            res.sendRedirect("customer.jsp");
        }
    }
}
