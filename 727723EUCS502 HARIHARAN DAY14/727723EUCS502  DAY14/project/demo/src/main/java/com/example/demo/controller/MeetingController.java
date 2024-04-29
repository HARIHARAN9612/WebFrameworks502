package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.MeetingModel;
import com.example.demo.service.MeetingService;

@RestController
@RequestMapping("/meetings")
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    // Create a new meeting
    @PostMapping("/postmeet")
    public ResponseEntity<MeetingModel> createMeeting(@RequestBody MeetingModel meeting) {
        MeetingModel createdMeeting = meetingService.createMeeting(meeting);
        return ResponseEntity.ok(createdMeeting);
    }

    // Get all meetings
    @GetMapping("/getallmeet")
    public ResponseEntity<List<MeetingModel>> getAllMeetings() {
        List<MeetingModel> meetings = meetingService.getAllMeetings();
        return ResponseEntity.ok(meetings);
    }

    // Get a meeting by ID
    @GetMapping("get/{id}")
    public ResponseEntity<MeetingModel> getMeetingById(@PathVariable int id) {
        MeetingModel meeting = meetingService.getMeetingById(id);
        if (meeting != null) {
            return ResponseEntity.ok(meeting);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update a meeting
    @PutMapping("update/{id}")
    public ResponseEntity<MeetingModel> updateMeeting(
        @PathVariable int id, 
        @RequestBody MeetingModel meetingDetails) {
        MeetingModel updatedMeeting = meetingService.updateMeeting(id, meetingDetails);
        return ResponseEntity.ok(updatedMeeting);
    }

    // Delete a meeting by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeeting(@PathVariable int id) {
        boolean isDeleted = meetingService.deleteMeeting(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{app}")
    public String deleteDataByGender(@PathVariable String app) 
    {
        meetingService.deleteLoginDataByDate(app);
        return "Deleted Successfully";
    }
}
