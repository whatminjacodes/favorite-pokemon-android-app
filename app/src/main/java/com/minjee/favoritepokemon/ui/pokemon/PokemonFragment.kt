package com.minjee.favoritepokemon.ui.pokemon

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
import com.minjee.favoritepokemon.databinding.FragmentPokemonBinding
import com.minjee.favoritepokemon.ui.recyclerview.PokemonRecyclerViewAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonFragment : Fragment() {
    private val allPokemonViewModel: PokemonViewModel by viewModel()

    private var _binding: FragmentPokemonBinding? = null
    private val binding get() = _binding!!

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var gridLayoutManager: GridLayoutManager

    private val pokemonListUpdatedObserver =
        Observer<List<PokemonList>> { listOfPokemon ->
            binding.pokemonFragmentRecyclerview.adapter =
                PokemonRecyclerViewAdapter(listOfPokemon) { name ->
                    pokemonListItemClicked(
                        name
                    )
                }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonBinding.inflate(inflater, container, false)

        // Adding observers
        allPokemonViewModel.listOfPokemon.observe(viewLifecycleOwner, pokemonListUpdatedObserver)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        allPokemonViewModel.getPokemon()

        linearLayoutManager = LinearLayoutManager(context)
        gridLayoutManager = GridLayoutManager(context, 2)

        binding.apply {
            pokemonFragmentRecyclerview.layoutManager = gridLayoutManager
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun pokemonListItemClicked(string: String) {
        Log.d("test", string)
        // NavHostFragment.findNavController(requireParentFragment()).navigate()
    }
}