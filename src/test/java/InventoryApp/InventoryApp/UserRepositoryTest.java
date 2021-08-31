package InventoryApp.InventoryApp;
import InventoryApp.InventoryApp.data.UserRepository;
import InventoryApp.InventoryApp.models.Role;
import InventoryApp.InventoryApp.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;



@DataJpaTest
@AutoConfigureTestDatabase
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test  // Test 1
    public  void test(){}

    @Test   // test 2
    public void testCreateRoles(){
        Role roleAdmin = new Role("Administrator");
        Role roleEditor = new Role("Editor");
        Role roleAVisitor = new Role("Visitor");

        entityManager.persist(roleAdmin);
        entityManager.persist(roleEditor);
        entityManager.persist(roleAVisitor);
        }

    @Test    // Test 3
    public void testCreateNewUserWithOneRole() {
        Role roleAdmin = entityManager.find(Role.class,1);
        User user = new User("madsur@yahoo.com","asdf1234");
        user.addRole(roleAdmin);

        userRepository.save(user);
    }

    @Test    // Test 4
    public void testCreateNewUserWithTwoRoles() {
        Role roleEditor = entityManager.find(Role.class,2);
        Role roleVisitor = entityManager.find(Role.class,3);
        User user = new User("mudsur@yahoo.com","asdf1234");
        user.addRole(roleEditor);
        user.addRole(roleVisitor);

        userRepository.save(user);
    }

    @Test    // Test 5
    public void testAssignRoleToExistingUser() {
        User user = userRepository.findById(1).get();
        Role roleEditor = entityManager.find(Role.class,2);
        user.addRole(roleEditor);

    }

//    @Test    // Test 6
//    public void testRemoveRoleFromExistingUser() {
//        User user = userRepository.findById(1).get();
//        Role role = new Role(1);
//        user.removeRole(role);
//    }

    @Test    // Test 7
    public void testCreateNewUserWithNewRole() {
        Role roleSalesperson = new Role("Salesperson");
        User user = new User("madsur@lycos.com", "thatsOLD");
        user.addRole(roleSalesperson);
    }

    @Test    // Test 8
    public void testGetUser() {
        User user = userRepository.findById(1).get();
        entityManager.detach(user);

        System.out.println(user.getUsername());
        System.out.println(user.getRoles());
    }

    @Test    // Test 9
    public void testRemoveUser() {
        userRepository.deleteById(4);
    }































}
