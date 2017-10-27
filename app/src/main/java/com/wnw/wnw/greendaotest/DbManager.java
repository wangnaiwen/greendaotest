package com.wnw.wnw.greendaotest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import greendao.DaoMaster;


/**
 * The type Db manager.
 *
 * @author wnw
 * @date 2017 /10/27 0027 13:57
 */
public class DbManager {

    private static final String DB_NAME = "db_user";
    private Context context;
    private static DbManager instance;
    private MyDatabaseHelper myDatabaseHelper;


    /**
     *
     *private 构造函数，为了确保是单例，不允许创建对象
     *
     * */
    private DbManager(Context context){
        this.context = context;
    }

    /**
     *
     * 获取单例
     *
     * */
    public static DbManager getInstance(Context context){
        if (instance == null){
            synchronized (DbManager.class){
                instance = new DbManager(context);
            }
        }
        return instance;
    }

    /**
     *
     * 获得可写数据库
     *
     * */
    public SQLiteDatabase getWritableDatabase(){
        if (myDatabaseHelper == null){
            myDatabaseHelper = new MyDatabaseHelper(context, DB_NAME);
        }
        return myDatabaseHelper.getWritableDatabase();
    }

    /**
     *
     * 获得可读数据库
     *
     * */
    public SQLiteDatabase getReadableDatabase(){
        if (myDatabaseHelper == null){
            myDatabaseHelper = new MyDatabaseHelper(context, DB_NAME);
        }
        return myDatabaseHelper.getReadableDatabase();
    }
}
