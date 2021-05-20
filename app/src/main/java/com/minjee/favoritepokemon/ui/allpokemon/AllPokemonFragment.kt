package com.minjee.favoritepokemon.ui.allpokemon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.minjee.favoritepokemon.databinding.FragmentAllPokemonBinding

class AllPokemonFragment : Fragment() {

    private lateinit var allPokemonViewModel: AllPokemonViewModel

    private var _binding: FragmentAllPokemonBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        allPokemonViewModel =
            ViewModelProvider(this).get(AllPokemonViewModel::class.java)
        _binding = FragmentAllPokemonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textHome.text = "all pokemon fragment teksti"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}