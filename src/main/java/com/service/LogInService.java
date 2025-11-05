package com.service;


import com.bean.Login;
import com.repository.LogInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogInService {

    @Autowired
    LogInRepository ld ;


    public String signUp(Login login){
        StringBuffer sb = new StringBuffer(login.getPassword());
        String reversePassword= sb.reverse().toString();
        login.setPassword(reversePassword);

        if(ld.signUp(login)>0){
            return "Account created successfully";
        }else {
            return "Account creation failed";
        }
    }

    public String signIn(Login login){
        StringBuffer sb = new StringBuffer(login.getPassword());
        String reversePassword = sb.reverse().toString();
        login.setPassword(reversePassword);
        if(ld.userExists(login)){
            return "Successfully logged in";
        }else {
            return "Failure try once again!";
        }
    }
}
