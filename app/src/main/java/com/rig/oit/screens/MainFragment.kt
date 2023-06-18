package com.rig.oit.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.rig.oit.R
import com.rig.oit.databinding.FragmentMainBinding
import com.rig.oit.viewmodel.MyViewModel

class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    private lateinit var binding:FragmentMainBinding
    private lateinit var viewModel:MyViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      binding=DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false)

        viewModel= ViewModelProvider(this).get(MyViewModel::class.java)

        binding.myViewModel = viewModel
        binding.lifecycleOwner=this

        binding.signIn.setOnClickListener {
            viewModel.signIn(binding.emailSignIn.text.toString(), binding.passwordSignIn.text.toString())
            viewModel.liveDataMsg.value?.let { it1 -> toastMsg(it1) }
            it.findNavController().navigate(R.id.action_mainFragment_to_signedFragment)
        }

        binding.signUp.setOnClickListener {
            it.findNavController().navigate(R.id.action_mainFragment_to_signUpFragment)
        }
        return binding.root
    }
    fun toastMsg(msg:String){
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

}