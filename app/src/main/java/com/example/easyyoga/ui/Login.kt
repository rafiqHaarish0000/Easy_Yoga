package com.example.easyyoga.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.easyyoga.R
import com.example.easyyoga.databinding.FragmentLoginBinding

class Login : Fragment() {
    lateinit var binding: FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener {

        }

        binding.forgetText.setOnClickListener {

        }

        binding.signIn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.movetosignup)
        }

    }

    private fun validation(){

    }



}