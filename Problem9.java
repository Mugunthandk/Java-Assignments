import java.util.Scanner;
abstract class Doctor {
    double consultationCharge;
    public Doctor(double consultationCharge) { this.consultationCharge = consultationCharge; }
    abstract String getDoctorType();
    public double calculateTotalBill(double testCharges) { return consultationCharge; }
}
class GeneralPhysician extends Doctor {
    public GeneralPhysician() { super(500.0); }
    @Override
    String getDoctorType() { return "General Physician"; }
}
class Specialist extends Doctor {
    public Specialist() { super(1000.0); }
    @Override
    String getDoctorType() { return "Specialist"; }
}
class EmergencyDoctor extends Doctor {
    public EmergencyDoctor() { super(1500.0); }
    @Override
    String getDoctorType() { return "Emergency Doctor"; }
    @Override
    public double calculateTotalBill(double testCharges) { return consultationCharge + testCharges; }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int doctorType = sc.nextInt();
        double testCharges = sc.nextDouble();
        Doctor doc = null;
        if(doctorType == 1) doc = new GeneralPhysician();
        else if(doctorType == 2) doc = new Specialist();
        else if(doctorType == 3) doc = new EmergencyDoctor();
        
        if(doc != null) {
            System.out.println("Doctor Type: " + doc.getDoctorType());
            System.out.printf("Consultation Charge: %.2f\n", doc.consultationCharge);
            System.out.printf("Test Charges: %.2f\n", testCharges);
            System.out.printf("Total Bill: %.2f\n", doc.calculateTotalBill(testCharges));
        }
        sc.close();
    }
}