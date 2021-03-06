package com.minjee.favoritepokemon.ui.teams.secondTeam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.minjee.favoritepokemon.databinding.FragmentTabTeamsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/*
 *      Fragment which will display a team of Pokemon chosen by the user
 */
class SecondTeamTabFragment : Fragment() {

    private val viewModel: SecondTeamTabViewModel by viewModel()

    private var _binding: FragmentTabTeamsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTabTeamsBinding.inflate(inflater, container, false)
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