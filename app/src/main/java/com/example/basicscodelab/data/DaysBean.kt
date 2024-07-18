package com.example.basicscodelab.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * DaysBean
 * Description:倒计时/纪念日
 * Author: Vincent
 * Date: 2023/11/28
 * Email:vincent.wei@backgardon.com
 * Version:
 */
@Entity
data class DaysBean(
  @PrimaryKey(autoGenerate = true) val id: Int = 0,
  val icon: Int,
  val name: String,
  val date: Long,
  val tack: Boolean = false,
  val remind:Boolean = false
){

   fun equalsItem(other: DaysBean): Boolean {
    return id == other.id
      && icon == other.icon
      && name == other.name
      && date == other.date
      && tack == other.tack
      && remind == other.remind
  }

}