package com.minjee.favoritepokemon.ui.allpokemon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.minjee.favoritepokemon.databinding.FragmentPokemonBinding

class PokemonFragment : Fragment() {
    private var binding: FragmentPokemonBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPokemonBinding.inflate(inflater, container, false)
        this.binding = binding

       /* val viewPager = binding.workViewPager
        viewPager.adapter = ViewPagerAdapter(activity)

        val tabLayout = binding.workTabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = (viewPager.adapter as ViewPagerAdapter?)!!.tabFragmentTitles[position]
        }.attach()
*/
        return binding.root
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}