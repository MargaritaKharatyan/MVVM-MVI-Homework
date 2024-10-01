package com.example.mvvmmvihomework.spacexschedule.domain.usecase

import com.example.mvvmmvihomework.spacexschedule.domain.model.ScheduleDomainModel
import com.example.mvvmmvihomework.spacexschedule.domain.repository.SpaceXScheduleRepository
import kotlinx.coroutines.flow.Flow

interface GetScheduleUseCase {
    suspend fun invoke():Flow<List<ScheduleDomainModel>>
}

class GetScheduleUseCaseImpl(private val repository: SpaceXScheduleRepository) : GetScheduleUseCase {
    override suspend fun invoke() = repository.getSchedulesList()
}