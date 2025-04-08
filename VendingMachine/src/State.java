public abstract class State {

    State() {
    }

    void next(VendingMachine vendingMachine) {
        System.out.println("Not allowed");
    }

    final void abort(VendingMachine vendingMachine) {
        System.out.println("Aborted");
        vendingMachine.abortAndClear();
        vendingMachine.state = new Idle();
    }

    void insertCoin(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Not allowed");
    }

    void selectProduct(VendingMachine vendingMachine, int position) {
        System.out.println("Not allowed");
    }

    void dispenseAndIdle(VendingMachine vendingMachine) {
        System.out.println("Not allowed");
    }

}

class Idle extends State {

    Idle() {
        System.out.println();
        System.out.println("Machine is idle...");
    }

    void next(VendingMachine vendingMachine) {
        vendingMachine.state = new CoinCollection();
    }

}

class CoinCollection extends State {

    CoinCollection() {
        System.out.println();
        System.out.println("Insert coins now...");
    }

    void insertCoin(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Coin added");
        vendingMachine.coins.add(coin);
    }

    void next(VendingMachine vendingMachine) {
        if (vendingMachine.coins.isEmpty()) {
            System.out.println("No money inserted");
            return;
        }
        vendingMachine.state = new ProductSelection();
    }

}

class ProductSelection extends State {

    ProductSelection() {
        System.out.println();
        System.out.println("Select product...");
    }

    void selectProduct(VendingMachine vendingMachine, int position) {
        System.out.println("Product at position: " + position + " selected");
        vendingMachine.selectedProductPosition = position;
    }

    void next(VendingMachine vendingMachine) {
        if (vendingMachine.selectedProductPosition == null) {
            System.out.println("No product selected");
            return;
        }
        vendingMachine.state = new DispenseState(vendingMachine);
    }

}

class DispenseState extends State {

    DispenseState(VendingMachine vendingMachine) {
        System.out.println();
        System.out.println("Dispensing...");
        vendingMachine.displayInputs();
    }

    void dispenseAndIdle(VendingMachine vendingMachine) {
        vendingMachine.dispense();
        vendingMachine.state = new Idle();
    }

}
