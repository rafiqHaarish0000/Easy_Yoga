package com.example.easyyoga.ui

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.easyyoga.R
import com.example.easyyoga.databinding.FragmentSignupBinding

class Signup : Fragment() {
    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.signInButton?.setOnClickListener {
               submitSignIn()
        }
    }

    private fun submitSignIn(){

        val validName = binding?.userNameContainer?.helperText == null
        val validEmail = binding?.emailContainer?.helperText == null
        val validPassword = binding?.mainPasswordContainer?.helperText == null
        val validConfirm = binding?.confirmPasswordContainer?.helperText == null

        if(validName && validEmail && validPassword && validConfirm)
            showForm()
        else
            invalidForm()
    }

    private fun invalidForm() {
        TODO("Not yet implemented")
    }

    private fun showForm() {
        TODO("Not yet implemented")
    }

    private fun checkValidation():Boolean{
        var flag = true
        binding?.emailTextView?.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding?.emailContainer?.helperText = validText()
                flag = false
            }
        }

        binding?.mainPasswordTextview?.setOnFocusChangeListener { _, focused ->

            if (!focused) {
                binding?.mainPasswordContainer?.helperText = passwordText()
                flag = false

            }
        }

        binding?.confirmTextview?.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding?.confirmPasswordContainer?.helperText = confirmPassword()
                flag = false
            }
        }
        binding?.userNameText?.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding?.userNameContainer?.helperText = userName()
                flag = false
            }
        }
        return flag
    }

    private fun userName(): String? {
        val userNameText = binding?.userNameText?.text.toString()
        if(userNameText.isBlank()){
            return "Username Cannot Be Empty"
        }
        return null
    }

    private fun confirmPassword(): String? {
        
        val confirmPassword = binding?.confirmTextview?.text.toString()
        val password = binding?.mainPasswordTextview?.text.toString()

        if (!confirmPassword.matches(password.toRegex())) {
            return "Password Miss Matched"
        }
        return null
    }

    private fun passwordText(): String? {
        val password = binding?.mainPasswordTextview?.text.toString()

        if (password.length < 8) {

            binding?.mainPasswordContainer?.isCounterEnabled = true
            binding?.mainPasswordContainer?.counterMaxLength = 8

            return "Minimum 8 characters required"
        }
        if (!password.matches(".*[A-Z].*".toRegex())) {
            return "Must Contains 1 Uppercase Character"
        }
        if (!password.matches(".*[A-Z].*".toRegex())) {
            return "Must Contains 1 Uppercase Character"
        }
        if (!password.matches(".*[@#\$%^&+=].*".toRegex())) {
            return "Must Contains 1 Special Character"
        }
        return null
    }

    private fun validText(): String? {
        val emailValidation = binding?.emailTextView?.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailValidation).matches()) {
            return "Invalid Email Address"
        }
        return null
    }

    private fun message(toast:String){
        Toast.makeText(requireContext(),toast,Toast.LENGTH_SHORT).show()
    }

}