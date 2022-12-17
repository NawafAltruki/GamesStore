package com.example.gamesstore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamesstore.R
import com.example.gamesstore.adapter.GamesStoreAdapter
import com.example.gamesstore.data.DataSource
import com.example.gamesstore.databinding.FragmentItemListBinding


class ItemListFragment : Fragment() {

    private var _binding : FragmentItemListBinding? =null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView

        val dataset = DataSource().loadGames()

        val adapter = GamesStoreAdapter(requireContext(), dataset)

        recyclerView.adapter = adapter

        recyclerView.setHasFixedSize(true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}