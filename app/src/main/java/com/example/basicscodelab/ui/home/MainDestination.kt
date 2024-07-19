package com.example.basicscodelab.ui.home

sealed interface MainDestination{
  val route:String
  val title:String
  val showFAB:Boolean
  val showBackBtn:Boolean
  val showBottomNav:Boolean
}

 object Home:MainDestination{
  override val route: String = "home"
  override val title: String = "Meow Day"
  override val showFAB: Boolean = true
  override val showBackBtn: Boolean = false
  override val showBottomNav: Boolean = true
}

 object Mood:MainDestination{
  override val route: String = "mood"
  override val title: String = "Today's mood"
  override val showFAB: Boolean = true
  override val showBackBtn: Boolean = false
  override val showBottomNav: Boolean = true
}

 object Setting:MainDestination{
  override val route: String = "setting"
  override val title: String = "Meow setting"
  override val showFAB: Boolean = true
  override val showBackBtn: Boolean = false
  override val showBottomNav: Boolean = true
}

 object Anniversary:MainDestination{
  override val route: String = "anniversary"
  override val title: String = "Add Anniversary"
  override val showFAB: Boolean = true
  override val showBackBtn: Boolean = false
  override val showBottomNav: Boolean = true
}

val mainTabRowScreens = listOf(Home, Mood, Setting,Anniversary)

