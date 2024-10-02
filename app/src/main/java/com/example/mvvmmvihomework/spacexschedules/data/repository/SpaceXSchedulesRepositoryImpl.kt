package com.example.mvvmmvihomework.spacexschedules.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.mvvmmvihomework.spacexschedules.data.helper.SpaceXSchedulesHelper
import com.example.mvvmmvihomework.spacexschedules.data.mapper.toDomainModel
import com.example.mvvmmvihomework.spacexschedules.domain.model.ScheduleDomainModel
import com.example.mvvmmvihomework.spacexschedules.domain.repository.SpaceXSchedulesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class SpaceXSchedulesRepositoryImpl(private val scheduleHelper: SpaceXSchedulesHelper) :
    SpaceXSchedulesRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getSchedulesList(): Flow<List<ScheduleDomainModel>> {
        return withContext(context = Dispatchers.IO) {
            scheduleHelper.getScheduleList().map { flow -> flow.map { it.toDomainModel() } }
        }
    }
}