package InventoryApp.InventoryApp.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Brand  extends AbstractEntity{

    @Column(length = 45, nullable = true, unique = true)
    private String name;

    @OneToMany
    @JoinColumn (name="brand_id")
    private List<Category> categories = new ArrayList<>();

    public Brand() {}

    public Brand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }


}
