package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class MeetingModel 
{
    @Id
    private int id;
    private String app;
        private String date;
    private String time;
    
    @OneToOne
    @JoinColumn(name="regno",referencedColumnName = "regno")
    @JsonBackReference
    private UserModel model;

    public UserModel getModel() {
        return model;
    }
    public void setModel(UserModel model) {
        this.model = model;
    }
    public int getId() {    
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getApp() {
        return app;
    }
    public void setApp(String app) {
        this.app = app;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    

}

   
