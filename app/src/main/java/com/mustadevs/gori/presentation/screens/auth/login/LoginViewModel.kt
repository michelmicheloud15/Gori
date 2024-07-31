package com.mustadevs.gori.presentation.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustadevs.gori.domain.model.AuthResponse
import com.mustadevs.gori.domain.useCase.auth.AuthUseCase
import com.mustadevs.gori.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    var errorMessage by mutableStateOf("")

    //LOGIN RESPONSE
    var loginResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set

    init{
        getSessionData()
    }

    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect() { data ->
            if(!data.token.isNullOrBlank()) {
                loginResponse = Resource.Success(data)
            }
        }
    }

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }

    fun login() = viewModelScope.launch {

        if(isValidForm()) {
            loginResponse = Resource.Loading //ESPERANDO RESPUESTA
            val result = authUseCase.login(state.email, state.password) // RETORNA RESPUESTA
            loginResponse = result  //EXITOSA O ERROR
            Log.d("LoginViewModel", "Response: $loginResponse")
        }
    }
    fun onEmailInput(email: String){
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String){
        state = state.copy(password = password)
    }

    fun isValidForm(): Boolean { //funcion asincrona para poder usar el delay
        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "El email no es válido"
            return false
        }
        else if (state.password.length < 6){
            errorMessage = "La contraseña debe tener al menos 6 caracteres"
            return false
        }

        return true
    }
}
