package ru.fefu.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.fefu.myapplication.databinding.FragmentActiveListBinding


class ActiveListFragment : Fragment() {
    private lateinit var binding: FragmentActiveListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentActiveListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance(): Fragment {
            return ActiveListFragment()
        }
    }
}