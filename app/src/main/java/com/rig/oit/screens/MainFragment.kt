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
import com.rig.oit.room.ItemDatabase
import com.rig.oit.room.ItemRepository
import com.rig.oit.viewmodel.SignedViewModel
import com.rig.oit.viewmodel.SignedViewModelFactory

class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    private lateinit var binding:FragmentMainBinding
    private lateinit var viewModel:SignedViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      binding=DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false)
        val daos = ItemDatabase.getInstance(requireContext().applicationContext)!!.itemDao()
        val repository: ItemRepository = ItemRepository(daos)

        val factory = SignedViewModelFactory(repository)
        viewModel= ViewModelProvider(this,factory)[SignedViewModel::class.java]

        binding.myViewModel = viewModel
        binding.lifecycleOwner=this

        binding.signIn.setOnClickListener {
            val flag =viewModel.signIn(binding.emailSignIn.text.toString(), binding.passwordSignIn.text.toString())
           if(true){
               it.findNavController().navigate(R.id.action_mainFragment_to_signedFragment)
           }
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