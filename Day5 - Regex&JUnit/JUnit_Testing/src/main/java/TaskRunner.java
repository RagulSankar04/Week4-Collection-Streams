public class TaskRunner {
    public String longRunningTask(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Task Complete";
    }
}
