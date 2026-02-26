package com.Metron.DetectionAPI.scanController;

import com.Metron.DetectionAPI.enities.UserTable;
import com.Metron.DetectionAPI.service.UserTableDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginRestController {
    @Autowired
    UserTableDetailService userTableDetailService;
    @PostMapping("/signUp")
    public UserTable signUp (@RequestBody UserTable userTable){
        return userTableDetailService.insert(userTable);
    }
    @GetMapping("/forget")
    public List<UserTable> getAll(){
        return userTableDetailService.getAll();
    }
    @PostMapping("/getToken")
    public String getToken(@RequestBody UserTable userTable ){
    return userTableDetailService.getToken(userTable);
    }
}
