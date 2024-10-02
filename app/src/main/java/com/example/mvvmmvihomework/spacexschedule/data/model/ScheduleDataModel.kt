package com.example.mvvmmvihomework.spacexschedule.data.model

data class ScheduleDataModel(
    val missionName: String,
    val date: String,
    val details: String,
    var scheduleStatus: String,
)