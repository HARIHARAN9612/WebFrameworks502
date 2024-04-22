package com.example.day1_q04.Cotroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class info {
@GetMapping("/open")
public Address adre()
{
    Address obj =new Address();
    obj.setName("hax");
    obj.setDoorNo(123);
    obj.setStreetName("Main St");
    obj.setPincode(600123);
    obj.setArea("da");
    obj.setDistrict("Cbe");
    obj.setState("Tamil Nadu");
    obj.setCountry("India");
    return obj;
}  
}