package ru.fefu.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ru.fefu.myapplication.databinding.FragmentActiveListPersonalBinding


class ActiveListUsersFragment : Fragment() {
    private lateinit var binding: FragmentActiveListPersonalBinding

    private val activeAdapter = ActiveAdapter(activeListTotal)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentActiveListPersonalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.recyclerView) {
            adapter = activeAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        activeAdapter.setItemClickListener{
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                replace(
                    R.id.window,
                    DetailOtherFragment.newInstance()
                )
                addToBackStack("detail")
                commit()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ActiveListUsersFragment()
    }
}