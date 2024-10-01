package com.example.mvvmmvihomework.spacexschedule.domain.model

data class ScheduleDomainModel(
    val missionName: String,
    val date: String,
    val details: String,
    var scheduleStatus: String,
)