import java.util.Scanner;
import java.io.File;

public class Demo {
    public static void main(String[] args) {
        Policy[] policies = new Policy[100];
        int policyCount = 0;

        Scanner fileScanner = new Scanner("");
        Scanner lineScanner = new Scanner("");

        // Open the file
        fileScanner = new Scanner(getFile("PolicyInformation.txt"));

        // Read each line and create Policy objects
        while (fileScanner.hasNextLine()) {
            lineScanner = new Scanner(fileScanner.nextLine());
            lineScanner.useDelimiter(" ");

            int policyNum = lineScanner.nextInt();
            String provider = lineScanner.next();
            String first = lineScanner.next();
            String last = lineScanner.next();
            int personAge = lineScanner.nextInt();
            String smoking = lineScanner.next();
            double personHeight = lineScanner.nextDouble();
            double personWeight = lineScanner.nextDouble();

            policies[policyCount] = new Policy(policyNum, provider, first, last, personAge, smoking, personHeight, personWeight);
            policyCount++;
        }

        // Display policy information
        for (int i = 0; i < policyCount; i++) {
            System.out.println(policies[i]);
        }

        // Count smokers and non-smokers
        int smokerCount = 0;
        int nonSmokerCount = 0;
        for (int i = 0; i < policyCount; i++) {
            if (policies[i].smokingStatus.equals("smoker")) {
                smokerCount++;
            } else {
                nonSmokerCount++;
            }
        }
        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }

    public static File getFile(String fileName) {
        return new File(fileName);
    }
}
