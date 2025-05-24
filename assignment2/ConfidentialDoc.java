package assignment2;

public class ConfidentialDoc extends Document {
    public ConfidentialDoc() {
        super(".zip", "AES");
    }

    @Override
    public void buildDoc(String content) throws Exception {
        if (!"AES".equals(getEncryption())) {
            throw new IllegalStateException("ConfidentialDoc requires AES encryption");
        }
        String encryptedContent = AESExample.encrypt(content);
        System.out.println("Encrypted Confidential Content: " + encryptedContent);
    }
}