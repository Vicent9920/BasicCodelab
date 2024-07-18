package com.example.basicscodelab.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 心情记录
 */
@Entity
data class MoodRecordBean(@PrimaryKey(autoGenerate = true) val id:Int = 0,val icon: Int, val name: String, val date: String)

