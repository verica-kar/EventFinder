package com.example.eventfinder;

public class AccountObj {

    String name, email, stuNum;
    Boolean push, notif;

    public AccountObj(String n, String e, String s, Boolean p, Boolean no) {
        name = n;
        email = e;
        stuNum = s;
        push = p;
        notif = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNotif(Boolean notif) {
        this.notif = notif;
    }

    public void setPush(Boolean push) {
        this.push = push;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getNotif() {
        return notif;
    }

    public Boolean getPush() {
        return push;
    }

    public String getStuNum() {
        return stuNum;
    }
}
