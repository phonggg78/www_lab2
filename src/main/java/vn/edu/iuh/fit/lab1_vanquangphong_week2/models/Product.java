package vn.edu.iuh.fit.lab1_vanquangphong_week2.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.lab1_vanquangphong_week2.enums.ProductStatus;

@Entity()
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private String id;
    @Column()
    private String name;
    @Column(name = "full_name")
    private String decription;
    @Column(nullable = false)
    private int unit;
    @Column(name = "manufacturer_name",length =  150, nullable = false)
    private String m_name;
    @Column(nullable = false)
    private ProductStatus status;

    public Product() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public Product(String id, String name, String decription, int unit, String m_name, ProductStatus status) {
        this.id = id;
        this.name = name;
        this.decription = decription;
        this.unit = unit;
        this.m_name = m_name;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", decription='" + decription + '\'' +
                ", unit=" + unit +
                ", m_name='" + m_name + '\'' +
                ", status=" + status +
                '}';
    }

    public Product(String id) {
        this.id = id;
    }
}
