package com.example.mvvmmvihomework.spacexschedules.data.helper

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.mvvmmvihomework.spacexschedules.data.model.ScheduleDataModel
import kotlinx.coroutines.flow.MutableStateFlow

@RequiresApi(Build.VERSION_CODES.O)
class SpaceXSchedulesHelper {
    private val _scheduleList: MutableStateFlow<List<ScheduleDataModel>> =
        MutableStateFlow(emptyList())

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
}