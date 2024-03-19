package com.example.basicscodelab

import android.app.Application
import android.content.Context

/**
 * App
 * Description:
 * Author: Vincent
 * Date: 2024/3/19
 * Email:vincent.wei@backgardon.com
 * Version:
 */
class App:Application() {

  companion object{
    private lateinit var instance:App
    fun getInstance() = instance
  }

  override fun attachBaseContext(base: Context?) {
    super.attachBaseContext(base)
    instance = this
  }
}