package InventoryApp.InventoryApp.data;

import InventoryApp.InventoryApp.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
//public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
