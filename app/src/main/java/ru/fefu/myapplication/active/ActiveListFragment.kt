package ru.fefu.myapplication.active

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ru.fefu.myapplication.DetailFragment
import ru.fefu.myapplication.R
import ru.fefu.myapplication.database.Dap.db
import ru.fefu.myapplication.databinding.FragmentActiveListBinding


class ActiveListFragment : Fragment() {
    private lateinit var binding: FragmentActiveListBinding

    private val activeAdapter = ActiveAdapter(activeListPersonal)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentActiveListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.recyclerView) {
            adapter = activeAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        db.activeDao().getAllActives().observe(viewLifecycleOwner) {
            activeAdapter.submitList(it)
        }

        activeAdapter.setItemClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                add(
                    R.id.fragmentContainerView,
                    DetailFragment.newInstance(),
                    "Detail tag"
                )
                addToBackStack("detail")
                commit()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(): Fragment {
            return ActiveListFragment()
        }
    }
}