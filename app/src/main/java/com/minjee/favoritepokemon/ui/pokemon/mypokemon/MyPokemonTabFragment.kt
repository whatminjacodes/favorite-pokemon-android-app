package com.minjee.favoritepokemon.ui.pokemon.mypokemon

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.minjee.favoritepokemon.databinding.FragmentTabAllPokemonBinding
import com.minjee.favoritepokemon.databinding.FragmentTabMyPokemonBinding
import com.minjee.favoritepokemon.ui.pokemon.allpokemon.AllPokemonTabViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyPokemonTabFragment: Fragment() {

   private val myPokemonViewModel: MyPokemonTabViewModel by viewModel()

    private var _binding: FragmentTabMyPokemonBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTabMyPokemonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}