package com.example.mvvmmvihomework.spacexschedule.data.helper

import com.example.mvvmmvihomework.spacexschedule.data.model.ScheduleDataModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.Date

class SpaceXScheduleHelper {
    private val _scheduleList: MutableStateFlow<List<ScheduleDataModel>> =
        MutableStateFlow(emptyList())

    private val currentTime: MutableStateFlow<String> =
        MutableStateFlow(Date(System.currentTimeMillis()).toString())

    init {
        _scheduleList.value = arrayListOf<ScheduleDataModel>(
            ScheduleDataModel(
                "FalconSat1",
                "06.09.24",
                "Engine failure at 33 seconds and loss of vehicle",
                "Launch was successful"
            ),
            ScheduleDataModel(
                "FalconSat2",
                "06.09.24",
                "Engine failure at 33 seconds and loss of vehicle",
                "Launch failed"
            ),
            ScheduleDataModel(
                "FalconSat3",
                "06.09.24",
                "Engine failure at 33 seconds and loss of vehicle",
                "Launch was successful"
            ),
            ScheduleDataModel(
                "FalconSat4",
                "06.09.24",
                "Engine failure at 33 seconds and loss of vehicle",
                "Launch failed"
            ),
            ScheduleDataModel(
                "FalconSat5",
                "06.09.24",
                "Engine failure at 33 seconds and loss of vehicle",
                "Launch was successful"
            ),
            ScheduleDataModel(
                "FalconSat6",
                "06.09.24",
                "Engine failure at 33 seconds and loss of vehicle",
                "Launch failed"
            ),
            ScheduleDataModel(
                "FalconSat7",
                "06.09.24",
                "Engine failure at 33 seconds and loss of vehicle",
                "Launch was successful"
            ),
            ScheduleDataModel(
                "FalconSat8",
                "06.09.24",
                "Engine failure at 33 seconds and loss of vehicle",
                "Launch failed"
            ),
            ScheduleDataModel(
                "FalconSat9",
                "06.09.24",
                "Engine failure at 33 seconds and loss of vehicle",
                "Launch was successful"
            ),


            )
    }

    fun getScheduleList(): MutableStateFlow<List<ScheduleDataModel>> {
        return _scheduleList
    }

    fun getCurrentTime(): MutableStateFlow<String> {
        return currentTime
    }

//    fun gwtSchedule(schedule: ScheduleDataModel) {
//        _scheduleList.value = _scheduleList.value.plus(schedule)
//    }
//
//    fun clearStudentList() {
//        _studentList.value = emptyList()
//    }
}