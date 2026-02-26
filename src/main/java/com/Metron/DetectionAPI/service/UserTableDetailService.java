package com.Metron.DetectionAPI.service;

import com.Metron.DetectionAPI.JWTUtility;
import com.Metron.DetectionAPI.enities.UserTable;
import com.Metron.DetectionAPI.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTableDetailService implements UserDetailsService {
    private static Logger log = LoggerFactory.getLogger(UserTableDetailService.class);
    @Autowired
    private UserRepository userRepository;
    public UserTable insert (UserTable userTable){
        userTable.setPassword( new BCryptPasswordEncoder().encode(userTable.password));
        userRepository.save(userTable);
        return userTable;
    }
    @Override
    public UserTable loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findByUserName(userName).orElseThrow(()-> new RuntimeException());
    }
    public List<UserTable> getAll (){
        return userRepository.findAll();
    }
    public String getToken (UserTable userTable ){
         UserTable userTable1 = userRepository.findByUserName(userTable.getUsername()).orElseThrow(()-> new RuntimeException());
        if(new BCryptPasswordEncoder().matches(userTable.password, userTable1.password)){
             return JWTUtility.generateToken(userTable.userName);
         }
         return null;
    }
}