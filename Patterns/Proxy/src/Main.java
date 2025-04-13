public class Main {
    public static void main(String[] args) {
        System.out.println("=== Start Application ===");

        StudentDaoProxy studentDaoProxy = new StudentDaoProxy();
        studentDaoProxy.create("TEACHER");
        studentDaoProxy.create("STUDENT");
        studentDaoProxy.create("ADMIN");

        System.out.println("=== End Application ===");
    }
}