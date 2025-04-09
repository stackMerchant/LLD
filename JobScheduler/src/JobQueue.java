import java.util.LinkedList;
import java.util.Queue;

public class JobQueue {
    private final Queue<Job> jobs;

    JobQueue () {
        jobs = new LinkedList<>();
    }

    synchronized void push(Job job) {
        jobs.add(job);
        notify(); // Notify waiting workers
    }

    synchronized Job pop() throws InterruptedException {
        while (jobs.isEmpty()) { // Used while here to handle Spurious WakeUps
            wait(); // Make workers wait
        }
        return jobs.poll();
    }
}
