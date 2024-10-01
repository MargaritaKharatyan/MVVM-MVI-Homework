package com.example.mvvmmvihomework.spacexschedule.domain.repository

import com.example.mvvmmvihomework.spacexschedule.domain.model.ScheduleDomainModel
import kotlinx.coroutines.flow.Flow

interface SpaceXScheduleRepository {
    suspend fun getSchedulesList(): Flow<List<ScheduleDomainModel>>
    suspend fun getCurrentTime(): Flow<String>
//    suspend fun getSchedule(schedule: ScheduleDomainModel)
}