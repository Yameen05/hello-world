public class Policy {
    private int policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

    public Policy(int policyNum, String provider, String first, String last, int personAge, String smoking, double personHeight, double personWeight) {
        policyNumber = policyNum;
        providerName = provider;
        firstName = first;
        lastName = last;
        age = personAge;
        smokingStatus = smoking;
        height = personHeight;
        weight = personWeight;
    }

    // Getter methods
    public int getPolicyNumber() {
        return policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    // Method to calculate BMI
    public double calculateBMI() {
        return (weight / (height * height)) * 703;
    }

    // Method to calculate Policy Price (Placeholder logic)
    public double calculatePolicyPrice() {
        return 700.00;
    }

    // toString method for display
    public String toString() {
        return "Policy Number: " + policyNumber + "\n" +
               "Provider Name: " + providerName + "\n" +
               "Policyholder's First Name: " + firstName + "\n" +
               "Policyholder's Last Name: " + lastName + "\n" +
               "Policyholder's Age: " + age + "\n" +
               "Policyholder's Smoking Status: " + smokingStatus + "\n" +
               "Policyholder's Height: " + height + " inches\n" +
               "Policyholder's Weight: " + weight + " pounds\n" +
               "Policyholder's BMI: " + String.format("%.2f", calculateBMI()) + "\n" +
               "Policy Price: $" + String.format("%.2f", calculatePolicyPrice()) + "\n";
    }
}
