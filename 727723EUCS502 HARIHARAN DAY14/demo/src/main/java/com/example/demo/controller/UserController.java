package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/welcome")
public class UserController {

    @Autowired
    public UserService sss;

    @GetMapping("/start")
    public String wlcomeString() {
        return "Welcome to All";
    }

    @PostMapping("/demopost")
    public List<UserModel> postdemo(@RequestBody List<UserModel> object) {
        return sss.Storingdata(object);
    }

    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<String> deleteAllbyid(@PathVariable("id") int id) {
        sss.deletebyid(id);
        return ResponseEntity.ok("Deleted student with regno: " + id);
    }

    @PutMapping("/update")
    public int putupdate(@RequestBody List<UserModel> stu) {
        return sss.updateinfo(stu);
    }

    // GET all students
    @GetMapping("/users")
    public List<UserModel> getAllStudents() {
        return sss.getAllStudents();
    }

    // GET student by ID
    @GetMapping("/students/{id}")
    public ResponseEntity<UserModel> getStudentById(@PathVariable("id") int id) {
        Optional<UserModel> student = sss.getStudentById(id);
        return student.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // DELETE student by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") int id) {
        sss.deletebyid(id);
        return ResponseEntity.ok("Deleted student with regno: " + id);
    }
}
