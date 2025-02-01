package ru.fefu.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.fefu.myapplication.databinding.FragmentDetailOtherBinding

class DetailOtherFragment : Fragment() {
    private lateinit var binding: FragmentDetailOtherBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailOtherBinding.inflate(inflater, container, false)
        binding.backBtn.setOnClickListener {
            activity?.onBackPressedDispatcher?.onBackPressed()
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = DetailOtherFragment()
    }
}