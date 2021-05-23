package com.minjee.favoritepokemon.ui.pokemon.allpokemon

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.minjee.favoritepokemon.databinding.FragmentTabAllPokemonBinding
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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        allPokemonViewModel.getPokemon()
        allPokemonViewModel.responseList.observe(viewLifecycleOwner, Observer {

            Log.d("test22", it.results.size.toString())

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}