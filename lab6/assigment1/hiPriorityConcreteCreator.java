public class hiPriorityConcreteCreator implements RequestCreator{
    private requestProduct request;

    @Override
    public requestProduct createRequest(String priority, String expireDay, String status) {
        this.request = new highPriorityConcrete(priority, expireDay, status);
        return request;
    }

    @Override
    public void processRequest() {
        request.processRequest();
    }
}
