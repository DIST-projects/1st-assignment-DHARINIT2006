import java.rmi.Naming;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        try {
            PerformanceService service =
                (PerformanceService) Naming.lookup(
                    "rmi://localhost:8000/PerformanceService");

            service.addStudent("S101", 88);
            service.addStudent("S102", 76);
            service.addStudent("S103", 92);
            service.addStudent("S104", 45);

            System.out.println("====== STUDENT PERFORMANCE REPORT ======");
            System.out.println("Total Students  : 4");
            System.out.println("Highest Marks   : " + service.getHighest());
            System.out.println("Lowest Marks    : " + service.getLowest());
            System.out.println("Average Marks   : " + service.getAverage());
            System.out.println("----------------------------------------");

            System.out.println("Student Grades:");
            for (Map.Entry<String, String> e :
                 service.getGrades().entrySet()) {
                System.out.println("Student " + e.getKey()
                                   + " -> Grade " + e.getValue());
            }

            System.out.println("====== END OF REPORT ======");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
