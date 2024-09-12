package com.belia.speedotransfer.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.belia.speedotransfer.api.APIService
import com.belia.speedotransfer.model.Favourite
import com.belia.speedotransfer.util.TokenManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException

class FavouritesViewModel(application: Application) : AndroidViewModel(application) {
    private val _favourites = MutableStateFlow<List<Favourite>>(emptyList())
    val favourite: StateFlow<List<Favourite>> = _favourites


    val tokenManager = TokenManager(application)
    val token = tokenManager.getToken()

    fun getFavourites(userId: Int) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                _favourites.update {
                    APIService.callable.getFavourites(token!!, userId)
                }
                Log.d("trace", "getFavourites: $favourite")
            }
        } catch (http: HttpException) {
            if (http.code() == 401) {
                Log.d("trace", "Error: ${http.message}")
            } else {
                Log.d("trace", "Error: ${http.message()}")
            }
        } catch (e: Exception) {
            Log.d("trace", "Error: ${e.message}")
        }
    }

    fun createFavourite(myaccount: String, name: String, account: String) {
        try {


            viewModelScope.launch(Dispatchers.IO) {
                val fav = Favourite(name, account)
                val response = APIService.callable.createFavourite(token!!, myaccount, fav)
                Log.d("trace", "createFavourite: $response")
            }
        } catch (http: HttpException) {
            if (http.code() == 401) {
                Log.d("trace", "Error: ${http.message}")
            } else {
                Log.d("trace", "Error: ${http.message()}")
            }
        } catch (e: Exception) {
            Log.d("trace", "Error: ${e.message}")
        }
    }

    fun deleteFavourite(myaccount: String, name: String, account: String) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val fav = Favourite(name, account)
                val response = APIService.callable.removeFavourite(token!!, myaccount, fav)
                Log.d("trace", "deleteFavourite: $response")
            }
        } catch (http: HttpException) {
            if (http.code() == 401) {
                Log.d("trace", "Error: ${http.message}")
            } else {
                Log.d("trace", "Error: ${http.message()}")
            }
        } catch (e: Exception) {
            Log.d("trace", "Error: ${e.message}")
        }

    }
}