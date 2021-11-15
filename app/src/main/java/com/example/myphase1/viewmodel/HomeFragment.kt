package com.example.myphase1.viewmodel

import android.content.Context
import android.os.Bundle
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myphase1.R
import com.example.myphase1.databinding.FragmentHomeBinding
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.util.zip.Inflater


class HomeFragment : Fragment() {

    var arrayusers = arrayListOf<JSONObject>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.loginButton)
        val etName = view.findViewById<EditText>(R.id.etName)
        val etPassword = view.findViewById<EditText>(R.id.etPassword)
        readUsersList(this.requireContext())

        button.setOnClickListener{

            for (i in 0 until arrayusers.size)
            {
                var jsonObj = arrayusers.get(index = i)
                if (jsonObj.getString("userName") == etName.text.toString() &&
                    jsonObj.getString("password") == etPassword.text.toString()){
                    findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment("Welcome "+etName.text.toString()))
                    break

                }
            }
        }
    }

    private fun readUsersList(context: Context) {

        var json: String? = null

        try {

            val inputStream: InputStream = context.assets.open("users.json")
            json = inputStream.bufferedReader().use { it.readText() }

            var jsonarr = JSONArray(json)

            for (i in 0 until jsonarr.length())
            {
                var jsonObj = jsonarr.getJSONObject(i)
                arrayusers.add(jsonObj)
            }
        }catch (e: IOException){

        }
    }
}