/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.android.marsrealestate.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.marsrealestate.network.*
import kotlinx.coroutines.launch

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData String that stores the most recent response
    private val _allResponse = MutableLiveData<String>()

    // The external immutable LiveData for the response String
    val allResponse: LiveData<String>
        get() = _allResponse

    private val _response = MutableLiveData<List<Responses>>()
    val responses: LiveData<List<Responses>>
        get() = _response

    private val _teams = MutableLiveData<Teams>()
    val teams: LiveData<Teams>
        get() = _teams



    /**
     * Call getMarsRealEstateProperties() on init so we can display status immediately.
     */
    init {
        getFootballProperties()
//        setValues()
    }

    /**
     * Sets the value of the status LiveData to the Mars API status.
     */
    fun getFootballProperties() {
       viewModelScope.launch {
           try {
               val apiResults = MarsApi.RETROFIT_SERVICE.getProperties()
               _allResponse.value = apiResults.toString()
               _response.value = apiResults.response
               _teams.value = apiResults.response?.get(0)?.teams
           } catch (e :Exception){
               _allResponse.value = "failed ${e.message}"
           }
       }
    }
}



