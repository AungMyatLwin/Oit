package com.rig.oit.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController


import com.rig.oit.R
import com.rig.oit.databinding.FragmentSignUpBinding
import com.rig.oit.viewmodel.MyViewModel

class SignUpFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private lateinit var binding: FragmentSignUpBinding
    private  lateinit var viewModel:MyViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_sign_up, container, false)
        viewModel= ViewModelProvider(this).get(MyViewModel::class.java)
        binding.signupViewModel=viewModel
        binding.lifecycleOwner=this

        binding.buttonSave.setOnClickListener {
            val name=binding.signupName.text.toString()
            val email=binding.signupEmail.text.toString()
            val pwd=binding.signupPwd.text.toString()
            val re_pwd=binding.signupRePwd.text.toString()
            viewModel.signupSave(name, email, pwd, re_pwd)
            Log.d("Test:", "${viewModel.liveDataMsg.value}")
            it.findNavController().navigate(R.id.action_signUpFragment_to_mainFragment)
        }
        return binding.root
    }
}