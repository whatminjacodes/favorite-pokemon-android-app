package com.minjee.favoritepokemon.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.minjee.favoritepokemon.R
import com.minjee.favoritepokemon.databinding.FragmentFavoritesBinding
import com.minjee.favoritepokemon.ui.favorites.firstTeam.FirstTeamTabFragment
import com.minjee.favoritepokemon.ui.favorites.secondTeam.SecondTeamTabFragment

/*
 *      Fragment which has a TabLayout and ViewPager2 for displaying different Pokemon teams the user has chosen
 */
class FavoritesFragment : Fragment() {
    private var binding: FragmentFavoritesBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        this.binding = binding

        val viewPager = binding.workViewPager
        viewPager.adapter = ViewPagerAdapter(activity)

        val tabLayout = binding.fragmentPokemonTabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = (viewPager.adapter as ViewPagerAdapter?)!!.tabFragmentTitles[position]
        }.attach()

        return binding.root
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    class ViewPagerAdapter(activity: FragmentActivity?) : FragmentStateAdapter(activity!!) {

        val tabFragmentTitles = arrayOf(
            activity?.getString(R.string.fragment_tab_all_pokemon_title),
            activity?.getString(R.string.fragment_tab_my_pokemon_title)
        )

        override fun getItemCount(): Int {
            return tabFragments.size
        }

        override fun getItemId(position: Int): Long {
            return super.getItemId(position)
        }

        override fun createFragment(position: Int): Fragment {
            return tabFragments[position]
        }

        private val tabFragments = arrayOf(
            FirstTeamTabFragment(),
            SecondTeamTabFragment()
        )
    }
}