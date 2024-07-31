package com.mustadevs.gori.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.mustadevs.gori.core.Config.AUTH_KEY
import com.mustadevs.gori.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AuthDatastore constructor(private val dataStore: DataStore<Preferences>) {

    suspend fun save(authResponse: AuthResponse){
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
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