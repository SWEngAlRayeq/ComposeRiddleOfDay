package app.riddle_of_day.domain.repo

import app.riddle_of_day.domain.model.Riddle

interface RiddleRepository {
    suspend fun getRiddle(): Riddle
}