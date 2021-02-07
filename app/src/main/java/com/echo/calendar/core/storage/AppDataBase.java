package com.echo.calendar.core.storage;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.echo.calendar.core.storage.bean.UserEntity;
import com.echo.calendar.core.storage.dao.UserDao;

/**
 * 数据库
 */
@Database(entities = {UserEntity.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    abstract UserDao getUserDao();
}
