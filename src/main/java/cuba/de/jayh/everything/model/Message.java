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
    private String lastname;
    private  LocalDateTime dateOfSend;

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



}




