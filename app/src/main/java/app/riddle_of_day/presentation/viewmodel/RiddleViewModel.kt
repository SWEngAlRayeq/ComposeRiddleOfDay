package app.riddle_of_day.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.riddle_of_day.domain.model.Riddle
import app.riddle_of_day.domain.usecase.GetRiddleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RiddleViewModel @Inject constructor(
    private val getRiddleUseCase: GetRiddleUseCase
) : ViewModel() {

    var state by mutableStateOf<Riddle?>(null)
        private set

    var isLoading by mutableStateOf(false)
        private set

    var error by mutableStateOf<String?>(null)
        private set

    init {
        fetchRiddle()
    }

    fun fetchRiddle() {
        viewModelScope.launch {
            isLoading = true
            error = null
            try {
                state = getRiddleUseCase()
            } catch (e: Exception) {
                error = e.message
            } finally {
                isLoading = false
            }
        }
    }
}