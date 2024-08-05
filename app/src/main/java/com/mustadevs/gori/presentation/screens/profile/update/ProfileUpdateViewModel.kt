package com.mustadevs.gori.presentation.screens.profile.update

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustadevs.gori.domain.model.User
import com.mustadevs.gori.domain.useCase.auth.AuthUseCase
import com.mustadevs.gori.domain.useCase.users.UsersUseCase
import com.mustadevs.gori.domain.util.Resource
import com.mustadevs.gori.presentation.screens.profile.update.mapper.toUser
import com.mustadevs.gori.presentation.util.ComposeFileProvider
import com.mustadevs.gori.presentation.util.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val usersUseCase: UsersUseCase,
    private val savedStateHandle: SavedStateHandle,
    @ApplicationContext private val context: Context
): ViewModel(){

    var state by mutableStateOf(ProfileUpdateState())
        private set

    //ARGUMENTS
    val data = savedStateHandle.get<String>("user")
    var user = User.fromJson(data!!) //val no permite asignar nuevos valores, var en cambio si.

    //IMAGES
    var file: File? = null
    val resultingActivityHandler= ResultingActivityHandler()

    var updateResponse by mutableStateOf<Resource<User>?>(null)
        private set
    init {
        state = state.copy(
            name = user.name,
            lastname = user.lastname,
            phone = user.phone,
            image = user.image ?: "",
        )
        Log.d("ProfileUpdateViewModel", "User JSON: $data")
    }

    fun onUpdate(){
        if(file != null){// selecciono una imagen
            updateWithImage()
    }
        else {
            update()
        }
    }
    fun updateUserSession(userResponse: User) = viewModelScope.launch {
        authUseCase.updateSession(userResponse)
    }

    fun updateWithImage() = viewModelScope.launch {
        updateResponse = Resource.Loading
        val result = usersUseCase.updateUserWithImage(user.id ?: "", state.toUser(), file!!)
        updateResponse = result

    }
    fun update() = viewModelScope.launch {
        updateResponse = Resource.Loading
        val result = usersUseCase.updateUser(user.id ?: "", state.toUser())
        updateResponse = result
    }
    fun pickImage() = viewModelScope.launch{
        val result = resultingActivityHandler.getContent("image/*") //selecciona imagen de galeria
        if(result!=null){
            file = ComposeFileProvider.createFileFromUri(context, result)
            state = state.copy(image= result.toString())
        }
    }

    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result!=null){
            state = state.copy(image = ComposeFileProvider.getPathFromBitmap(context, result))
            file = File(state.image)

        }
    }
    fun onNameInput(input: String){
        state=state.copy(name=input)
    }

    fun onLastnameInput(input: String){
        state=state.copy(lastname=input)
    }

    fun onImageInput(input: String){
        state=state.copy(image=input)
    }

    fun onPhoneInput(input: String){
        state=state.copy(phone=input)
    }


}