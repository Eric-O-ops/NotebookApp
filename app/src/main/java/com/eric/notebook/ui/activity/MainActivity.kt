package com.eric.notebook.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.eric.notebook.R
import com.eric.notebook.data.local.preferences.userdata.UserPreferenceData
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userPreferencesData: UserPreferenceData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        //StartDestination.Base(navHostFragment, R.navigation.nav_graph).startDestId(value)
        val navController = navHostFragment.navController
        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)

        when {
            !userPreferencesData.onBoard -> {
                navGraph.setStartDestination(R.id.mainOnBoardFragment)
            }

            else -> {
                navGraph.setStartDestination(R.id.signInFragment)
            }
        }
        navController.graph = navGraph
    }
}