package com.rig.oit.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.rig.oit.databinding.FragmentSignedBinding
import com.rig.oit.recyclerviews.RecyclerViewAdapter
import com.rig.oit.room.ItemDatabase
import com.rig.oit.room.ItemRepository
import com.rig.oit.room.Items
import com.rig.oit.viewmodel.SignedViewModel
import com.rig.oit.viewmodel.SignedViewModelFactory

class SignedFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private lateinit var viewModel: SignedViewModel
    private var _binding:FragmentSignedBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignedBinding.inflate(layoutInflater)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val email = arguments?.let { SignedFragmentArgs.fromBundle(it).email }

        val daos =ItemDatabase.getInstance(requireContext().applicationContext)!!.itemDao()
        val repository: ItemRepository=ItemRepository(daos)

        val factory = SignedViewModelFactory(repository)

        viewModel=ViewModelProvider(this,factory).get(SignedViewModel::class.java)
        binding.recyclerView.adapter = RecyclerViewAdapter(viewModel.items(email!!))

        viewModel.getItems.observe(viewLifecycleOwner) { items ->
            binding.recyclerView.adapter = RecyclerViewAdapter(items)
        }

        binding.buy.setOnClickListener {
            val items= Items(0,binding.addEdit.text.toString(), false, email)
            Log.i("Args ss","${email}")
            viewModel.insertItems(items)
            binding.recyclerView.adapter = RecyclerViewAdapter(viewModel.items(email))
        }
        binding.clear.setOnClickListener {
            viewModel.deleteRow(email)
            binding.recyclerView.adapter = RecyclerViewAdapter(viewModel.items(email))
        }

        return binding.root
    }

}