package com.example.mvvmmvihomework.spacexschedule.data.mapper

import com.example.mvvmmvihomework.spacexschedule.data.ScheduleDataModel
import com.example.mvvmmvihomework.spacexschedule.domain.model.ScheduleDomainModel


fun ScheduleDomainModel.toDataModel() = ScheduleDataModel(
    missionName = this.missionName,
    date = this.date,
    details = this.details,
    scheduleStatus = this.scheduleStatus
)

fun ScheduleDataModel.toDomainModel() = ScheduleDomainModel(
    missionName = missionName,
    date = date,
    details = details,
    scheduleStatus = this.scheduleStatus
)