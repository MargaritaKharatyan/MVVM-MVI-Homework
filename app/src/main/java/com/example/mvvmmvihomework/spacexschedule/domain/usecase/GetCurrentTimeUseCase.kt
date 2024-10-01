package com.example.mvvmmvihomework.spacexschedule.domain.usecase

import com.example.mvvmmvihomework.spacexschedule.domain.model.ScheduleDomainModel
import com.example.mvvmmvihomework.spacexschedule.domain.repository.SpaceXScheduleRepository
import kotlinx.coroutines.flow.Flow


interface GetCurrentTimeUseCase {
    suspend fun invoke(): Flow<String>
}

class GetCurrentTimeUseCaseImpl(private val repository: SpaceXScheduleRepository) :
    GetCurrentTimeUseCase {
    override suspend fun invoke() = repository.getCurrentTime()
}