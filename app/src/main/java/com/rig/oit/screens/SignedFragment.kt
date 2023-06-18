package com.rig.oit.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rig.oit.R
import com.rig.oit.databinding.FragmentSignedBinding
import com.rig.oit.recyclerviews.RecyclerViewAdapter

class SignedFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    private var _binding:FragmentSignedBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignedBinding.inflate(layoutInflater)

         var testRecyclerView = arrayListOf<String>(
            "Test 1",
            "Test 2",
            "Test 3",
            "Test 4",
            "Test 5"
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = RecyclerViewAdapter(testRecyclerView)

        binding.search.setOnClickListener {
            it.findNavController().navigate(R.id.action_signedFragment_to_searchFragment)
        }

        binding.buy.setOnClickListener {
            it.findNavController().navigate(R.id.action_signedFragment_to_addItems)
        }

        return binding.root
    }

}