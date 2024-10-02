package com.example.mvvmmvihomework.spacexschedule.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.mvvmmvihomework.spacexschedule.data.helper.SpaceXScheduleHelper
import com.example.mvvmmvihomework.spacexschedule.data.mapper.toDomainModel
import com.example.mvvmmvihomework.spacexschedule.domain.model.ScheduleDomainModel
import com.example.mvvmmvihomework.spacexschedule.domain.repository.SpaceXScheduleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class SpaceXScheduleRepositoryImpl(private val scheduleHelper: SpaceXScheduleHelper) :
    SpaceXScheduleRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getSchedulesList(): Flow<List<ScheduleDomainModel>> {
        return withContext(context = Dispatchers.IO) {
            scheduleHelper.getScheduleList().map { flow -> flow.map { it.toDomainModel() } }
        }
    }
}