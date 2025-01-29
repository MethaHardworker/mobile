package ru.fefu.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.fefu.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                add(
                    R.id.fragmentContainerView,
                    ActiveFragment.newInstance(),
                    "Active tag"
                )
                addToBackStack("tag name")
                commit()
            }
        }
        binding.bottomNavigationView.setOnItemSelectedListener {
            val activeFragment = supportFragmentManager.findFragmentByTag("Active tag")
            val profileFragment = supportFragmentManager.findFragmentByTag("Profile tag")
            when(it.itemId) {
                R.id.activity -> {
                    if (profileFragment != null) {
                        supportFragmentManager.beginTransaction().apply {
                            detach(profileFragment)
                            addToBackStack(null)
                            commit()
                        }
                    }
                    if (activeFragment == null) {
                        supportFragmentManager.beginTransaction().apply {
                            add(
                                R.id.fragmentContainerView,
                                ActiveFragment.newInstance(),
                                "Active tag"
                            )
                            addToBackStack("tag name")
                            commit()
                        }
                    }
                }
                R.id.profile -> {
                    if (activeFragment != null) {
                        supportFragmentManager.beginTransaction().apply {
                            detach(activeFragment)
                            addToBackStack(null)
                            commit()
                        }
                    }
                    if (profileFragment == null) {
                        supportFragmentManager.beginTransaction().apply {
                            add(
                                R.id.fragmentContainerView,
                                ProfileFragment.newInstance(),
                                "Profile tag"
                            )
                            addToBackStack("tag name")
                            commit()
                        }
                    }
                }
            }
            true
        }
        setContentView(binding.root)
    }
}