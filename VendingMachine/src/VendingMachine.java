import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    State state;
    List<Product> products;

    // Dynamic fields, cleared after a cycle
    List<Coin> coins;
    Integer selectedProductPosition;

    VendingMachine() {
        state = new Idle();
        products = new ArrayList<>();
        coins = new ArrayList<>();
        selectedProductPosition = null;
    }

    void addProducts(List<Product> _products) {
        products.addAll(_products);
    }

    void abortAndClear() {
        int insertedMoney = getMoney();
        if (insertedMoney > 0)
            System.out.println("Dispensed money: " + insertedMoney);
        clear();
    }

    void displayInputs() {
        int insertedMoney = getMoney();
        Product selectedProduct = getSelectedProduct();
        System.out.println("Selected product: " + selectedProduct.name + " and it costs: " + selectedProduct.cost);
        System.out.println("Inserted money: " + insertedMoney);
    }

    void dispense() {
        int insertedMoney = getMoney();
        Product selectedProduct = getSelectedProduct();

        // If insufficient funds
        if (insertedMoney < selectedProduct.cost) {
            System.out.println("Insufficient money: " + insertedMoney);
            System.out.println("Returning money: " + insertedMoney);
            clear(); // Clear selection
            return;
        }

        // If insufficient product stock
        if (selectedProduct.stockCount <= 0) {
            System.out.println("Insufficient product stock: " + selectedProduct.stockCount);
            System.out.println("Returning money: " + insertedMoney);
            clear(); // Clear selection
            return;
        }

        // Dispense product and decrease stock
        System.out.println("Dispensed product: " + selectedProduct.name);
        selectedProduct.stockCount -= 1;

        if (insertedMoney > selectedProduct.cost) System.out.println("Dispensed change: " + (insertedMoney - selectedProduct.cost));
        clear(); // Clear selection
    }

    private void clear() {
        coins = new ArrayList<>();
        selectedProductPosition = null;
    }

    private Integer getMoney() {
        int totalValue = 0;
        for (Coin c: coins) totalValue += c.value;
        return totalValue;
    }

    private Product getSelectedProduct() {
        for (Product p: products)
            if (p.position == selectedProductPosition)
                return p;

        throw new IllegalStateException("Reached dispense state without selected product");
    }

}
