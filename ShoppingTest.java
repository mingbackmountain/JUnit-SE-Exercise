package itcs371.ict.mahidol.ac.th;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingTest {

    ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getItemCount() {
        int quantity = cart.getItemCount();
        assertEquals(0, quantity);
    }

    @Test
    void isEmpty() {
        cart.empty();
        assertEquals(0, cart.getItemCount());
    }

    @Test
    void addNewProduct() {
        Product product = new Product("test", 32);
        int beforeAddQuantity = cart.getItemCount();

        cart.addItem(product);

        int afterAddQuantity = cart.getItemCount();
        assertEquals(beforeAddQuantity + 1, afterAddQuantity);
    }

    @Test
    void increaseBalance() {
        Product product = new Product("test", 32);
        double beforeBalance = cart.getBalance();

        cart.addItem(product);

        assertEquals(beforeBalance + product.getPrice(), cart.getBalance());
    }

    @Test
    void decreaseProduct() throws ProductNotFoundException {
        Product product = new Product("test", 32);
        cart.addItem(product);
        cart.removeItem(product);
        assertEquals(0, cart.getItemCount());

    }

    @Test
    void decreaseNotFoundProduct() {
        try {
            Product product = new Product("test", 32);
            Product notFoundProduct = new Product("test2", 30);
            cart.addItem(product);
            cart.removeItem(notFoundProduct);
        } catch (ProductNotFoundException e) {
            assertEquals(null, e.getMessage());
        }
    }

}