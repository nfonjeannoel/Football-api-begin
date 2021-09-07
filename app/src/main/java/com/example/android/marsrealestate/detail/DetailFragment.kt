/*
 *  Copyright 2019, The Android Open Source Project
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.example.android.marsrealestate.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.marsrealestate.databinding.FragmentDetailBinding
import com.example.android.marsrealestate.network.Responses

/**
 * This [Fragment] will show the detailed information about a selected piece of Mars real estate.
 */
class DetailFragment : Fragment() {

    private lateinit var args: DetailFragmentArgs
    private lateinit var viewModelFactory: DetailViewModelFactory
    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: FragmentDetailBinding
    private lateinit var responses: Responses

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        @Suppress("UNUSED_VARIABLE")
        val application = requireNotNull(activity).application
        binding = FragmentDetailBinding.inflate(inflater)
        args = DetailFragmentArgs.fromBundle(arguments!!)
        responses = DetailFragmentArgs.fromBundle(arguments!!).response
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelFactory = DetailViewModelFactory(args.response)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)

        binding.apply {
            tvHomeName.text = responses.teams?.home?.name
            tvAwayName.text = responses.teams?.away?.name
            tvHomeGoal.text = responses.goals?.home.toString()
            tvAwayGoal.text = responses.goals?.away.toString()
            tvLeagueName.text = responses.league?.name
            tvReferee.text = responses.fixture?.referee
            tvVenue.text = responses.fixture?.venue?.name
            tvVenue2.text = responses.fixture?.venue?.city
        }

    }



}