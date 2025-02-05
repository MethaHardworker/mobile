package ru.fefu.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.fefu.myapplication.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.changePwd.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                replace(
                    binding.root.id,
                    ChangePasswordFragment.newInstance(),
                    "toChangePassword"
                )
                commit()
            }
        }
        binding.logout.setOnClickListener {
            val intent = Intent(context, WelcomeScreenActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProfileFragment()
    }

}