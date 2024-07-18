package com.example.basicscodelab.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.basicscodelab.data.MoodRecordBean

/**
 * moodDao
 * Description:
 * Author: Vincent
 * Date: 2023/11/30
 * Email:vincent.wei@backgardon.com
 * Version:
 */
@Dao
interface MoodDao {

  @Query("SELECT * FROM moodRecordBean")
  fun queryAll(): List<MoodRecordBean>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insetItem(item: MoodRecordBean)





}