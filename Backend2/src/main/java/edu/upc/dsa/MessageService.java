package edu.upc.dsa;



import edu.upc.dsa.models.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageService {

    public List<Message> getMessages() {
        List<Message> messages = new ArrayList<>();
        messages.add(new Message("Hello, world!"));
        messages.add(new Message("Welcome to our API!"));
        messages.add(new Message("This is a list of messages."));
        messages.add(new Message("Hola"));
        return messages;
    }
}
