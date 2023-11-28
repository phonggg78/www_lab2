package vn.edu.iuh.fit.lab1_vanquangphong_week2.frontend.model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.models.Customers;
import vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.services.CustomerService;

import java.io.IOException;
import java.util.List;

public class CustomerModel {
    public void insertCust(HttpServletRequest req, HttpServletResponse res){
        CustomerService customerService = new CustomerService();

        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");

        Customers customer = new Customers(name, email, phone, address);
        customerService.create(customer);

    }

    public List<Customers> getAllCustomer(){
        CustomerService customerService = new CustomerService();
        return customerService.getAll();
    }

    public void updateCust(HttpServletRequest req, HttpServletResponse res){
        CustomerService customerService = new CustomerService();

        Customers c = customerService.findById(Long.parseLong(req.getParameter("id")));

        String address, email, name, phone;
        if(!req.getParameter("address").equals(""))
            c.setAddress(req.getParameter("address"));
        if(!req.getParameter("email").equals(""))
            c.setEmail(req.getParameter("email"));
        if(!req.getParameter("name").equals(""))
            c.setName(req.getParameter("name"));
        if(!req.getParameter("phone").equals(""))
            c.setPhone(req.getParameter("phone"));
        customerService.update(c);
    }

    public  void deleteCust(HttpServletRequest req, HttpServletResponse res){
        CustomerService customerService = new CustomerService();
        long id = Long.parseLong(req.getParameter("deleteId"));
        customerService.delete(id);
    }

    public void createCus(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        Customers customers = new Customers(name, email, phone, address);
        CustomerService services = new CustomerService();
        services.create(customers);
        resp.sendRedirect("../webapp/index.jsp");
    }
}
