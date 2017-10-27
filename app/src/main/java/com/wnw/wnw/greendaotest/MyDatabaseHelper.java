package com.wnw.wnw.greendaotest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.github.yuweiguocn.library.greendao.MigrationHelper;

import org.greenrobot.greendao.database.Database;

import greendao.DaoMaster;
import greendao.UserDao;

/**
 * @author wnw
 * @date 2017/10/27 0027 15:23
 */
public class MyDatabaseHelper extends DaoMaster.DevOpenHelper {
    public MyDatabaseHelper(Context context, String name) {
        super(context, name);
    }

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        MigrationHelper.migrate(db, UserDao.class);
    }
}
