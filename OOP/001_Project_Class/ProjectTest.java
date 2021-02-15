public class ProjectTest {
    public static void main(String[] args) {
        Project p1 = new Project("Project 1", "Description of project 1", 33.56);
        Project p2 = new Project("Project 2", "Description of project 2");
        Project p3 = new Project("Project 3");
        Project p4 = new Project();
        System.out.println(p1.getProject());
        System.out.println(p2.getProject());
        System.out.println(p3.getProject());
        System.out.println(p4.getProject());
    }
}