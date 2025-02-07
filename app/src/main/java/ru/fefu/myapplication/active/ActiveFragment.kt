package ru.fefu.myapplication.active

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import ru.fefu.myapplication.R
import ru.fefu.myapplication.StartActivity
import ru.fefu.myapplication.VPAdapter
import ru.fefu.myapplication.databinding.FragmentActiveBinding


class ActiveFragment : Fragment() {
    private val fragList = listOf(
        ActiveListFragment.newInstance(),
        ActiveListUsersFragment.newInstance(),
    )

    private val titles = listOf(
        activity?.getString(R.string.personal),
        activity?.getString(R.string.all),
    )

    private lateinit var binding: FragmentActiveBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentActiveBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val adapter = ViewPagerAdapter(this)
        val adapter = VPAdapter(activity as AppCompatActivity, fragList)
        binding.vp2.adapter = adapter
        TabLayoutMediator(binding.tb, binding.vp2) {
                tab, pos ->  // tab.text = titles[pos]
            when(pos) {
                0 -> tab.text = getString(R.string.personal)
                1 -> tab.text = getString(R.string.all)
            }
        }.attach()
        binding.playButton.setOnClickListener {
            val intent = Intent(context, StartActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        fun newInstance() = ActiveFragment()
    }

}