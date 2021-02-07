package com.echo.calendar.core.storage.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.echo.calendar.core.storage.bean.UserEntity;

import java.util.List;

/**
 * UserDao
 */

@Dao
public interface UserDao {

    /**
     * 插入
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(UserEntity entity);

    /**
     * 查询全部
     */
    @Query("select * from user")
    List<UserEntity> queryAll();

    /**
     * 更新表
     */
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(UserEntity entity);
}
