package com.example.mvvmmvihomework.spacexschedule.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmmvihomework.spacexschedule.domain.model.ScheduleDomainModel
import com.example.mvvmmvihomework.spacexschedule.domain.usecase.GetScheduleUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ScheduleViewModel(getScheduleUseCase: GetScheduleUseCase) : ViewModel() {

    private val _scheduleFlow = MutableStateFlow(listOf<ScheduleDomainModel>())
    val scheduleflow
        get() = _scheduleFlow.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.Default) {
            getScheduleUseCase.invoke().collect { studentsList ->
                _scheduleFlow.value = studentsList.takeLast(5)
            }
        }

        viewModelScope.launch(Dispatchers.IO) {
            while (true){
                delay(100)
                System.currentTimeMillis()
            }
        }
    }


}