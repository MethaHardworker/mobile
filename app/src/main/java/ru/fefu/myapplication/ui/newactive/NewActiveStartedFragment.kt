package ru.fefu.myapplication.ui.newactive

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.fefu.myapplication.MainActivity
import ru.fefu.myapplication.databinding.FragmentNewActiveStartedBinding


private const val active_name = "param1"

class NewActiveStartedFragment : Fragment() {

    private var header_text: String? = null

    lateinit var binding: FragmentNewActiveStartedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            header_text = it.getString(active_name)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewActiveStartedBinding.inflate(inflater, container, false)
        binding.message.text = header_text
        binding.finishButton.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            NewActiveStartedFragment().apply {
                arguments = Bundle().apply {
                    putString(active_name, param1)
                }
            }
    }
}