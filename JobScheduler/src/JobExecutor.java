public class JobExecutor {

    JobExecutor(int workerCount, JobQueue jobQueue) {
        for (int i = 0; i < workerCount; i++) {
            Worker worker = new Worker(i + 1, jobQueue);
            new Thread(worker).start();
        }
    }

}
