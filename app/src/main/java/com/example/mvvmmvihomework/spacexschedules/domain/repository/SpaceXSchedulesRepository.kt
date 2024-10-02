package com.example.mvvmmvihomework.spacexschedules.domain.repository

import com.example.mvvmmvihomework.spacexschedules.domain.model.ScheduleDomainModel
import kotlinx.coroutines.flow.Flow

interface SpaceXSchedulesRepository {
    suspend fun getSchedulesList(): Flow<List<ScheduleDomainModel>>
}