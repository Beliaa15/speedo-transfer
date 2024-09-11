package com.belia.speedotransfer.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belia.speedotransfer.api.APIService
import com.belia.speedotransfer.model.Favourite
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavouritesViewModel : ViewModel() {
    private val _favourites = MutableStateFlow<List<Favourite>>(emptyList())
    val favourite: StateFlow<List<Favourite>> = _favourites

    fun getFavourites(userId : Int) {
        viewModelScope.launch (Dispatchers.IO) {
            _favourites.update {
                APIService.callable.getFavourites(userId)
            }
            Log.d("trace", "getFavourites: $favourite")
        }
    }

    fun createFavourite(myaccount:String, name:String, account:String){
        viewModelScope.launch(Dispatchers.IO) {
            val fav = Favourite(name, account)
            val response = APIService.callable.createFavourite(myaccount,fav)
            Log.d("trace", "createFavourite: $response")
        }
    }

    fun deleteFavourite(myaccount:String, name:String, account:String){
        viewModelScope.launch(Dispatchers.IO) {
            val fav = Favourite(name, account)
            val response = APIService.callable.removeFavourite(myaccount,fav)
            Log.d("trace", "deleteFavourite: $response")
        }
    }
}