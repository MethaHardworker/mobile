package ru.fefu.myapplication.ui.newactive

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ru.fefu.myapplication.active.ActiveTypeAdapter

import ru.fefu.myapplication.databinding.FragmentNewActiveBinding

class NewActiveFragment : Fragment() {

    private lateinit var binding: FragmentNewActiveBinding
    private val activeTypeAdapter = ActiveTypeAdapter()
    companion object {
        fun newInstance() = NewActiveFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewActiveBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.recyclerView2) {
            adapter = activeTypeAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        }
        binding.btnStart.setOnClickListener {
            val currentFragment = activity?.supportFragmentManager?.findFragmentByTag("replace tag")?.id
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                if (currentFragment != null) {
                    replace(
                        currentFragment,
                        NewActiveStartedFragment.newInstance(activeTypeAdapter.chosenTitle),
                        "replace tag"
                    )
                }
                commit()
            }
        }
    }

}