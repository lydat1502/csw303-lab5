public class mediumPriorityConcrete extends requestProduct{

    public mediumPriorityConcrete(String priority, String expireDay, String status) {
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
        System.out.println("Request accepted, estimated completion date is " + super.getExpireDay());
    }
}
