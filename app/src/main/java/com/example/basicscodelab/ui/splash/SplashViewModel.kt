package com.example.basicscodelab.ui.splash

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
class SplashViewModel : ViewModel() {
    private val guided by PreferenceUtil("splash_guide", false)

    private val agreed by PreferenceUtil("splash_agreed", false)

    fun checkGuided(): Boolean {
        return guided
    }

    fun setGuideFlag() {
        PreferenceUtil("splash_guide", false).setValue(this, ::guided, true)
    }

    fun checkAgreed(): Boolean {
        return agreed
    }

    fun setAgreeFlag() {
        PreferenceUtil("splash_agreed", false).setValue(this, ::agreed, true)
    }

}