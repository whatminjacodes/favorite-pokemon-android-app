package com.minjee.favoritepokemon.ui.favorites.allpokemon

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.minjee.favoritepokemon.data.PokemonList
import com.minjee.favoritepokemon.databinding.FragmentTabAllPokemonBinding
import com.minjee.favoritepokemon.ui.recyclerview.PokemonRecyclerViewAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class AllPokemonTabFragment : Fragment() {

    private val allPokemonViewModel: AllPokemonTabViewModel by viewModel()

    private var _binding: FragmentTabAllPokemonBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTabAllPokemonBinding.inflate(inflater, container, false)

        // Adding observers
      //  allPokemonViewModel.listOfPokemon.observe(viewLifecycleOwner, pokemonListUpdatedObserver)

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