package InventoryApp.InventoryApp.data;


import InventoryApp.InventoryApp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer> {
//public interface CategoryRepository extends CrudRepository<Product, Integer> {
}
