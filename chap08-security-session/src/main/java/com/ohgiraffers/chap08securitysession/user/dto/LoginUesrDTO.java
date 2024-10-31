package com.ohgiraffers.chap08securitysession.user.dto;

import com.ohgiraffers.chap08securitysession.common.UserRole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginUesrDTO {
    private int userCode;
    private String uesrId;
    private String uesrName;
    private String password;
    private UserRole uesrRole;

    public LoginUesrDTO() {
    }

    public LoginUesrDTO(int userCode, String uesrId, String uesrName, String password, UserRole uesrRole) {
        this.userCode = userCode;
        this.uesrId = uesrId;
        this.uesrName = uesrName;
        this.password = password;
        this.uesrRole = uesrRole;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public String getUesrId() {
        return uesrId;
    }

    public void setUesrId(String uesrId) {
        this.uesrId = uesrId;
    }

    public String getUesrName() {
        return uesrName;
    }

    public void setUesrName(String uesrName) {
        this.uesrName = uesrName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUesrRole() {
        return uesrRole;
    }

    public List<String> getRole(){
        if (this.uesrRole.getRole().length() > 0) {
            return Arrays.asList(this.uesrRole.getRole().split(","));
        }
        return new ArrayList<>();
    }

    public void setUesrRole(UserRole uesrRole) {
        this.uesrRole = uesrRole;
    }

    @Override
    public String toString() {
        return "LoginUesrDTO{" +
                "userCode=" + userCode +
                ", uesrId='" + uesrId + '\'' +
                ", uesrName='" + uesrName + '\'' +
                ", password='" + password + '\'' +
                ", uesrRole=" + uesrRole +
                '}';
    }


}
