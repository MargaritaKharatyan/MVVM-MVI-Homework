package com.example.mvvmmvihomework.spacexschedules.domain.usecase

import com.example.mvvmmvihomework.spacexschedules.domain.model.ScheduleDomainModel
import com.example.mvvmmvihomework.spacexschedules.domain.repository.SpaceXSchedulesRepository
import kotlinx.coroutines.flow.Flow

interface GetScheduleUseCase {
    suspend fun invoke(): Flow<List<ScheduleDomainModel>>
}

class GetScheduleUseCaseImpl(private val repository: SpaceXSchedulesRepository) :
    GetScheduleUseCase {
    override suspend fun invoke() = repository.getSchedulesList()
}