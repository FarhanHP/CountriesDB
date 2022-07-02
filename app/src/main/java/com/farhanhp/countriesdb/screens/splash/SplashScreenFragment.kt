package com.farhanhp.countriesdb.screens.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.farhanhp.countriesdb.R
import com.farhanhp.countriesdb.screens.MainActivityFragment
import kotlinx.coroutines.delay


@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : MainActivityFragment() {
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    super.onCreateView(inflater, container, savedInstanceState)

    val view = inflater.inflate(R.layout.fragment_splash_screen, container, false)

    lifecycleScope.launchWhenResumed {
      delay(1000)
      findNavController().navigate(SplashScreenFragmentDirections.actionSplashScreenFragmentToMainScreenFragment())
    }

    return view
  }

  override fun onResume() {
    super.onResume()
    appBar.visibility = View.GONE
  }

  override fun onStop() {
    super.onStop()
    appBar.visibility = View.VISIBLE
  }
}