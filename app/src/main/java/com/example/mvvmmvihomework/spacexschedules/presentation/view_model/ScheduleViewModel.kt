package com.example.mvvmmvihomework.spacexschedules.presentation.view_model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmmvihomework.spacexschedules.domain.model.ScheduleDomainModel
import com.example.mvvmmvihomework.spacexschedules.domain.usecase.GetScheduleUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
class ScheduleViewModel(getScheduleUseCase: GetScheduleUseCase) : ViewModel() {
    private val _scheduleFlow = MutableStateFlow(listOf<ScheduleDomainModel>())
    val scheduleflow
        get() = _scheduleFlow.asStateFlow()

    private val _currentTime = MutableStateFlow(String())
    val currentTime
        get() = _currentTime.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getScheduleUseCase.invoke().collect { scheduleList ->
                _scheduleFlow.value = scheduleList.takeLast(5)
            }
        }

        viewModelScope.launch(Dispatchers.Default) {
            while (true) {
                _currentTime.value =
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")).toString()
                delay(1000)
            }
        }
    }


}