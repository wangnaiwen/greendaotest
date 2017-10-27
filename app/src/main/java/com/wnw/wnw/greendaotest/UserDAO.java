package com.wnw.wnw.greendaotest;

import android.content.Context;
import com.wnw.wnw.greendaotest.bean.User;

import java.util.List;

import greendao.DaoMaster;
import greendao.DaoSession;
import greendao.UserDao;

/**
 * The type User dao.
 *
 * @author wnw
 * @date 2017 /10/27 0027 13:32
 */
public class UserDAO {

    private static UserDAO instance;

    private Context context;


    private UserDAO(Context context){
        this.context = context;
    }

    /**
     * Get instance user dao.
     *
     * @return the user dao
     */
    public static UserDAO getInstance(Context context){
        if (instance == null){
            synchronized (UserDAO.class){
                instance = new UserDAO(context);
            }
        }
        return instance;
    }

    public long insertUser(User user){
        DaoMaster daoMaster = new DaoMaster(DbManager.getInstance(context).getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        return userDao.insert(user);
    }

    public void deleteUserByKey(long key){
        DaoMaster daoMaster = new DaoMaster(DbManager.getInstance(context).getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        userDao.deleteByKey(key);
    }

    public void deleteUser(User user){
        DaoMaster daoMaster = new DaoMaster(DbManager.getInstance(context).getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        userDao.delete(user);
    }

    public void updateUser(User user){
        DaoMaster daoMaster = new DaoMaster(DbManager.getInstance(context).getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        userDao.update(user);
    }

    public List<User> getUser(String userName, String password){
        DaoMaster daoMaster = new DaoMaster(DbManager.getInstance(context).getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        return userDao.queryBuilder()
                .where(UserDao.Properties.UserName.eq(userName), UserDao.Properties.Password.eq(password))
                .list();

    }

    public List<User> getUser(String userName){
        DaoMaster daoMaster = new DaoMaster(DbManager.getInstance(context).getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        return userDao.queryBuilder()
                .where(UserDao.Properties.UserName.eq(userName))
                .list();
    }

}
