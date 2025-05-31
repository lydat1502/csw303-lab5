public class lowPriorityConcrete extends requestProduct{

    public lowPriorityConcrete(String priority, String expireDay, String status) {
        super(priority, expireDay, status);
    }
    public void setPriority(String priority) {
        super.setPriority(priority);
    }
    public void setExpireDay(String expireDay) {
        super.setExpireDay(expireDay);
    }
    public void setStatus(String status) {
        super.setStatus(status);
    }

    @Override
    public void processRequest(){
        System.out.println("Request denied");
    }
}
