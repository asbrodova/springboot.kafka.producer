package dev.asbrodova.springboot.kafka.producer.model;

public class Message {

    private String subject;

    private String msgText;

    public Message(String subject, String msgText) {
        this.subject = subject;
        this.msgText = msgText;
    }

    public String getSubject() {
        return subject;
    }

    public String getMsgText() {
        return msgText;
    }

    @Override
    public String toString() {
        return "Message{" +
                "subject='" + subject + '\'' +
                ", msgText='" + msgText + '\'' +
                '}';
    }
}
