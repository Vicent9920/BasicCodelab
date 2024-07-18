package com.example.basicscodelab.utils

import java.util.Calendar
import java.util.concurrent.TimeUnit

object DateUtils {
  private val monthList = mutableListOf(
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "September",
    "October",
    "November",
    "December"
  )
  private val days = mutableListOf(
    "1st",
    "2nd",
    "3rd",
    "4th",
    "5th",
    "6th",
    "7th",
    "8th",
    "9th",
    "10th",
    "11th",
    "12th",
    "13th",
    "14th",
    "15th",
    "16th",
    "17th",
    "18th",
    "19th",
    "20th",
    "21st",
    "22nd",
    "23rd",
    "24th",
    "25th",
    "26th",
    "27th",
    "28th",
    "29th",
    "30th",
    "31st"
  )

  /**
   * 解析日期
   */
  fun parseDate(time: Long): String {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = time
    return "${monthList[calendar.get(Calendar.MONTH)]} ${days[calendar.get(Calendar.DAY_OF_MONTH)]}"
  }

  /**
   * 下周六
   */
  fun getNextSaturday(): Long {
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY)
    if (calendar.before(Calendar.getInstance())) {
      calendar.add(Calendar.WEEK_OF_YEAR, 1)
    }
    return calendar.timeInMillis
  }

  /**
   * 圣诞节
   */
  fun getChristmas(): Long {
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.MONTH, Calendar.DECEMBER)
    calendar.set(Calendar.DAY_OF_MONTH, 25)
    if (calendar.before(Calendar.getInstance())) {
      calendar.add(Calendar.YEAR, 1)
    }
    return calendar.timeInMillis
  }

  /**
   * 元旦节时间
   */
  fun getNewYear(): Long {
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.MONTH, Calendar.JANUARY)
    calendar.set(Calendar.DAY_OF_MONTH, 1)
    if (calendar.before(Calendar.getInstance())) {
      calendar.add(Calendar.YEAR, 1)
    }
    return calendar.timeInMillis
  }

  /**
   * 情人节时间
   */
  fun getValentineDay(): Long {
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.MONTH, Calendar.FEBRUARY)
    calendar.set(Calendar.DAY_OF_MONTH, 14)
    if (calendar.before(Calendar.getInstance())) {
      calendar.add(Calendar.YEAR, 1)
    }
    return calendar.timeInMillis
  }

  /**
   * 获取当前时间字符串
   */
  fun getCurrentDate(calendar:Calendar = Calendar.getInstance()): String {
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH) + 1
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    return "$year ${
      if (month < 10) {
        "0$month"
      } else {
        month
      }
    } ${
      if (day < 10) {
        "0$day"
      } else {
        day
      }
    }"
  }

  /**
   * 计算距离当前时间天数差
   * 例如20230102******的时间，减去20230101******，等于1天
   */
  fun getTimeSpanByNow(millis:Long):Long{
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = millis
    calendar.set(Calendar.HOUR,0)
    calendar.set(Calendar.MINUTE,0)
    calendar.set(Calendar.SECOND,0)
    calendar.set(Calendar.MILLISECOND,0)
    val target = calendar.timeInMillis
    calendar.timeInMillis = System.currentTimeMillis()
    calendar.set(Calendar.HOUR,0)
    calendar.set(Calendar.MINUTE,0)
    calendar.set(Calendar.SECOND,0)
    calendar.set(Calendar.MILLISECOND,0)
    val current = calendar.timeInMillis

    return TimeUnit.DAYS.convert(target-current, TimeUnit.MILLISECONDS)
  }
}