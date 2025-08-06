package app.riddle_of_day.data.api

import app.riddle_of_day.data.model.RiddleDto
import retrofit2.http.GET

interface RiddleApi {

    @GET("random")
    suspend fun getRandomRiddle(): RiddleDto

}