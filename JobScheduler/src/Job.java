public class Job {
    String jobId;
    Runnable task;

    Job(String _jobId, Runnable _task) {
        jobId = _jobId;
        task = _task;
    }
}
