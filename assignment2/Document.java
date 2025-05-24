package assignment2;

public abstract class Document {
    private String extension;
    private String encryption;

    protected Document(String extension, String encryption) {
        this.extension = extension;
        this.encryption = encryption;
    }

    public String getExtension() {
        return extension;
    }

    public String getEncryption() {
        return encryption;
    }

    public abstract void buildDoc(String content) throws Exception;

    @Override
    public String toString() {
        return "extension: " + extension + ", encryption: " + encryption;
    }
}