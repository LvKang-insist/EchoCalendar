package com.echo.calendar.core.storage;

import android.app.Application;

import androidx.room.Room;

import com.echo.calendar.core.storage.dao.UserDao;

/**
 * 数据库管理类
 */
public class DBManager {

    private final AppDataBase dataBase;

    private DBManager(Application application) {
        //创建数据库
        dataBase = Room.databaseBuilder(application, AppDataBase.class, "echoCalendar")
                .allowMainThreadQueries()
                .build();
    }

    private static DBManager manager;

    public static DBManager getManager(Application application) {
        if (manager == null) {
            manager = new DBManager(application);
        }
        return manager;
    }

    public UserDao getUserDao() {
        return dataBase.getUserDao();
    }

}
