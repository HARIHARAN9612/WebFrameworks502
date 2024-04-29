package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.MeetingModel;
import com.example.demo.model.UserModel;
import com.example.demo.repository.MeetingRepository;
import com.example.demo.repository.UserRepository;

import java.util.List;

@Service
public class MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;

    @Autowired
    private UserRepository studentRepository;
    // Create a new meeting
    public MeetingModel createMeeting(MeetingModel meeting) {
        return meetingRepository.save(meeting);
    }

    // Get all meetings
    public List<MeetingModel> getAllMeetings() {
        return meetingRepository.findAll();
    }

    // Get a meeting by ID
    public MeetingModel getMeetingById(int id) {
        return meetingRepository.findById(id).orElse(null);
    }

    // Update a meeting by ID
    public MeetingModel updateMeeting(int id, MeetingModel meetingDetails) {
        MeetingModel existingMeeting = getMeetingById(id);
        if (existingMeeting != null) {
            existingMeeting.setApp(meetingDetails.getApp());
            existingMeeting.setDate(meetingDetails.getDate());
            existingMeeting.setTime(meetingDetails.getTime());
            return meetingRepository.save(existingMeeting);
        } else {
            return null;
        }
    }

    
    // Delete a meeting by ID
    public boolean deleteMeeting(int id) {
        MeetingModel meeting = getMeetingById(id);
        if (meeting != null) {
            meetingRepository.delete(meeting);
            return true;
        } else {
            return false;
        }
    }

    public void deleteLoginDataByDate(String app) {
        List<MeetingModel> usersToDelete = meetingRepository.findByDate(app);
        for (MeetingModel user : usersToDelete) {
            UserModel loginModel = user.getModel();
            if (loginModel != null) {
                studentRepository.deleteById(loginModel.getRegno());
            }
        }
    }
    
}
