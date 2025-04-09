public class Worker implements Runnable {
    private JobQueue jobQueue;
    private int workerNumber;

    Worker(int _workerNumber, JobQueue _jobQueue) {
        workerNumber = _workerNumber;
        jobQueue = _jobQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Job job = jobQueue.pop(); // Get job
                job.task.run(); // Do job
                System.out.println("Worker: " + workerNumber + " completed job: " + job.jobId); // Print who did what
            } catch (Exception e) {
                System.out.println("Exception thrown: " + e.getMessage());
            }
        }
    }
}
