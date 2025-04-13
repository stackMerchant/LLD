public class StudentDaoProxy {

    private StudentDaoService studentDaoService;

    StudentDaoProxy () {
        studentDaoService = new StudentDaoService();
    }

    void create(String role) {
        if (role.equals("ADMIN")) studentDaoService.create();
        else System.out.println("Access Denied to: " + role);
    }

}
