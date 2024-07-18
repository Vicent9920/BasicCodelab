package com.example.basicscodelab.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.basicscodelab.data.DaysBean
import kotlinx.coroutines.flow.Flow

/**
 * DaysDao
 * Description:
 * Author: Vincent
 * Date: 2023/11/30
 * Email:vincent.wei@backgardon.com
 * Version:
 */
@Dao
interface DaysDao {

  @Query("SELECT * FROM daysBean ORDER BY CASE WHEN tack THEN 0 ELSE 1 END, date ASC")
  fun queryAll(): Flow<List<DaysBean>>

  @Insert
  fun insetItem(item: DaysBean)

  @Query("DELETE FROM daysBean WHERE id = :id")
  fun deleteItem(id: Int)

  @Update
  fun updateItem(item: DaysBean):Int
}