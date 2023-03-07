package com.javase.common;

import java.io.Serializable;

/**
 * {@code @Description:}
 */
public class User implements Serializable {
    public static final long serialVersionUID = 1L;
    
    private String userId;
    private String password;
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}