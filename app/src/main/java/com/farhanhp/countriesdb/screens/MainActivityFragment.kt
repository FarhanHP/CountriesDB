package com.farhanhp.countriesdb.screens

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.farhanhp.countriesdb.MainActivity
import com.farhanhp.countriesdb.MainActivityViewModel
import com.google.android.material.appbar.AppBarLayout

abstract class MainActivityFragment: Fragment() {
    protected val activityViewModel: MainActivityViewModel by activityViewModels()
    protected lateinit var appBar: AppBarLayout
    protected lateinit var parentActivity: MainActivity

    override fun onStart() {
        super.onStart()
        parentActivity = requireActivity() as MainActivity
        appBar = parentActivity.appBar
    }
}