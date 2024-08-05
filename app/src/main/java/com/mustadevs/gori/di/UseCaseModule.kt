package com.mustadevs.gori.di

import com.mustadevs.gori.domain.repository.AuthRepository
import com.mustadevs.gori.domain.repository.UsersRepository
import com.mustadevs.gori.domain.useCase.auth.AuthUseCase
import com.mustadevs.gori.domain.useCase.auth.GetSessionDataUseCase
import com.mustadevs.gori.domain.useCase.auth.LoginUseCase
import com.mustadevs.gori.domain.useCase.auth.LogoutUseCase
import com.mustadevs.gori.domain.useCase.auth.RegisterUseCase
import com.mustadevs.gori.domain.useCase.auth.SaveSessionUseCase
import com.mustadevs.gori.domain.useCase.auth.UpdateSessionUseCase
import com.mustadevs.gori.domain.useCase.users.UpdateUserUseCase
import com.mustadevs.gori.domain.useCase.users.UpdateUserWithImageUseCase
import com.mustadevs.gori.domain.useCase.users.UsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository),
        register = RegisterUseCase(authRepository),
        saveSession = SaveSessionUseCase(authRepository),
        getSessionData = GetSessionDataUseCase(authRepository),
        logout = LogoutUseCase(authRepository),
        updateSession = UpdateSessionUseCase(authRepository)
    )

    @Provides
    fun provideUsersUseCase(usersRepository: UsersRepository) = UsersUseCase(
        updateUser = UpdateUserUseCase(usersRepository),
        updateUserWithImage = UpdateUserWithImageUseCase(usersRepository)
    )
}