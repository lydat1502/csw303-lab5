import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Message {
    private final String content;
    private final String sender;
    private final String recipient;

    public Message(String content, String sender, String recipient) {
        // Note 1: Added input validation to prevent null or empty strings
        if (content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("Content cannot be null or empty");
        }
        if (sender == null || sender.trim().isEmpty()) {
            throw new IllegalArgumentException("Sender cannot be null or empty");
        }
        if (recipient == null || recipient.trim().isEmpty()) {
            throw new IllegalArgumentException("Recipient cannot be null or empty");
        }
        this.content = content;
        this.sender = sender;
        this.recipient = recipient;
    }

    // Getters for message properties
    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    // Note 2: Added toString for consistent output formatting
    @Override
    public String toString() {
        return String.format("From: %s, To: %s, Content: %s", sender, recipient, content);
    }

    // Note 3: Modified print methods to use PrintStream for flexibility
    // Note 4: Extracted common printing logic to avoid duplication
    private void printCommonFields(PrintStream out) {
        out.println(toString());
    }

    public void printSummary(PrintStream out) {
        printCommonFields(out);
    }

    public void printDetails(PrintStream out) {
        printCommonFields(out);
        out.println("Content Length: " + content.length());
        out.println("Sender Uppercase: " + sender.toUpperCase());
        out.println("Recipient Lowercase: " + recipient.toLowerCase());
    }
}

class MessagingService {
    private final Map<String, List<Message>> inbox;

    public MessagingService() {
        this.inbox = new HashMap<>();
    }

    public void sendMessage(String content, String sender, String recipient) {
        // Note 5: Validation moved to Message constructor, so no need here
        Message message = new Message(content, sender, recipient);
        inbox.computeIfAbsent(message.getRecipient(), k -> new ArrayList<>()).add(message);
    }

    // Note 6: Return unmodifiable list to prevent external modification
    public List<Message> getMessagesForRecipient(String recipient) {
        if (recipient == null || recipient.trim().isEmpty()) {
            throw new IllegalArgumentException("Recipient cannot be null or empty");
        }
        return Collections.unmodifiableList(inbox.getOrDefault(recipient, new ArrayList<>()));
    }

    // Note 7: Moved printing to MessagePrinter for SRP
    public void printAllMessages(PrintStream out) {
        MessagePrinter.printAllMessages(inbox, out);
    }
}

// Note 8: Created MessagePrinter to separate printing responsibility
class MessagePrinter {
    public static void printAllMessages(Map<String, List<Message>> inbox, PrintStream out) {
        for (String recipient : inbox.keySet()) {
            for (Message message : inbox.get(recipient)) {
                out.println(message.toString());
            }
        }
    }
}

public class Main {
    // Note 9: Replaced magic strings with a test data structure
    private static final List<String[]> TEST_MESSAGES = Arrays.asList(
        new String[]{"Hello, tenant!", "Property Manager", "Tenant A"},
        new String[]{"Important notice: Rent due next week.", "Property Owner", "Tenant A"},
        new String[]{"Maintenance request received.", "Tenant A", "Property Manager"}
    );

    public static void main(String[] args) {
        MessagingService messagingService = new MessagingService();
        // Note 10: Use test data for message sending
        for (String[] msg : TEST_MESSAGES) {
            messagingService.sendMessage(msg[0], msg[1], msg[2]);
        }

        // Note 11: Consistent output using toString
        List<Message> tenantAMessages = messagingService.getMessagesForRecipient("Tenant A");
        for (Message message : tenantAMessages) {
            System.out.println(message.toString());
        }

        // Note 12: Use PrintStream for flexibility
        Message exampleMessage = new Message("Test", "Sender", "Recipient");
        exampleMessage.printDetails(System.out);

        messagingService.printAllMessages(System.out);
    }
}