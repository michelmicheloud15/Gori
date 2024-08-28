package com.mustadevs.gori.data.dataSource.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.mustadevs.gori.core.Config.AUTH_KEY
import com.mustadevs.gori.domain.model.AuthResponse
import com.mustadevs.gori.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

class AuthDatastore constructor(private val dataStore: DataStore<Preferences>) {

    suspend fun save(authResponse: AuthResponse){
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        dataStore.edit {pref ->
            pref[dataStoreKey] = authResponse.toJson()
        }
    }

    suspend fun update(user: User){
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        val authResponse = runBlocking {
            getData().first()
        }
        authResponse.user?.name = user.name
        authResponse.user?.lastname = user.lastname
        authResponse.user?.phone = user.phone

        if(!user.image.isNullOrBlank()) authResponse.user?.image = user.image

        dataStore.edit {pref ->
            pref[dataStoreKey] = authResponse.toJson()
        }
    }

    suspend fun delete(){
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        dataStore.edit {pref ->
            pref.remove(dataStoreKey)
        }
    }

    fun getData(): Flow<AuthResponse> {   //flow va sin suspend
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        return dataStore.data.map {pref ->
            if(pref[dataStoreKey] != null){
                AuthResponse.fromJson(pref[dataStoreKey]!!)
            }
            else{
                AuthResponse()
            }
        }
    }
}