public class Person {
    private String name;
    private double height;
    private double weight;
    private double bmi;
    private static int totalParticipants = 0; // Static field for total participants

    public Person() {
        // Default constructor
        name = "";
        height = 0;
        weight = 0;
        bmi = 0;
    }

    public Person(String n, double h, double w) {
        // Parameterized constructor
        name = n;
        height = h;
        weight = w;
        bmi = calculateBMI();
        totalParticipants++;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double h) {
        height = h;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double w) {
        weight = w;
    }

    public double getBmi() {
        return bmi;
    }

    public static int getTotalParticipants() {
        return totalParticipants;
    }

    public double calculateBMI() {
        return weight / (height * height); // Calculate BMI
    }

    public String calcHeightFeetInches() {
        int feet = (int) (height * 39.3701) / 12;
        int inches = (int) (height * 39.3701) % 12;
        return "Height: " + feet + "ft " + inches + "in"; // Convert height to feet and inches
    }

    public String calcWeightPounds() {
        double weightPounds = weight * 2.20462;
        return String.format("Weight: %.2f lbs.", weightPounds); // Convert weight to pounds
    }

    @Override
    public String toString() {
        BMI bmiObj = new BMI(height, weight); // Create BMI object for status
        return String.format("Name: %s\nHeight (m): %.2fm\nWeight (kg): %.2fkg\n%s\n%s\nBMI: %.1f\nStatus: %s",
                             name, height, weight, calcHeightFeetInches(), calcWeightPounds(), bmi, bmiObj.weightStatus());
    }
}
