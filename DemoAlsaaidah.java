import java.util.ArrayList;
import java.util.Scanner;

public class DemoAlsaaidah {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        ArrayList<Person> persons = new ArrayList<>(); // List to store Person objects
        boolean continueInput = true;

        while (continueInput) {
            System.out.println("Enter a person's name:");
            String name = scanner.nextLine();

            double height = 0;
            while (true) {
                // Prompt for height and validate input range
                System.out.println("Enter height in total meters (example 5ft. 10in. = 1.778 meters, min: 1.016 meters - max 2.413 meters):");
                height = scanner.nextDouble();
                if (height >= 1.016 && height <= 2.413) break;
                else System.out.println("Invalid height, please try again!");
            }

            double weight = 0;
            while (true) {
                // Prompt for weight and validate input range
                System.out.println("Enter weight in kilograms (example 125 lbs. = 56.699kg, min: 34.0194kg - max 362.874kg):");
                weight = scanner.nextDouble();
                if (weight >= 34.0194 && weight <= 362.874) break;
                else System.out.println("Invalid weight, please try again!");
            }
            
            scanner.nextLine(); // Consume newline

            // Create a new Person object and add to list
            Person person = new Person(name, height, weight);
            persons.add(person);

            while (true) {
                // Prompt to continue or quit
                System.out.println("Do you wish to enter information for another person (Y/Yes/Continue, to continue, N/No/Quit to quit)?");
                String response = scanner.nextLine().trim().toLowerCase();
                if (response.equals("y") || response.equals("yes") || response.equals("continue")) {
                    continueInput = true;
                    break;
                } else if (response.equals("n") || response.equals("no") || response.equals("quit")) {
                    continueInput = false;
                    break;
                } else {
                    System.out.println("Incorrect answer, please try again!");
                }
            }
        }

        // Variables for BMI calculations
        double totalBMI = 0;
        int underweightCount = 0;
        int healthyWeightCount = 0;
        int overweightCount = 0;
        int obeseCount = 0;

        System.out.println("\nParticipant List");
        System.out.println("-----------------------------------");

        // Iterate through persons and print details
        for (Person person : persons) {
            System.out.println(person);
            System.out.println("-----------------------------------");

            double bmi = person.getBmi();
            totalBMI += bmi;

            // Count BMI categories
            if (bmi < 18.5) {
                underweightCount++;
            } else if (bmi < 25) {
                healthyWeightCount++;
            } else if (bmi < 30) {
                overweightCount++;
            } else {
                obeseCount++;
            }
        }

        int totalParticipants = Person.getTotalParticipants();
        double averageBMI = totalParticipants > 0 ? totalBMI / totalParticipants : 0;

        // Print summary statistics (outputs)
        System.out.printf("Total participants: %d\n", totalParticipants);
        System.out.printf("Average BMI: %.1f\n", averageBMI);
        System.out.println("BMI Status Breakdown:");
        System.out.printf("     Underweight: %d\n", underweightCount);
        System.out.printf("     Healthy Weight: %d\n", healthyWeightCount);
        System.out.printf("     Overweight: %d\n", overweightCount);
        System.out.printf("     Obese: %d\n", obeseCount);
    }
}
