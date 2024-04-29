package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.MeetingModel;

public interface MeetingRepository extends JpaRepository<MeetingModel,Integer>{
    @Query("select p from MeetingModel p where app=:app")
    public List<MeetingModel> findByDate(String app);
}
