package InventoryApp.InventoryApp;

import InventoryApp.InventoryApp.data.CartItemRepository;
import InventoryApp.InventoryApp.models.CartItem;
import InventoryApp.InventoryApp.models.Product;
import InventoryApp.InventoryApp.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(value = false)
public class ShoppingCartTests {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test // Test 1
    public void test() { }

    @Test // Test 2
    public void testAddItemFromDatabase() {
        Product product = entityManager.find(Product.class, 1);
        User user = entityManager.find(User.class, 1);

        CartItem item = new CartItem(1, product, user);
        cartItemRepository.save(item);
    }

//    @Test
//    public void testAddItemByIds(){
//        Product product = new Product(2);
//        User user = new User(2);
//
//        CartItem item = new CartItem(2,product, user);
//        cartItemRepository.save(item);
//    }

//    @Test
//    public void testAddMultipleItems() {
//        User user = new User(1);
//        Product product1 = new Product(1);
//        Product product2 = new Product(2);
//        Product product3 = new Product(3);
//
//        CartItem item1 = new CartItem(1,product1, user);
//        CartItem item2 = new CartItem(2,product2, user);
//        CartItem item3 = new CartItem(3,product3, user);
//
//        cartItemRepository.saveAll(List.of(item1,item2,item3));
//    }

    @Test
    public void testListItems(){
        List<CartItem> listItems = cartItemRepository.findAll();
        listItems.forEach(System.out::println);
    }

    @Test
    public void testUpdateItem() {
        CartItem cartItem = cartItemRepository.findById(1).get();
        cartItem.setQuantity(10);
        cartItem.setProduct(new Product(3));
    }

    @Test
    public void testRemoveItem() {
        cartItemRepository.deleteById(1);
    }




}
