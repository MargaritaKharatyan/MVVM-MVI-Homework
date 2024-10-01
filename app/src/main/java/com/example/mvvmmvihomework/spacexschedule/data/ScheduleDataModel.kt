package com.example.mvvmmvihomework.spacexschedule.data

data class ScheduleDataModel(
    val missionName: String,
    val date: String,
    val details: String,
    var scheduleStatus: String,
)

//sealed class ScheduleStatus (val message: String) {
//    data object Failed : ScheduleStatus("Launch was successful")
//    data object Successful : ScheduleStatus("Launch failed")
//}
