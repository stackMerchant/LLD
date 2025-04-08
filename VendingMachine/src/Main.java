import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Start Application ===");

        // Initialize machine, initially it will have idle state
        VendingMachine vendingMachine = new VendingMachine();

        // Add products
        List<Product> products = new ArrayList<>();
        products.add(new Product("P1", 1, 1001, 1));
        products.add(new Product("P2", 2, 1002, 2));
        products.add(new Product("P3", 3, 1003, 3));
        vendingMachine.addProducts(products);

        System.out.println("\nRUN 1: Happy flow");

        vendingMachine.state.next(vendingMachine); // Move idle to coin collection
        vendingMachine.state.insertCoin(vendingMachine, new Coin()); // Add coins
        vendingMachine.state.insertCoin(vendingMachine, new Coin());
        vendingMachine.state.insertCoin(vendingMachine, new Coin());

        vendingMachine.state.next(vendingMachine); // Move coin collection to product selection
        vendingMachine.state.selectProduct(vendingMachine, 1001); // Select product

        vendingMachine.state.next(vendingMachine); // Move product selection to dispensing
        vendingMachine.state.dispenseAndIdle(vendingMachine); // Dispense and go to idle

        System.out.println("\nRUN 2: Insufficient money");

        vendingMachine.state.next(vendingMachine); // Move idle to coin collection
        vendingMachine.state.insertCoin(vendingMachine, new Coin()); // Add a coin
        vendingMachine.state.next(vendingMachine); // Move coin collection to product selection
        vendingMachine.state.selectProduct(vendingMachine, 1002); // Select product
        vendingMachine.state.next(vendingMachine); // Move product selection to dispensing
        vendingMachine.state.dispenseAndIdle(vendingMachine); // Dispense and go to idle

        System.out.println("\nRUN 3: Try to move ahead without inserting money, then abort");

        vendingMachine.state.next(vendingMachine); // Move idle to coin collection
        vendingMachine.state.next(vendingMachine); // Move coin collection to product selection
        vendingMachine.state.abort(vendingMachine); // Abort

        System.out.println("\nRUN 4: Try to move ahead without selecting product, then abort");

        vendingMachine.state.next(vendingMachine); // Move idle to coin collection
        vendingMachine.state.insertCoin(vendingMachine, new Coin()); // Add a coin
        vendingMachine.state.next(vendingMachine); // Move coin collection to product selection
        vendingMachine.state.next(vendingMachine); // // Move product selection to dispensing
        vendingMachine.state.abort(vendingMachine); // Abort

        System.out.println("=== End Application ===");
    }
}