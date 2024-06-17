import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Policy> policies = new ArrayList<>();
        try {
            Scanner fileScanner = new Scanner(new File("PolicyInformation.txt"));
            while (fileScanner.hasNext()) {
                int policyNumber = fileScanner.nextInt();
                String providerName = fileScanner.next();
                String firstName = fileScanner.next();
                String lastName = fileScanner.next();
                int age = fileScanner.nextInt();
                String smokingStatus = fileScanner.next();
                double height = fileScanner.nextDouble();
                double weight = fileScanner.nextDouble();
                policies.add(new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight));
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Display policy information
        for (Policy policy : policies) {
            System.out.println(policy);
        }

        // Count smokers and non-smokers
        int smokerCount = 0;
        int nonSmokerCount = 0;
        for (Policy policy : policies) {
            if (policy.getSmokingStatus().equals("smoker")) {
                smokerCount++;
            } else {
                nonSmokerCount++;
            }
        }
        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }
}
