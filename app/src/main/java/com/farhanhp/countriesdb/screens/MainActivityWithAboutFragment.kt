package com.farhanhp.countriesdb.screens

import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.farhanhp.countriesdb.R

abstract class MainActivityWithAboutFragment: MainActivityFragment() {
    override fun onResume() {
        super.onResume()

        parentActivity.toolbar.setOnMenuItemClickListener {
            if(it.itemId == R.id.about_screen_button) {
                findNavController().navigate(
                    R.id.aboutScreenFragment,
                    null,
                    navOptions {
                        anim {
                            enter = android.R.anim.slide_in_left
                            exit = android.R.anim.slide_out_right
                            popEnter = android.R.anim.slide_in_left
                            popExit = android.R.anim.slide_out_right
                        }
                    }
                )
                return@setOnMenuItemClickListener true
            }

            false
        }
    }

    override fun onStop() {
        super.onStop()

        parentActivity.toolbar.setOnMenuItemClickListener(null)
    }
}