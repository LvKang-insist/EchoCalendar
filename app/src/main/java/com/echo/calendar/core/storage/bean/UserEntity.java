package com.echo.calendar.core.storage.bean;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * User 表
 */
@Entity(tableName = "user")
public class UserEntity {

    public UserEntity(String number, String password) {
        this.number = number;
        this.password = password;
    }

    //主键
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String number;
    public String password;
}
