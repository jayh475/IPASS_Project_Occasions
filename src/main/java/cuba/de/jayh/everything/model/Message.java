package cuba.de.jayh.everything.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.stream.Stream;

public class Message implements Serializable {
    private String topic;
    private String question;
    private String name;
    private String email;
    private String lastname;
    private  String dateOfSend;

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
        this.dateOfSend =  LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)).toString();
        this.status = Status.UNREAD;

        for(Message message: allMessages){
            if(message.equals(this)){
                throw new IllegalArgumentException("Account bestaat al");
            }
        }
        allMessages.add(this);
    }

    public static Message createMessage(String topic, String question, String name, String lastname, String email) {
        System.out.println(topic +" "+ question +" "+  name +" "+  lastname +" "+  email);
        for (Message message: allMessages) {
            if (message.topic.equals(topic) && message.question.equals(question)
                    && message.name.equals(name) && message.lastname.equals(lastname) && message.email.equals(email)) {
                System.out.println("kopie van het vorige bericht (object bestaat al)");
                return null;
            }
            if(topic.equals("") || question.equals("")|| name.equals("") || lastname.equals("") || email.equals("") ){
                return null;
            }
        }
        return new Message(topic,question,name,lastname,email);
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

    public String getDate() {
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




