package com.mustadevs.gori.data.repository

import android.os.Build
import androidx.annotation.RequiresExtension
import com.mustadevs.gori.data.dataSource.local.CategoriesLocalDataSource
import com.mustadevs.gori.data.dataSource.remote.CategoriesRemoteDataSource
import com.mustadevs.gori.data.mapper.toCategory
import com.mustadevs.gori.data.mapper.toCategoryEntity
import com.mustadevs.gori.domain.model.Category
import com.mustadevs.gori.domain.repository.CategoriesRepository
import com.mustadevs.gori.domain.util.Resource
import com.mustadevs.gori.domain.util.ResponseToRequest
import com.mustadevs.gori.domain.util.isListEqual
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.File

class CategoriesRepositoryImpl(
    private val remoteDataSource: CategoriesRemoteDataSource,
    private val localDataSource: CategoriesLocalDataSource
    ): CategoriesRepository {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun create(category: Category, file: File): Resource<Category> =

        ResponseToRequest.send(remoteDataSource.create(category, file)).run{
            return when(this){
                is Resource.Success -> {
                    localDataSource.create(this.data.toCategoryEntity())
                    Resource.Success(this.data)
                }
                else->{
                    Resource.Failure("Error Desconocido")
                }
            }
        }


    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun getCategories(): Flow<Resource<List<Category>>> = flow{

        localDataSource.getCategories().collect(){
            it.run{
                val categoriesLocalMap = this.map { categoryEntity -> categoryEntity.toCategory() }

                try {
                    ResponseToRequest.send(remoteDataSource.getCategories()).run {
                        when(this){
                            is Resource.Success -> {
                                val categoriesRemote = this.data


                                if (isListEqual(categoriesRemote, categoriesLocalMap)){
                                    localDataSource.insertAll(categoriesRemote.map { category -> category.toCategoryEntity() })
                                }

                                emit(Resource.Success(categoriesRemote))
                            }
                            is Resource.Failure ->{
                                emit(Resource.Success(categoriesLocalMap))
                            }

                            else -> {
                                emit(Resource.Success(categoriesLocalMap))}
                        }
                    }
                }
                catch (e: Exception){
                    emit(Resource.Success(categoriesLocalMap))
                }
                }
            }
                //if(this.isNotEmpty()){
                //    Log.d("CategoriesRepositoryImpl", "Data Local: ${this}")
                //    emit(Resource.Success(this.map {categoryEntity -> categoryEntity.toCategory() }))
                //}
                //else{

                //}
            //}
        //}

        //trySend(ResponseToRequest.send(remoteDataSource.getCategories())) //como hay flow, asi se envia datos a traves de flow
        //awaitClose{
        //    cancel()
        //}


    }.flowOn(Dispatchers.IO)

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun update(id: String, category: Category): Resource<Category> {

        ResponseToRequest.send(remoteDataSource.update(id, category)).run{
            return when(this){
                is Resource.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "", //esta data me la devuelve el backend
                        name = this.data.name,
                        description = this.data.description,
                        image = this.data.image ?: ""
                    )
                    Resource.Success(this.data)
                }
                else->{
                    Resource.Failure("Error Desconocido")
                }
            }
        }

    }


    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun updateWithImage(
        id: String,
        category: Category,
        file: File
    ): Resource<Category> {
        ResponseToRequest.send(remoteDataSource.updateWithImage(id, category, file)).run{
            return when(this){
                is Resource.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "", //esta data me la devuelve el backend
                        name = this.data.name,
                        description = this.data.description,
                        image = this.data.image ?: ""
                    )
                    Resource.Success(this.data)
                }
                else->{
                    Resource.Failure("Error Desconocido")
                }
            }
        }

    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun delete(id: String): Resource<Unit> {
        ResponseToRequest.send(remoteDataSource.delete(id)).run{
            return when(this){
                is Resource.Success -> {
                    localDataSource.delete(id)
                    Resource.Success(Unit)
                }
                else->{
                    Resource.Failure("Error Desconocido")
                }
            }
        }
    }

}