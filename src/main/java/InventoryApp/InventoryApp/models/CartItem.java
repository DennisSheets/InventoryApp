package InventoryApp.InventoryApp.models;

import javax.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItem extends AbstractEntity{

    private int quantity;

    @ManyToOne
    @JoinColumn (name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    public CartItem(){}

    public CartItem(int quantity, Product product) {
        super();
        this.quantity = quantity;
        this.product = product;
        this.user = user;
    }

    public CartItem(int quantity, Product product, User user) {
        super();
        this.quantity = quantity;
        this.product = product;
        this.user = user;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "CartItem{" +
                ", quantity=" + quantity +
                ", product=" + product +
                ", user=" + user +
                '}';
    }
}
