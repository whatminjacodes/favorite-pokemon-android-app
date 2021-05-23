package com.minjee.favoritepokemon.ui.pokemon.allpokemon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.minjee.favoritepokemon.data.PokemonList
import com.minjee.favoritepokemon.databinding.FragmentTabAllPokemonBinding
import com.minjee.favoritepokemon.ui.recyclerview.PokemonRecyclerViewAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class AllPokemonTabFragment : Fragment() {

    private val allPokemonViewModel: AllPokemonTabViewModel by viewModel()

    private var _binding: FragmentTabAllPokemonBinding? = null
    private val binding get() = _binding!!

    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTabAllPokemonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        allPokemonViewModel.getPokemon()
        allPokemonViewModel.responseList.observe(viewLifecycleOwner, Observer {

            //pokemonList = it.results
        })

        var listOfPokemon = listOf<PokemonList>(
            PokemonList("bulba", "asd"),
            PokemonList("ivysaur", "asd"),
            PokemonList("venusaur", "asd"),
            PokemonList("pikapii", "asd")
        )

        linearLayoutManager = LinearLayoutManager(context)

        binding.apply {
            myPokemonTabRecyclerview.layoutManager = linearLayoutManager
            myPokemonTabRecyclerview.adapter = PokemonRecyclerViewAdapter(listOfPokemon)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}