import java.util.Scanner;
interface AccessControl {
    String getRole();
    int getAccessLevel();
    boolean canAccess(int requiredLevel);
}
class Developer implements AccessControl {
    public String getRole() { return "Developer"; }
    public int getAccessLevel() { return 1; }
    public boolean canAccess(int requiredLevel) { return getAccessLevel() >= requiredLevel; }
}
class Manager implements AccessControl {
    public String getRole() { return "Manager"; }
    public int getAccessLevel() { return 2; }
    public boolean canAccess(int requiredLevel) { return getAccessLevel() >= requiredLevel; }
}
class Administrator implements AccessControl {
    public String getRole() { return "Administrator"; }
    public int getAccessLevel() { return 3; }
    public boolean canAccess(int requiredLevel) { return getAccessLevel() >= requiredLevel; }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int roleType = sc.nextInt();
        int requiredLevel = sc.nextInt();
        AccessControl ac = null;
        if(roleType == 1) ac = new Developer();
        else if(roleType == 2) ac = new Manager();
        else if(roleType == 3) ac = new Administrator();
        
        if(ac != null) {
            System.out.println("Role: " + ac.getRole());
            System.out.println("Access Level: " + ac.getAccessLevel());
            System.out.println("Can Access: " + ac.canAccess(requiredLevel));
        }
        sc.close();
    }
}