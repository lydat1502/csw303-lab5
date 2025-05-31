public abstract class  requestProduct {
    private String priority;
    private String expireDay;
    private String status;
    public requestProduct(String priority, String expireDay, String status) {
        this.priority = priority;
        this.expireDay = expireDay;
        this.status = status;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public void setExpireDay(String expireDay) {
        this.expireDay = expireDay;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getExpireDay() {
        return expireDay;
    }
    public String getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }
    
    public abstract void processRequest();

    @Override
    public String toString() {
        return "requestProduct: priority=" + priority + ", expireDay=" + expireDay + ", status=" + status;
    }
    
    
    
}