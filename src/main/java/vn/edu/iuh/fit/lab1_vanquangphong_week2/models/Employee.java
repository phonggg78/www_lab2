package vn.edu.iuh.fit.lab1_vanquangphong_week2.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.lab1_vanquangphong_week2.enums.EmployeeStatus;

import java.sql.Date;

@Entity
@Table(name = "employee")
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long id;
    @Column(name = "full_name")
    private String fullname;
    @Column(nullable = false)
    private Date dob;
    @Column(unique = true, length =  15, nullable = false)
    private String email;
    @Column( length =  150, nullable = false)
    private String phone;
    @Column()
    private String address;
    private EmployeeStatus status;


}
