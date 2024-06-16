package com.example.examschedule.bottom_navigation

import com.example.examschedule.R

sealed class BottomItem(val title: String, val iconId: Int, val route: String) {
    object Screen1 : BottomItem("Auth", R.drawable.enter, "screen_1")
    object Screen2 : BottomItem("Schedule", R.drawable.actual, "screen_2")
    object Screen3 : BottomItem("Add Exam", R.drawable.add, "screen_3")
    object Screen4 : BottomItem("Profile", R.drawable.profile, "screen_4")
}
