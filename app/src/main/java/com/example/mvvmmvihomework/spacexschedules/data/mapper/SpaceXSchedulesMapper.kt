package com.example.mvvmmvihomework.spacexschedules.data.mapper

import com.example.mvvmmvihomework.spacexschedules.data.model.ScheduleDataModel
import com.example.mvvmmvihomework.spacexschedules.domain.model.ScheduleDomainModel

fun ScheduleDomainModel.toDataModel() = ScheduleDataModel(
    missionName = this.missionName,
    date = this.date,
    details = this.details,
    Status = this.Status
)

fun ScheduleDataModel.toDomainModel() = ScheduleDomainModel(
    missionName = missionName,
    date = date,
    details = details,
    Status = this.Status
)