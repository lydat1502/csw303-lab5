package assignment2;

public class NormalDoc extends Document {
    public NormalDoc() {
        super(".txt", "none");
    }

    @Override
    public void buildDoc(String content) {
        if (!"none".equals(getEncryption())) {
            throw new IllegalStateException("NormalDoc should have no encryption");
        }
        System.out.println("Normal Document Content: " + content);
    }
}