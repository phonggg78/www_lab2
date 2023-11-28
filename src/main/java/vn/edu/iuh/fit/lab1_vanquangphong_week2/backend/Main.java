package vn.edu.iuh.fit.lab1_vanquangphong_week2.backend;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.db.Connection;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Connection.getInstance().getEmf();
        EntityManager  entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try
        {
            entityTransaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            entityTransaction.rollback();
        }

    }
}
