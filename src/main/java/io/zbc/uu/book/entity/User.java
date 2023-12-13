package io.zbc.uu.book.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class User implements Serializable {

    private Integer userId;
    private String userName;
    private String password;
    private String token;
    private String avatar;
    private String email;
    private String mobile;
    private Integer userType;
    private Timestamp updateTime;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", avatar='" + avatar + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", userType=" + userType +
                ", updateTime=" + updateTime +
                '}';
    }
}
