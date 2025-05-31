import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Note 1: Introduced Address class to reduce data clump
class Address {
    private final String ownerName;
    private final String location;

    public Address(String ownerName, String location) {
        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Owner name cannot be null or empty");
        }
        if (location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException("Location cannot be null or empty");
        }
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

class Property {
    private final String name;
    private final double rentAmount;
    private final Address address;

    public Property(String name, double rentAmount, Address address) {
        // Note 2: Added input validation
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (rentAmount < 0) {
            throw new IllegalArgumentException("Rent amount cannot be negative");
        }
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        this.name = name;
        this.rentAmount = rentAmount;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public Address getAddress() {
        return address;
    }

    // Note 3: Added toString for consistent formatting
    @Override
    public String toString() {
        return String.format("Property: %s, Rent Amount: $%.2f, Owner: %s, Location: %s",
                name, rentAmount, address.getOwnerName(), address.getLocation());
    }

    // Note 4: Modified to use PrintStream
    public void printPropertyDetails(PrintStream out) {
        out.println(toString());
    }
}

class FinancialReport {
    private static final double PREMIUM_THRESHOLD = 2000.0; // Note 5: Constant for magic number
    private static final String PREMIUM_LABEL = "This is a premium property.";
    private static final String STANDARD_LABEL = "This is a standard property.";

    private final String reportTitle;
    private final List<Property> properties;
    private double totalRent;

    public FinancialReport(String reportTitle, List<Property> properties) {
        // Note 6: Added validation and defensive copy
        if (reportTitle == null || reportTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("Report title cannot be null or empty");
        }
        if (properties == null) {
            throw new IllegalArgumentException("Properties list cannot be null");
        }
        this.reportTitle = reportTitle;
        this.properties = new ArrayList<>(properties); // Defensive copy
    }

    public double calculateTotalRent() {
        // Note 7: Separated computation from presentation
        totalRent = 0;
        for (Property property : properties) {
            totalRent += property.getRentAmount();
        }
        return totalRent;
    }

    // Note 8: Moved printing to ReportPrinter
    public void generateReport(PrintStream out) {
        ReportPrinter.printReport(this, out);
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public List<Property> getProperties() {
        return Collections.unmodifiableList(properties); // Note 9: Unmodifiable list
    }

    public double getTotalRent() {
        return totalRent;
    }
}

// Note 10: Created ReportPrinter for SRP
class ReportPrinter {
    private static final double PREMIUM_THRESHOLD = 2000.0;
    private static final String PREMIUM_LABEL = "This is a premium property.";
    private static final String STANDARD_LABEL = "This is a standard property.";

    public static void printReport(FinancialReport report, PrintStream out) {
        out.println("Financial Report: " + report.getReportTitle());
        out.println("----------------------------");
        for (Property property : report.getProperties()) {
            property.printPropertyDetails(out);
            out.println(property.getRentAmount() > PREMIUM_THRESHOLD ? PREMIUM_LABEL : STANDARD_LABEL);
            double yearlyRent = property.getRentAmount() * 12;
            out.println(String.format("Yearly Rent: $%.2f", yearlyRent));
            out.println("--------------------");
        }
        out.println(String.format("Total Rent Amount: $%.2f", report.getTotalRent()));
    }
}

public class ReportGenerator {
    // Note 11: Replaced magic data with test data structure
    private static final List<Property> TEST_PROPERTIES = Arrays.asList(
        new Property("Apartment A", 1500.0, new Address("John Doe", "City Center")),
        new Property("House B", 2000.0, new Address("Jane Smith", "Suburb")),
        new Property("Condo C", 1800.0, new Address("Bob Johnson", "Downtown"))
    );

    public static void main(String[] args) {
        FinancialReport financialReport = new FinancialReport("Monthly Rent Summary", TEST_PROPERTIES);
        financialReport.calculateTotalRent(); // Note 12: Calculate before printing
        financialReport.generateReport(System.out);
    }
}