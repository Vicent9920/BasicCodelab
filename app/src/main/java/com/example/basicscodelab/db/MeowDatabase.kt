package com.example.basicscodelab.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.basicscodelab.data.DaysBean
import com.example.basicscodelab.data.MoodRecordBean
import com.example.basicscodelab.db.dao.DaysDao
import com.example.basicscodelab.db.dao.MoodDao

/**
 * MeowDabaBase
 * Description:
 * Author: Vincent
 * Date: 2023/11/30
 * Email:vincent.wei@backgardon.com
 * Version:
 */

@Database(
  entities = [DaysBean::class, MoodRecordBean::class],
  version = 1,
  exportSchema = false
)
 abstract class MeowDatabase: RoomDatabase() {

   abstract fun daysDao(): DaysDao
   abstract fun moodDao(): MoodDao

}