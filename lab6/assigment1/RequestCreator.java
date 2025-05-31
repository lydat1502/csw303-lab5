
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface RequestCreator {
    static LocalDate curDay = LocalDate.now(); 
    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("\n");
        RequestCreator low = new lowPriorityConcreteCreator();
        System.out.println(low.createRequest("Ignore", curDay.format(formatter), "Done"));
        low.processRequest();

        System.out.println();

        RequestCreator mid = new midPriorityConcreteCreator();
        System.out.println(mid.createRequest("Medium", curDay.plusMonths(1).format(formatter), "Accepted"));
        mid.processRequest();

        System.out.println();

        RequestCreator hight = new hiPriorityConcreteCreator();
        System.out.println(hight.createRequest("Emergency", curDay.format(formatter), "Accept"));
        hight.processRequest();
    }
    requestProduct createRequest(String priority, String expireDay, String status);
    void processRequest();
}
