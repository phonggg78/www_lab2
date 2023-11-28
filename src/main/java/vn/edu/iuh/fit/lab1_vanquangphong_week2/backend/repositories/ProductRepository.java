package vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.db.Connection;
import vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.models.Orders;
import vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.models.Product;

import java.util.List;

public class ProductRepository {
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tr;
    public ProductRepository(){
        emf = Connection.getInstance().getEmf();
        em = emf.createEntityManager();
        tr = em.getTransaction();
    }

    public void addProduct(Product product){
        tr.begin();
        try {
            em.persist(product);
            tr.commit();
        }
        catch (Exception ex){
            tr.rollback();
            ex.printStackTrace();
        }
    }

    public void deleteOrder(long id){
        tr.begin();
        try {
            em.remove(em.find(Product.class, id));
            tr.commit();
        }
        catch (Exception ex){
            tr.rollback();
            ex.printStackTrace();
        }
    }

    public void updateProduct(Product product){
        tr.begin();
        try {
            em.merge(product);
            tr.commit();
        }
        catch (Exception ex){
            tr.rollback();
            ex.printStackTrace();
        }
    }

    public List<Product> getAllProduct(){
        String sql = "select * from product";
        List<Product> lo = em.createNativeQuery(sql, Product.class).getResultList();
        return lo;
    }

    public Product findById(long id){
        String sql = "select * from product where id = "+ id;
        Product product = (Product) em.createNativeQuery(sql, Product.class).getSingleResult();
        return  product;
    }
}
