package vn.edu.iuh.fit.lab1_vanquangphong_week2.models;

import jakarta.persistence.*;

import java.sql.Date;
@Entity
@Table(name = "customer")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private long id;
    @Column()
    private String name;
    @Column(unique = true, length =  150, nullable = false)
    private String email;
    @Column( length =  15, nullable = false)
    private String phone;
    @Column( length =  250, nullable = false)
    private String address;

}
