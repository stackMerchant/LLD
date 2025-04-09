import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {

    private final Queue<UpsertRequest> queue;

    RequestQueue() {
        queue = new LinkedList<>();
    }

    public synchronized void push(UpsertRequest request) {
        queue.add(request);
    }

    public synchronized UpsertRequest pop() {
        return queue.poll();
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }

}
