public class Main {
    public static void main(String[] args) {
        System.out.println("=== Start Application ===");

        JobQueue jobQueue = new JobQueue();
        new JobExecutor(3, jobQueue);

        jobQueue.push(generateJob("JOB_1", 1000));
        jobQueue.push(generateJob("JOB_2", 5000));
        jobQueue.push(generateJob("JOB_3", 2000));
        jobQueue.push(generateJob("JOB_4", 4000));
        jobQueue.push(generateJob("JOB_5", 1000));
        jobQueue.push(generateJob("JOB_6", 8000));

        System.out.println("=== End Application ===");
    }

    private static Job generateJob(String jobId, int latency) {
        return new Job(jobId, () -> {
            try {
                Thread.sleep(latency);
            } catch (Exception e) {
                System.out.println("Exception thrown: " + e.getMessage());
            }
        });
    }
}