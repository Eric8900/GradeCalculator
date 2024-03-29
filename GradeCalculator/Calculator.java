import java.util.*;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //inputs bruh
        double maP = sc.nextDouble();
        double miP = sc.nextDouble();
        double oP = sc.nextDouble();

        double gWant = sc.nextDouble();

        String isTest = sc.next();

        int numMajor = sc.nextInt();
        int numMinor = sc.nextInt();

        ArrayList<Integer> major = new ArrayList<>();
        ArrayList<Integer> minor = new ArrayList<>();

        for (int i = 0; i < numMajor; i++) {
            major.add(sc.nextInt());
        }
        
        for (int i = 0; i < numMinor; i++) {
            minor.add(sc.nextInt());
        }

        int gNeed = 0;
        //quiz grade needed
        if (isTest.equals("quiz")) {
            for (int i = 0; i < 130; i++) {
                minor.add(i);
                if (round((avg(minor) * miP) + (avg(major) * maP) + (100 * oP)) >= gWant) {
                    gNeed = i;
                    break;
                }
                minor.remove(numMinor);
            }
        }
        //test grade needed
        else if (isTest.equals("test")) {
            for (int i = 0; i < 130; i++) {
                major.add(i);
                if (round((avg(minor) * miP) + (avg(major) * maP) + (100 * oP)) >= gWant) {
                    gNeed = i;
                    break;
                }
                major.remove(numMajor);
            }
        }
        if (gNeed > 80) {
            System.out.println("You can do it! You need at least a " + gNeed + " on the " + isTest + " to get a " + gWant);
        }
        else if (gNeed > 70) {
            System.out.println("You can relax a little! You need at least a " + gNeed + " on the " + isTest + " to get a " + gWant);
        }
        else if (gNeed > 0) {
            System.out.println("Don't even study! You need at least a " + gNeed + " on the " + isTest + " to get a " + gWant);
        }
        if (gNeed == 0) {
            System.out.println("Skip the class for that day! You need a " + gNeed + " on the " + isTest + " to get a " + gWant);
        }
    }
    public static double avg(ArrayList<Integer> g) {
        int sum = 0;
        for (int i = 0; i < g.size(); i++) {
            sum += g.get(i);
        }
        return (double) sum / g.size();
    }
    public static double round(double r) {
        double abs = Math.abs(r);
        double min = Math.floor(abs);
        if (abs - min >= 0.5) {
            return Math.ceil(r);
        } 
        return (double)min;
    }
}