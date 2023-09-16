package vn.edu.iuh.fit.lab1_vanquangphong_week2.models;

import jakarta.persistence.*;

//@Entity
//@Table(name = "product_image")
public class ProductImage {
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private long id;

    @Column( length =  250, nullable = false)
    private String path;
    @Column( length =  250, nullable = false)
    private String alternative;

    public ProductImage(Product product, long id, String path, String alternative) {
        this.product = product;
        this.id = id;
        this.path = path;
        this.alternative = alternative;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "product=" + product +
                ", id=" + id +
                ", path='" + path + '\'' +
                ", alternative='" + alternative + '\'' +
                '}';
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }
}
