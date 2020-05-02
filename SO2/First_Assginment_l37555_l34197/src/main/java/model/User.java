package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{
    
    private long id;
    private String name;
    private String email;
    
    public User(){
        
    }
    
    public User(final String name, final String email){
        this.name=name;
        this.email=email;
    }
   
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    
    public List getUserInfo(User user){
        List<String> userInfoList = new ArrayList<>();
        userInfoList.add(user.getName());
        userInfoList.add(user.getEmail());
        return userInfoList;
    }
}
