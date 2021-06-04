package com.minjee.favoritepokemon.ui.pokemon.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.minjee.favoritepokemon.databinding.FragmentPokemonDetailsBinding

class PokemonDetailsFragment: Fragment() {

    //private val allPokemonViewModel: AllPokemonTabViewModel by viewModel()

    private var _binding: FragmentPokemonDetailsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonDetailsBinding.inflate(inflater, container, false)

        // Adding observers
       // allPokemonViewModel.listOfPokemon.observe(viewLifecycleOwner, pokemonListUpdatedObserver)

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