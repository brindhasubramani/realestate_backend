package com.example.demo1.model;
import com.example.demo1.model.Reg;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Login {
    @Id
    private int userId;
    private String userName;
    private String password;
    @OneToOne
    @JsonBackReference
    private Reg reg;
    public Reg getreg(){
        return reg;
    }
    public void setReg(Reg reg){
        this.reg=reg;
    }
    
    public int getuserId() {
        return userId;
    }
    public void setuserId(int userId) {
        this.userId = userId;
    }
    public String getuserName() {
        return userName;
    }
    public void setuserName(String userName) {
        this.userName = userName;
    }
    public String getpassword() {
        return password;
    }
    public void setpassword(String password) {
        this.password = password;
    }
    
    public Login(int userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        
    }
    public Login() {
    }
    
}