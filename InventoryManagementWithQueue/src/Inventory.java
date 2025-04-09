import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Integer> productIdToStockMap; // Key: Product ID, Value: Stock

    public Inventory () {
        productIdToStockMap = new HashMap<>();
    }

    public synchronized Integer getStock(String productId) {
        return productIdToStockMap.getOrDefault(productId, 0);
    }

    // Update or insert
    public synchronized void upsertStock(String productId, int delta) {
        int updatedStock = getStock(productId) + delta;
        if (updatedStock >= 0) productIdToStockMap.put(productId, updatedStock);
        else throw new RuntimeException("Insufficient stock for product " + productId);
    }

}
