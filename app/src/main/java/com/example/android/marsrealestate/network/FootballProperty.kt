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

package com.example.android.marsrealestate.network

data class FootballProperty(
    val get : String?,
    val parameters : Parameters?,
    val errors : List<String>?,
    val results : Int?,
    val paging : Paging?,
    val responses : List<Responses>?
)
data class Paging(
    val current : Int?,
    val total : Int?
)

data class Parameters(
    val live : String?
)

data class Responses(
    val fixture : Fixture?,
    val league : League?,
    val teams : Teams?,
    val goals : Goals?,
    val score : Score?,
    val events : List<Event>?
)

data class Event(
    val time : Time?,
    val team: LiveTeams?,
    val player : Player?,
    val assist : Assist?,
    val type : String?,
    val detail : String?,
    val comments : String?
)

data class Assist(
    val id : Int?,
    val name: String?
)

data class Player(
    val id : Int?,
    val name: String?
)

data class LiveTeams(
    val id : Int?,
    val name : String?,
    val logo: String?
)

data class Time(
    val elapsed : Int?,
    val extra : Double?
)

data class Fixture(
    val id : Int?,
    val referee : String?,
    val timezone : String?,
    val date : String?,
    val timestamp : Double?,
    val periods : Periods?,
    val venue : Venue?,
    val status : Status?
)

data class Periods(
    val first : Double?,
    val second : Double?
)

data class Venue(
    val id : Int?,
    val name : String?,
    val city : String?
)

data class Status(
    val long : String?,
    val short : String?,
    val elapsed : Int?
)

data class League(
    val id : Int?,
    val name: String?,
    val country: String?,
    val logo: String?,
    val flag: String?,
    val season: Int?,
    val round: String?
)

data class Teams(
    val home : HomeAway?,
    val away  : HomeAway?
)

data class HomeAway(
    val id: Int?,
    val name: String?,
    val logo: String?,
    val winner: Boolean?
)

data class Goals(
    val home : Double?,
    val away : Double?
)

data class Score(
    val halftime : TimeScore?,
    val fulltime : TimeScore?,
    val extratime : TimeScore?,
    val penalty : TimeScore?
)

data class TimeScore(
    val home : Int?,
    val away : Int?
)





