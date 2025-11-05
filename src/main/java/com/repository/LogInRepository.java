package com.repository;


import com.bean.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class LogInRepository {

    @Autowired
    JdbcTemplate jdbc;

    public int signUp(Login login){
        try{
            return jdbc.update("insert into login values(?,?)",login.getEmail(),login.getPassword());
        }catch (Exception e){
            System.err.println(e);
            return 0;
        }
    }

    public boolean userExists(Login login) {
        String sql = "SELECT 1 FROM login WHERE EmailId = ? AND Password = ?";
        return jdbc.query(sql, (ResultSetExtractor<Boolean>) rs -> rs.next(), login.getEmail(), login.getPassword());
    }





}
