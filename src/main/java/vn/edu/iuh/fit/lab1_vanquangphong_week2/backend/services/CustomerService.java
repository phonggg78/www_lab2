package vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.services;

import vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.models.Customers;
import vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.repositories.CustomerRepository;

import java.util.List;

public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService() {
        customerRepository = new CustomerRepository();
    }

    public void create(Customers c){
        customerRepository.addCust(c);
    }

    public void delete(long id){
        customerRepository.deleteCust(id);
    }

    public void update(Customers c){
        customerRepository.update(c);
    }

    public Customers findById(long id){
        return customerRepository.findById(id);
    }
    public List<Customers> getAll(){
        return customerRepository.getAllCustomer();
    }

}
