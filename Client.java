public class Client {
    public static void main(String[] args) {
        Contract permanent = new Permanent("123", "321", "456", "789");
        Contract shortTerm = new ShortTerm("123", "321", "456", "789");
        Contract longTerm = new LongTerm("123", "321", "456", "789");
    }
}
