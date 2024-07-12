public class BMI {
    private double height;
    private double weight;

    public BMI() {
        // Default constructor
        height = 0;
        weight = 0;
    }

    public BMI(double h, double w) {
        // Parameterized constructor
        height = h;
        weight = w;
    }

    public double calcBMI() {
        return weight / (height * height); // Calculate BMI
    }

    public String weightStatus() {
        double bmi = calcBMI();
        if (bmi < 18.5) {
            return "Underweight"; // BMI status
        } else if (bmi < 25) {
            return "Healthy weight";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    @Override
    public String toString() {
        return String.format("BMI: %.1f\nStatus: %s", calcBMI(), weightStatus()); // Override toString for BMI
    }
}
