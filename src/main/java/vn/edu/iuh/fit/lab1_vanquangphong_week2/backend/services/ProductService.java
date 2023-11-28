package vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.services;

import vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.models.Customers;
import vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.models.Product;
import vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.repositories.CustomerRepository;
import vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.repositories.ProductRepository;

import java.util.List;

public class ProductService {
    private ProductRepository  productRepository;

    public ProductService(ProductRepository  productRepository) {
        productRepository = new ProductRepository();
    }

    public void create(Product product){
        productRepository.addProduct(product);
    }

    public void delete(long id){
        productRepository.deleteOrder(id);
    }

    public void update(Product product){
        productRepository.updateProduct(product);
    }

    public Product findById(long id){
        return productRepository.findById(id);
    }
    public List<Product> getAll(){
        return productRepository.getAllProduct();
    }

}
