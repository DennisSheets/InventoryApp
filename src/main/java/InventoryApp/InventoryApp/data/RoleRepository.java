package InventoryApp.InventoryApp.data;

import InventoryApp.InventoryApp.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
