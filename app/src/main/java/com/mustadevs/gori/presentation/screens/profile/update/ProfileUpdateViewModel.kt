package com.mustadevs.gori.presentation.screens.profile.update

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.mustadevs.gori.domain.model.User
import com.mustadevs.gori.domain.useCase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel(){

    var user by mutableStateOf<User?>(null)
        private set


}