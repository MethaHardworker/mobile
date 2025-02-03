package ru.fefu.myapplication.active

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ru.fefu.myapplication.DetailOtherFragment
import ru.fefu.myapplication.R
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

        activeAdapter.setItemClickListener {
            val activeFragment = activity?.supportFragmentManager?.findFragmentByTag("Active tag")
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                add(
                    R.id.fragmentContainerView,
                    DetailOtherFragment.newInstance(),
                    "Detail tag"
                )
                if (activeFragment != null) {
                    detach(activeFragment)
                }
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