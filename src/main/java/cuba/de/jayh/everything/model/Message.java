package cuba.de.jayh.everything.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

public class Message implements Serializable {
    private String topic;
    private String question;
    private String name;
    private String email;
    private String lastname;
    private  LocalDateTime dateOfSend;

    private static List<Message> allMessages = new ArrayList<Message>();


    private enum Status {
        READ,
        UNREAD
    }

    private Status status;



    // als de persoon geen account heeft (wordt verzonden naar alle super-users)
    public Message(String topic,String question, String name,String lastname, String email){
        this.topic =topic;
        this.question =question;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.dateOfSend = LocalDateTime.now();
        this.status = Status.UNREAD;

        for(Message message: allMessages){
            if(message.equals(this)){
                throw new IllegalArgumentException("Account bestaat al");
            }
        }
        allMessages.add(this);
    }

    public static List<Message> getAllMessages() {
        return Collections.unmodifiableList(allMessages);
    }

    public static void setAllMessages(List<Message> loadedMessages) {
        allMessages.addAll(loadedMessages);
    }



    public String getTopic() {
        return topic;
    }

    public String getQuestion() {
        return question;
    }

    public LocalDateTime getDate() {
        return dateOfSend;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

//    public static boolean areAllNull(Object objects) {
//        return Stream.of(objects).allMatch(Objects::isNull);
//    }
//
//    public static boolean areAllNotNull(Object objects) {
//        return Stream.of(objects).allMatch(Objects::nonNull);
//    }



}




