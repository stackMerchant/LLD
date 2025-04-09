public class RequestProcessor implements Runnable {
    private RequestQueue requestQueue;
    private Inventory inventory;

    public RequestProcessor(RequestQueue requestQueue, Inventory inventory) {
        this.requestQueue = requestQueue;
        this.inventory = inventory;
    }

    @Override
    public void run() {
        while (true) {
            try {
                while (requestQueue.isEmpty()) {
                    System.out.println("Waiting for requests...");
                    Thread.sleep(500);
                }
                popAndProcess();
            } catch (Exception e) {
                System.out.println("Exception thrown: " + e.getMessage());
            }
        }
    }

    private void popAndProcess() {
        UpsertRequest upsertRequest = requestQueue.pop();
        if (upsertRequest != null) {
            inventory.upsertStock(upsertRequest.productId, upsertRequest.delta);
            System.out.println("Stock of: " + upsertRequest.productId + " updated by " + upsertRequest.delta);
        }
    }
}
