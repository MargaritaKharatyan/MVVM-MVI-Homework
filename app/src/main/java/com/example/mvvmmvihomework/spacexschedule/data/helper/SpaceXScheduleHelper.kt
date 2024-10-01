package com.example.mvvmmvihomework.spacexschedule.data.helper

import com.example.mvvmmvihomework.spacexschedule.data.ScheduleDataModel
import kotlinx.coroutines.flow.MutableStateFlow

class SpaceXScheduleHelper {
    private val _scheduleList: MutableStateFlow<List<ScheduleDataModel>> =
        MutableStateFlow(emptyList())

    init {
        _scheduleList.value =  arrayListOf<ScheduleDataModel>(
            ScheduleDataModel("aaaa","sdf","sdfdf","sdfdf"),
            ScheduleDataModel("aaaa","sdf","sdfdf","sdfdf"),
            ScheduleDataModel("aaaa","sdf","sdfdf","sdfdf"),
        )
    }

    fun getScheduleList(): MutableStateFlow<List<ScheduleDataModel>> {
        return _scheduleList
    }

//    fun gwtSchedule(schedule: ScheduleDataModel) {
//        _scheduleList.value = _scheduleList.value.plus(schedule)
//    }
//
//    fun clearStudentList() {
//        _studentList.value = emptyList()
//    }
}