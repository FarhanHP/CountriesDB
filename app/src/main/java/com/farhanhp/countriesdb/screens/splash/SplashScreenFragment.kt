package com.farhanhp.countriesdb.screens.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.farhanhp.countriesdb.MainActivity
import com.farhanhp.countriesdb.R
import kotlinx.coroutines.delay


@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(R.layout.fragment_splash_screen, container, false)

    lifecycleScope.launchWhenResumed {
      delay(2000)
      findNavController().navigate(R.id.action_splashScreenFragment_to_mainScreenFragment)
    }

    return view
  }

  override fun onResume() {
    super.onResume()
    (requireActivity() as MainActivity).getAppBar().visibility = View.GONE
  }

  override fun onStop() {
    super.onStop()
    (requireActivity() as MainActivity).getAppBar().visibility = View.VISIBLE
  }
}