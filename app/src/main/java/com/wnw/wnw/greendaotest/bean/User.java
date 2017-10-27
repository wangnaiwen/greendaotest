package com.wnw.wnw.greendaotest.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;


/**
 * @author wnw
 * @date 2017/10/27 0027 13:19
 */
@Entity
public class User {

    @Id
    private long id;

    private String token;

    @Unique
    private String userName;

    private String password;

    private String img;

    @Generated(hash = 216448847)
    public User(long id, String token, String userName, String password,
            String img) {
        this.id = id;
        this.token = token;
        this.userName = userName;
        this.password = password;
        this.img = img;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
