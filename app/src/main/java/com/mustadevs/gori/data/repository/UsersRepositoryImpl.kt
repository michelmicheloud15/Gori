package com.mustadevs.gori.data.repository


import android.os.Build
import androidx.annotation.RequiresExtension
import com.mustadevs.gori.data.dataSource.remote.UsersRemoteDataSource
import com.mustadevs.gori.domain.model.User
import com.mustadevs.gori.domain.repository.UsersRepository
import com.mustadevs.gori.domain.util.Resource
import com.mustadevs.gori.domain.util.ResponseToRequest
import java.io.File

class UsersRepositoryImpl(
    private val usersRemoteDataSource: UsersRemoteDataSource,
    ): UsersRepository {


    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun update(id: String, user: User): Resource<User> = ResponseToRequest.send(
        usersRemoteDataSource.update(id, user)
    )


    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun updateWithImage(id: String, user: User, file: File) = ResponseToRequest.send(
        usersRemoteDataSource.updateWithImage(id, user, file)
    )
}