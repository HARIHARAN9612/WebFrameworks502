package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class UserModel {

    @Id
    private int regno;  
    private String Name;
    private String Password;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "model")
    @JsonManagedReference
    private MeetingModel meetingModel;

    public UserModel() {
        
    }       
    public int getRegno() {
        return regno;
    }

    public UserModel(int regno, String name, String password, MeetingModel meetingModel) {
        this.regno = regno;
        Name = name;
        Password = password;
        this.meetingModel = meetingModel;
    }
    public void setRegno(int regno) {
        this.regno = regno;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public MeetingModel getMeetingModel() {
        return meetingModel;
    }

    public void setMeetingModel(MeetingModel meetingModel) {
        this.meetingModel = meetingModel;
    }
}
