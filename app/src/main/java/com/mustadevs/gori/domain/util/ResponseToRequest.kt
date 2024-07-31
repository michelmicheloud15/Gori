package com.mustadevs.gori.domain.util

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.mustadevs.gori.domain.model.ErrorResponse
import retrofit2.Response
import java.io.IOException

object ResponseToRequest {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun <T> send(result: Response<T>): Resource<T>{
        return try {
            if (result.isSuccessful){ //201
                Resource.Success(result.body()!!)
            }
            else {
                val errorResponse: ErrorResponse? = ConvertErrorBody.convert(result.errorBody())
                Resource.Failure(errorResponse?.message ?: "Error desconocido")
            }

        } catch (e: HttpException) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconocido en la peticion Http")
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "Verifica tu conexion a internet")
        }catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconocido")
        }
    }
}