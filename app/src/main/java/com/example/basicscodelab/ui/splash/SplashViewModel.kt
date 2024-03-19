package com.example.basicscodelab.ui.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.basicscodelab.utils.PreferenceUtil

/**
 * SplashViewModel
 * Description:
 * Author: Vincent
 * Date: 2024/3/19
 * Email:vincent.wei@backgardon.com
 * Version:
 */
class SplashViewModel:ViewModel() {
  private val guided by PreferenceUtil("splash_guide",false)

  fun checkGuided():Boolean{
    return guided
  }

  fun setGuideFlag(){
    checkGuided()
  }

}