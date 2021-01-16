package edu.ib.lista11;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

public class Message {
    private String textMessage;
    private String dateNow;

    public Message(String mesage, String date) {
        textMessage = mesage;
        dateNow = date;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public String getDateNow() {
        return dateNow;
    }


}
