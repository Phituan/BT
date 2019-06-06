package com.simpleweb.entity;

public class Student {

    private String username;
    private String password;
    private String email;
    private String fullName;
    private String address;
    private String phone;
    private int status;
    private String Salt;

    public Student() {
        username = "";
        password = "";
        email = "";
        fullName = "";
        address = "";
        phone = "";
    }

    public enum Status {
        ACTIVE(1), DEATIVE(0), DELETED(-1);
        int value;

        Status(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Status findByValue(int value) {
            for (Status status :
                    Status.values()) {
                if (status.getValue() == value) {
                    return status;
                }
            }
            return null;
        }
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if (status == null){
            status = Status.DEATIVE;
        }
        this.status = status.getValue();
    }

    public String getSalt() {
        return Salt;
    }

    public void setSalt(String salt) {
        Salt = salt;
    }
}
