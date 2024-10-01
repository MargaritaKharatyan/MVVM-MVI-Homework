package com.example.mvvmmvihomework.spacexschedule.presentation.view_model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmmvihomework.spacexschedule.domain.model.ScheduleDomainModel
import com.example.mvvmmvihomework.spacexschedule.domain.usecase.GetCurrentTimeUseCase
import com.example.mvvmmvihomework.spacexschedule.domain.usecase.GetScheduleUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
class ScheduleViewModel(getScheduleUseCase: GetScheduleUseCase) : ViewModel() {

    private val _scheduleFlow = MutableStateFlow(listOf<ScheduleDomainModel>())
    val scheduleflow
        get() = _scheduleFlow.asStateFlow()

    private val _getTime = MutableSharedFlow<String>()
    val getTime
        get() = _getTime.asSharedFlow()

    init {
        viewModelScope.launch(Dispatchers.Default) {
            getScheduleUseCase.invoke().collect { studentsList ->
                _scheduleFlow.value = studentsList.takeLast(5)
            }
        }

        viewModelScope.launch(Dispatchers.IO) {
            while (true) {
                delay(100)
                _getTime.emit(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")))
            }
//            _getTime.emit(Date(System.currentTimeMillis()).toString())
//            getCurrentTimeUseCase.invoke().collect(){
//                while (true){
//                    delay(1000)
//                    _getTime.value = it
//                }
//            }
        }
    }


}