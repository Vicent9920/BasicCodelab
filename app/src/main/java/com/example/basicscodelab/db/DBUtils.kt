package com.example.basicscodelab.db

import androidx.room.Room
import com.example.basicscodelab.App
import com.example.basicscodelab.data.DaysBean
import com.example.basicscodelab.data.MoodRecordBean

object DBUtils {

  private val db = Room.databaseBuilder(
    App.getInstance(),
    MeowDatabase::class.java, "meow-day-database"
  ).build()

  fun getAllMoodRecordBean() = db.moodDao().queryAll()

  fun insertMoodRecordBean(item: MoodRecordBean) = db.moodDao().insetItem(item)

  fun deleteDaysBean(id:Int) = db.daysDao().deleteItem(id)

  fun insertDaysBean(item: DaysBean) = db.daysDao().insetItem(item)

  fun updateDaysBean(item: DaysBean) = db.daysDao().updateItem(item)

  fun queryAllDaysBean() = db.daysDao().queryAll()
}