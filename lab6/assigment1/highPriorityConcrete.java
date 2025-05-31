public class highPriorityConcrete extends requestProduct{

    public highPriorityConcrete(String priority, String expireDay, String status) {
        super(priority, expireDay, status);
        //TODO Auto-generated constructor stub
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
        System.out.println("Emergency request, our Administer will contact you immediately !");
    }

    
}