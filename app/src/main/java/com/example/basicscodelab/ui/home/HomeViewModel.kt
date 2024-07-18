package com.example.basicscodelab.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basicscodelab.R
import com.example.basicscodelab.data.DaysBean
import com.example.basicscodelab.db.DBUtils
import com.example.basicscodelab.utils.DateUtils
import com.example.basicscodelab.utils.PreferenceUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val DEFAULT_DAY_KEY = "default_day_key"

/**
 * HomeViewModel
 * Description:
 * Author: Vincent
 * Date: 2024/7/17
 * Email:vincent.wei@backgardon.com
 * Version:
 */
class HomeViewModel:ViewModel() {

  init {
    checkDefault()
  }

  fun queryAllDaysBean() = DBUtils.queryAllDaysBean()

  private fun checkDefault() {
    viewModelScope.launch(Dispatchers.Default) {
       var isAdd by PreferenceUtil(DEFAULT_DAY_KEY, false)
      if (!isAdd) {
        DBUtils.insertDaysBean(
          DaysBean(
            icon = R.mipmap.ic_basketball,
            name = "Saturday",
            date = DateUtils.getNextSaturday(),
            tack = true
          )
        )
        DBUtils.insertDaysBean(
          DaysBean(
            icon = R.mipmap.ic_skateboarding,
            name = "Christmas",
            date = DateUtils.getChristmas()
          )
        )
        DBUtils.insertDaysBean(
          DaysBean(
            icon = R.mipmap.ic_journal,
            name = "New Year",
            date = DateUtils.getNewYear()
          )
        )
        DBUtils.insertDaysBean(
          DaysBean(
            icon = R.mipmap.ic_birthday,
            name = "Valentine's Day",
            date = DateUtils.getValentineDay()
          )
        )
        isAdd = true
      }
    }
  }
}