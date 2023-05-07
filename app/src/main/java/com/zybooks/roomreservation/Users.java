package com.zybooks.roomreservation;

public class Users {
    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;
    private final String type; //Differentiate between admin and regular users

    public Users(String first, String last, String user, String pass, String type){
        this.firstName = first;
        this.lastName = last;
        this.userName = user;
        this.passWord = pass;
        this.type = type;
    }

    //setters
    public void setFirst(String first) {
        this.firstName = first;
    }
    public void setLast(String last) {
        this.lastName = last;
    }
    public void setUser(String user) {
        this.userName = user;
    }
    public void setPass(String pass) {
        this.passWord = pass;
    }

    //getters
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getUser() {
        return userName;
    }
    public String getPass() {
        return passWord;
    }
    public String getUserType() {
        return type;
    }

}
