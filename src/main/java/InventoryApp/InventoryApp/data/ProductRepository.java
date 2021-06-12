package InventoryApp.InventoryApp.data;


import InventoryApp.InventoryApp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends JpaRepository<Product, Integer> {
//public interface CategoryRepository extends CrudRepository<Product, Integer> {
}
