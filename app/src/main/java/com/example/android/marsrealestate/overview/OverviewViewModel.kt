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
        getMarsRealEstateProperties()
//        setValues()
    }

    /**
     * Sets the value of the status LiveData to the Mars API status.
     */
    private fun getMarsRealEstateProperties() {
       viewModelScope.launch {
           try {
               val apiResults = MarsApi.RETROFIT_SERVICE.getProperties()
               _allResponse.value = apiResults.toString()
               _response.value = apiResults.responses
               _teams.value = apiResults.responses?.get(0)?.teams
           } catch (e :Exception){
               _allResponse.value = "failed ${e.message}"
           }
       }
    }
}


//    private val _properties = MutableLiveData<MarsProperty?>()
//    val properties: LiveData<MarsProperty?>
//        get() = _properties
//
//
//    private val _fixtures = MutableLiveData<Fixture?>()
//    val fixtures: LiveData<Fixture?>
//        get() = _fixtures
//
//    private val _league = MutableLiveData<League?>()
//    val league: LiveData<League?>
//        get() = _league
//
//    private val _teams = MutableLiveData<Teams?>()
//    val teams: LiveData<Teams?>
//        get() = _teams
//
//    private val _goals = MutableLiveData<Goals?>()
//    val goals: LiveData<Goals?>
//        get() = _goals
//
//    private val _scores = MutableLiveData<Score?>()
//    val scores: LiveData<Score?>
//        get() = _scores
//
//    private val _events = MutableLiveData<List<Event?>>()
//    val events: LiveData<List<Event?>>
//        get() = _events

//    fun setValues(){
//        _fixtures.value = _properties.value?.response[]?.fixture
//        _league.value = _properties.value?.response?.league
//        _teams.value = _properties.value?.response?.teams
//        _goals.value = _properties.value?.response?.goals
//        _scores.value = _properties.value?.response?.score
//        _events.value = _properties.value?.response?.events
//    }
