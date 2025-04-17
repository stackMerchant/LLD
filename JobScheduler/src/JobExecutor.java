public class JobExecutor {

    JobExecutor(int _workerCount, JobQueue _jobQueue) {

        Runnable runnableWorker = () -> {
            while (true) {
                try {
                    Job job = _jobQueue.pop(); // Get job
                    job.task.run(); // Do job
                    System.out.println(Thread.currentThread().getName() + " completed job: " + job.jobId);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        for (int i = 0; i < _workerCount; i++) {
            new Thread(runnableWorker).start();
        }
    }
}
