package assignment2;

public class Client {
    public static void main(String[] args) throws Exception{
        // Normal document
        Document normalDoc = new NormalDoc();
        System.out.println("Normal Document: " + normalDoc);
        normalDoc.buildDoc("This is a normal document content.");

        // Confidential document
        Document confidentialDoc = new ConfidentialDoc();
        System.out.println("Confidential Document: " + confidentialDoc);
        confidentialDoc.buildDoc("This is a confidential document content.");
        
    }
}