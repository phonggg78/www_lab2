package vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.db.Connection;
import vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.models.Customers;
import vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.models.Orders;

import java.util.List;

public class OrderRepository {
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tr;
    public OrderRepository(){
        emf = Connection.getInstance().getEmf();
        em = emf.createEntityManager();
        tr = em.getTransaction();
    }

    public void addOrder(Orders o){
        tr.begin();
        try {
            em.persist(o);
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
            em.remove(em.find(Orders.class, id));
            tr.commit();
        }
        catch (Exception ex){
            tr.rollback();
            ex.printStackTrace();
        }
    }

    public void updateOrder(Orders o){
        tr.begin();
        try {
            em.merge(o);
            tr.commit();
        }
        catch (Exception ex){
            tr.rollback();
            ex.printStackTrace();
        }
    }

    public List<Orders> getAllCustomer(){
        String sql = "select * from order";
        List<Orders> lo = em.createNativeQuery(sql, Orders.class).getResultList();
        return lo;
    }

    public Orders findById(long id){
        String sql = "select * from order where id = "+ id;
        Orders orders = (Orders) em.createNativeQuery(sql, Orders.class).getSingleResult();
        return  orders;
    }
}
