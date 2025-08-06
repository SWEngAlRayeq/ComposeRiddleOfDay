package app.riddle_of_day.data.repo_impl

import app.riddle_of_day.data.api.RiddleApi
import app.riddle_of_day.domain.model.Riddle
import app.riddle_of_day.domain.repo.RiddleRepository
import javax.inject.Inject

class RiddleRepositoryImpl @Inject constructor(
    private val riddleApi: RiddleApi
) : RiddleRepository {
    override suspend fun getRiddle(): Riddle {
        return riddleApi.getRandomRiddle().toRiddle()
    }
}