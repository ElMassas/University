package client;

import java.io.Serializable;
import java.util.ArrayList;

public class ClientLastInfo implements Serializable{
    private String userEmail;
    private String option;
    private String[] input;

    public ClientLastInfo() {
    }

    
    
    public ClientLastInfo(String userEmail, String option) {
        this.userEmail = userEmail;
        this.option = option;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String[] getInput() {
        return input;
    }

    public void setInput(String[] input) {
        this.input = input;
    }
    
    
    
}
