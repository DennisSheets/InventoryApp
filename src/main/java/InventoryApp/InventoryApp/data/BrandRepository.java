package InventoryApp.InventoryApp.data;

import InventoryApp.InventoryApp.models.Brand;
import InventoryApp.InventoryApp.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BrandRepository extends JpaRepository<Brand, Integer> {
//public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
