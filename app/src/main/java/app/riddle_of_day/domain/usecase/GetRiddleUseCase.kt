package app.riddle_of_day.domain.usecase

import app.riddle_of_day.domain.model.Riddle
import app.riddle_of_day.domain.repo.RiddleRepository
import javax.inject.Inject

class GetRiddleUseCase @Inject constructor(
    private val repository: RiddleRepository
) {
    suspend operator fun invoke(): Riddle = repository.getRiddle()
}