package vn.edu.iuh.fit.lab1_vanquangphong_week2.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "order")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private  long id;
    @Column(name = "order_date",nullable = false)
    private Date od;
    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private  Customers customer;

    public Orders() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getOd() {
        return od;
    }

    public void setOd(Date od) {
        this.od = od;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", od=" + od +
                ", employee=" + employee +
                ", customer=" + customer +
                '}';
    }

    public Orders(long id, Date od, Employee employee, Customers customer) {
        this.id = id;
        this.od = od;
        this.employee = employee;
        this.customer = customer;
    }
}
