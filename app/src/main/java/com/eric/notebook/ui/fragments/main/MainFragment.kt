package com.eric.notebook.ui.fragments.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.eric.notebook.R

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


}