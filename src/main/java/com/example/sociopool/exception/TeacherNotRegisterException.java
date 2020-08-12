package com.example.sociopool.exception;
import java.text.MessageFormat;

public class TeacherNotRegisterException extends Exception {
    private Object[] messageArgs;

    public Object[] getMessageArgs() {
        return messageArgs;
    }

    public void setMessageArgs(Object[] messageArgs) {
        this.messageArgs = messageArgs;
    }

    public TeacherNotRegisterException(String messageValue, Object... messageArgs) {

        super(MessageFormat.format(messageValue, messageArgs));
        this.messageArgs = messageArgs;
    }

}

