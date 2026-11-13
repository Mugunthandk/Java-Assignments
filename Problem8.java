import java.util.Scanner;
abstract class Course {
    double courseFee;
    public Course(double courseFee) { this.courseFee = courseFee; }
    abstract double calculateDiscount();
    abstract String getCourseType();
    public double calculateFinalFee() { return courseFee - calculateDiscount(); }
}
class ProgrammingCourse extends Course {
    public ProgrammingCourse(double courseFee) { super(courseFee); }
    @Override
    double calculateDiscount() { return courseFee * 0.10; }
    @Override
    String getCourseType() { return "Programming"; }
}
class DataScienceCourse extends Course {
    public DataScienceCourse(double courseFee) { super(courseFee); }
    @Override
    double calculateDiscount() { return courseFee * 0.15; }
    @Override
    String getCourseType() { return "Data Science"; }
}
class CloudCourse extends Course {
    public CloudCourse(double courseFee) { super(courseFee); }
    @Override
    double calculateDiscount() { return courseFee * 0.05; }
    @Override
    String getCourseType() { return "Cloud"; }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int courseType = sc.nextInt();
        double courseFee = sc.nextDouble();
        Course course = null;
        if(courseType == 1) course = new ProgrammingCourse(courseFee);
        else if(courseType == 2) course = new DataScienceCourse(courseFee);
        else if(courseType == 3) course = new CloudCourse(courseFee);
        
        if(course != null) {
            System.out.println("Course Type: " + course.getCourseType());
            System.out.printf("Discount: %.2f\n", course.calculateDiscount());
            System.out.printf("Final Fee: %.2f\n", course.calculateFinalFee());
        }
        sc.close();
    }
}