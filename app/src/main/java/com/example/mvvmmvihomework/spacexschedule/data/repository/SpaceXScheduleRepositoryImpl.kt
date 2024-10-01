package com.example.mvvmmvihomework.spacexschedule.data.repository

import com.example.mvvmmvihomework.spacexschedule.data.helper.SpaceXScheduleHelper
import com.example.mvvmmvihomework.spacexschedule.data.mapper.toDomainModel
import com.example.mvvmmvihomework.spacexschedule.domain.model.ScheduleDomainModel
import com.example.mvvmmvihomework.spacexschedule.domain.repository.SpaceXScheduleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class SpaceXScheduleRepositoryImpl(private val scheduleHelper: SpaceXScheduleHelper) :
    SpaceXScheduleRepository {
    override suspend fun getSchedulesList(): Flow<List<ScheduleDomainModel>> {
        return withContext(context = Dispatchers.IO) {
            scheduleHelper.getScheduleList().map { flow -> flow.map { it.toDomainModel() } }
        }
    }

    override suspend fun getCurrentTime(): Flow<String> {
        return withContext(context = Dispatchers.IO) {
            flow { emit(scheduleHelper.getCurrentTime().toString()) }
        }
    }
}
//    override suspend fun getSchedule(student: ScheduleDomainModel) = withContext(Dispatchers.IO) {
//        scheduleHelper.getSchedule(student.toDataModel())
//    }
//
//    override suspend fun clearStudentsList() = withContext(context = Dispatchers.IO) {
//        scheduleHelper.clearStudentList()
//    }
//}