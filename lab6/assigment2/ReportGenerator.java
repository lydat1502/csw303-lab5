
import java.util.List;

class Property {
    private String name;
    private double rentAmount;
    private PropertyInfo info;

    public Property(String name, double rentAmount, PropertyInfo info) { //Constructor with a data clump
        this.name = name;
        this.rentAmount = rentAmount;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void printPropertyDetails() {
        System.out.println("Property: " + name);
        System.out.println("Rent Amount: $" + rentAmount);
        System.out.println("Owner: " + info.getOwnerName());
        System.out.println("Location: " + info.getLocation());
    }
    // new for long Method and switch case
    public String getCategory() {
        return rentAmount > 2000 ? "premium" : "standard";
    }

    public double getYearlyRent() {
        return rentAmount * 12;
    }
}
// add new class for data clump
class PropertyInfo{
    private String ownerName;
    private String location;

    public PropertyInfo(String ownerName, String location) {
        this.ownerName = ownerName;
        this.location = location;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getLocation() {
        return location;
    }
}
class FinancialReport {

    private static String separator = "--------------------";
    private String reportTitle;
    private List<Property> properties;
    private double totalRent;

    public FinancialReport(String reportTitle, List<Property> properties) {
        this.reportTitle = reportTitle;
        this.properties = properties;
    }
    public void printHeard(){
        System.out.println("Financial Report: " + reportTitle);
        System.out.println(separator);
    }
    public void printFoot(Property property){
        double yearlyRent = property.getYearlyRent();
        System.out.println("Yearly Rent: $" + yearlyRent);
        System.out.println(separator);
    }
    public void generateReport() {
        totalRent = 0;
        printHeard();
        for (Property property : properties) {
            property.printPropertyDetails();
            totalRent += property.getRentAmount();
            System.out.println("This is a "+property.getCategory()+" property.");
            printFoot(property);
        }
        System.out.println("Total Rent Amount: $" + totalRent);
    }
}

public class ReportGenerator {

    public static void main(String[] args) {
        PropertyInfo info1 = new PropertyInfo("John Doe", "City Center");
        Property property1 = new Property("Apartment A", 1500.0, info1);
        PropertyInfo info2 = new PropertyInfo("Jane Smith", "Suburb");
        Property property2 = new Property("House B", 2000.0, info2);
        PropertyInfo info3 = new PropertyInfo("Bob Johnson", "Downtown");
        Property property3 = new Property("Condo C", 1800.0, info3);
        FinancialReport financialReport = new FinancialReport("Monthly Rent Summary", List.of(property1, property2, property3));
        financialReport.generateReport();
    }
}

// data clump in Property
// Long Method in generateReport
// Switch/Conditional if else
