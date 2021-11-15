package com.example.myphase1.viewmodel

import android.os.Bundle
import android.telecom.Call
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.myphase1.R

class DetailsFragment : Fragment() {

    val username: DetailsFragmentArgs by navArgs()
    private var arrayusers = arrayListOf<String>()
//    private lateinit var etDetails: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_details, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name: String = username.username
        var jsonList = view.findViewById<ListView>(R.id.jsonList)
        arrayusers.add(name)
        var adapt = ArrayAdapter(this.requireContext(),android.R.layout.simple_list_item_1,arrayusers)
        jsonList.adapter = adapt
    }
}