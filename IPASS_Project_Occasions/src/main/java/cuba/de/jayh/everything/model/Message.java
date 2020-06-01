package cuba.de.jayh.everything.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Message implements Serializable {
    private String topic;
    private String question;
    private String name;
    private String email;
    private  LocalDateTime dateOfSend;

    private enum Status {
        READ,
        UNREAD
    }

    private Status status;



    //naar een direct persoon (is voor admins)
    public Message(String tp, String qn, String name, String em, Account to){
        this.topic =tp;
        this.question =qn;
        this.name = name;
        this.email = em;
        this.dateOfSend =  LocalDateTime.now();
        this.status = Status.UNREAD;
        to.addMessage(this);

    }


    // als de persoon geen account heeft (wordt verzonden naar alle super-users)
    public Message(String topic,String question, String name, String email){
        this.topic =topic;
        this.question =question;
        this.name = name;
        this.email = email;
        this.dateOfSend = LocalDateTime.now();
        this.status = Status.UNREAD;
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

}




