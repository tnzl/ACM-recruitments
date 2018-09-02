package com.example.tanzeel.ACMrecruitment;

public class Student {

    private String name;
    private String phoneNo;

    //TODO: process phNo to make it long and able to be called upon.


    public Student() {
    }

    public Student(String name, String phoneNo) {
        this.name = name;
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}

