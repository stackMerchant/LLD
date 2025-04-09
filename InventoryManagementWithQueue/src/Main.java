public class Main {
    public static void main(String[] args) {
        System.out.println("=== Start Application ===");

        Inventory inventory = new Inventory();
        RequestQueue requestQueue = new RequestQueue();
        RequestProcessor requestProcessor = new RequestProcessor(requestQueue, inventory);

        // Start worker threads to process requests
        Thread requestProcessorThread = new Thread(requestProcessor);
        requestProcessorThread.start();

        // Push requests to queue
        requestQueue.push(new UpsertRequest("P1", 10));
        requestQueue.push(new UpsertRequest("P2", 5));

        // Wait for 2 seconds
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }

        // Push more requests to queue
        requestQueue.push(new UpsertRequest("P3", 6));
        requestQueue.push(new UpsertRequest("P1", -12));
        requestQueue.push(new UpsertRequest("P1", -8));
        requestQueue.push(new UpsertRequest("P3", -4));
    }
}