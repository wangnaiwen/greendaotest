package com.wnw.wnw.greendaotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.wnw.wnw.greendaotest.bean.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *
 * @author wnw
 *
 * @date 2017/10/27 0027 13:18
 *
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.dis)
    TextView dis;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.insert)
    void insert(){
        User user = new User();
        user.setPassword("123");
        user.setUserName("321");
        user.setToken("789");
        UserDAO.getInstance(this).insertUser(user);
    }

    @OnClick(R.id.update)
    void update(){
        if (user != null){
            user.setToken("987");
            UserDAO.getInstance(this).updateUser(user);
        }
    }

    @OnClick(R.id.delete)
    void delete(){
        if (user != null){
            UserDAO.getInstance(this).deleteUser(user);
        }
    }

    @OnClick(R.id.find)
    void find(){
        List<User> users = UserDAO.getInstance(this).getUser("321");
        if (users == null || users.size() <= 0){
            dis.setText("null");
            return;
        }
        user = users.get(0);
        dis.setText(user.getPassword()+" " + user.getUserName() + " " + user.getToken() + " " + user.getId() +"-" + user.getImg() + "-") ;
    }
}
