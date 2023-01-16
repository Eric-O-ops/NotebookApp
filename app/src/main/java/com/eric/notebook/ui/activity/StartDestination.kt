package com.eric.notebook.ui.activity

import androidx.navigation.fragment.NavHostFragment
import com.eric.notebook.R

interface StartDestination {

    fun startDestId(value: Boolean)

    class Base(
        navHostFragment: NavHostFragment,
        navGraph: Int,
    ) : StartDestination {

        private val navController = navHostFragment.navController
        private val navGraph = navController.navInflater.inflate(navGraph)

        override fun startDestId(value: Boolean) {
            val startDestId = if (value) R.id.mainFragment else R.id.mainOnBoardFragment
            navGraph.setStartDestination(startDestId)
            navController.graph = navGraph
        }
    }
}