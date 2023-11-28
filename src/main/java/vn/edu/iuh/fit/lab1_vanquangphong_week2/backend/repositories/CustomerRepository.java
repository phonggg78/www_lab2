package vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.db.Connection;
import vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.models.Customers;

import java.util.List;

public class CustomerRepository {
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tr;
    public CustomerRepository(){
        emf = Connection.getInstance().getEmf();
        em = emf.createEntityManager();
        tr = em.getTransaction();
    }

    public void addCust(Customers c){
        tr.begin();
        try {
            em.persist(c);
            tr.commit();
        }
        catch (Exception ex){
            tr.rollback();
            ex.printStackTrace();
        }
    }

    public void deleteCust(long id){
        tr.begin();
        try {
            em.remove(em.find(Customers.class, id));
            tr.commit();
        }
        catch (Exception ex){
            tr.rollback();
            ex.printStackTrace();
        }
    }

    public void update(Customers c){
        tr.begin();
        try {
            em.merge(c);
            tr.commit();
        }
        catch (Exception ex){
            tr.rollback();
            ex.printStackTrace();
        }
    }

    public List<Customers> getAllCustomer(){
        String sql = "select * from customer";
        List<Customers> lc = em.createNativeQuery(sql, Customers.class).getResultList();
        return lc;
    }

    public Customers findById(long id){
        String sql = "select * from customer where id = "+ id;
        Customers c = (Customers) em.createNativeQuery(sql, Customers.class).getSingleResult();
        return c;
    }
}
