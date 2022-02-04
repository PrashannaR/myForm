package com.example.myform.model;

public class Model {
    private int id;
    private String name;
    private String phone;
    private String email;
    private String branch;
    private String reg;

    //constructors
    public Model(int id, String name, String phone, String email, String branch, String reg) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.branch = branch;
        this.reg = reg;
    }

    //empty constructor
    public Model(){ }

    //toString()
    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", branch='" + branch + '\'' +
                ", reg='" + reg + '\'' +
                '}';
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }
}
