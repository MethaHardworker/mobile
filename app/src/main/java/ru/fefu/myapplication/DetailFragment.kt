package ru.fefu.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.fefu.myapplication.active.ActiveFragment
import ru.fefu.myapplication.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        val activeFragment = activity?.supportFragmentManager?.findFragmentByTag("Active tag")
        val detailFragment = activity?.supportFragmentManager?.findFragmentByTag("Detail tag")
        binding.backBtn.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                if (detailFragment != null) {
                    remove(detailFragment)
                }
                commit()
            }
            if (activeFragment == null) {
                activity?.supportFragmentManager?.beginTransaction()?.apply {
                    add(
                        R.id.fragmentContainerView,
                        ActiveFragment.newInstance(),
                        "Active tag"
                    )
                    addToBackStack("active tag name")
                    commit()
                }
            }
            else {
                activity?.supportFragmentManager?.beginTransaction()?.attach(activeFragment)?.commit()
            }
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = DetailFragment()
    }
}