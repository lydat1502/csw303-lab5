public interface RequestCreator {
    public static void main(String[] args) {
        System.out.println("\n");
        RequestCreator low = new lowPriorityConcreteCreator();
        System.out.println(low.createRequest("Ignore", "31/05/2025", "Done"));
        low.processRequest();

        System.out.println();

        RequestCreator mid = new midPriorityConcreteCreator();
        System.out.println(mid.createRequest("Medium", "31/06/2025", "Accepted"));
        mid.processRequest();

        System.out.println();

        RequestCreator hight = new hiPriorityConcreteCreator();
        System.out.println(hight.createRequest("Emergency", "31/05/2025", "Accept"));
        hight.processRequest();
    }
    requestProduct createRequest(String priority, String expireDay, String status);
    void processRequest();
}
