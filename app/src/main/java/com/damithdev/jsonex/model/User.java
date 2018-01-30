package com.damithdev.jsonex.model;

/**
 * Created by damith on 1/29/18.
 */

public class User {
    private String response;
    private String id;
    private String name;
    private String email;
    private String pass;

    public User(String response) {
        this.response = response;
    }

    public User(String response, String id, String name, String email, String pass) {
        this.response = response;
        this.id = id;
        this.name = name;
        this.email = email;
        this.pass = pass;
    }

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User(String id, String name, String email, String pass) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pass = pass;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
