package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    public UserRepository obj;

    public List<UserModel> Storingdata(List<UserModel> list) {
        return obj.saveAll(list);
    }

    
    public void deletebyid(int id) {
        obj.deleteById(id);
    }

    public int updateinfo(List<UserModel> sm) {
        obj.saveAll(sm);
        return 1;
    }

    // Get all students
    public List<UserModel> getAllStudents() {
        return obj.findAll();
    }

    // Get student by ID
    public Optional<UserModel> getStudentById(int id) {
        return obj.findById(id);
    }

    
}
