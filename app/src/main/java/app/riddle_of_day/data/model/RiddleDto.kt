package app.riddle_of_day.data.model

import app.riddle_of_day.domain.model.Riddle

data class RiddleDto(
    val riddle: String,
    val answer: String
){
    fun toRiddle() = Riddle(riddle,answer)
}