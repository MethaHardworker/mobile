package ru.fefu.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.fefu.myapplication.databinding.FragmentActiveListPersonalBinding


class ActiveListPersonalFragment : Fragment() {
    private lateinit var binding: FragmentActiveListPersonalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentActiveListPersonalBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance() = ActiveListPersonalFragment()
    }
}