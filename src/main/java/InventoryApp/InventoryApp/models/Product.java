package InventoryApp.InventoryApp.models;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128, nullable = false, unique = true)
    private String name;

    private float price;

    private float capacity;
    private int qtyTested;
    private int qtyUntested;
    private String location;
    private String manufacturer;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductDetails> details = new ArrayList<>();



    public Product(Integer id){
        super();
        this.id = id;
    }

    public Product(){}



    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public float getPrice() {return price;}

    public void setPrice(float price) {this.price = price;}

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public int getQtyTested() {
        return qtyTested;
    }

    public void setQtyTested(int qtyTested) {
        this.qtyTested = qtyTested;
    }

    public int getQtyUntested() {
        return qtyUntested;
    }

    public void setQtyUntested(int qtyUntested) {
        this.qtyUntested = qtyUntested;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Category getCategory() {return category;}

    public void setCategory(Category category) {this.category = category;}

    public List<ProductDetails> getDetails() {
        return details;
    }

    public void setDetails(List<ProductDetails> details) {
        this.details = details;
    }



    public void addDetail(String name, String value){
        this.details.add(new ProductDetails(name, value, this));
    }

    public void setDetail(Integer id, String name, String value){
        this.details.add(new ProductDetails(id, name, value, this));
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }
}
