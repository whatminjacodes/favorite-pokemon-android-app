package com.minjee.favoritepokemon.ui.allpokemon

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.minjee.favoritepokemon.databinding.FragmentAllPokemonBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AllPokemonFragment : Fragment() {

    private val allPokemonViewModel: AllPokemonViewModel by viewModel()

    private var _binding: FragmentAllPokemonBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAllPokemonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        allPokemonViewModel.getPokemon()
        allPokemonViewModel.responseList.observe(viewLifecycleOwner, Observer {

            Log.d("test2", it.results.size.toString())

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}