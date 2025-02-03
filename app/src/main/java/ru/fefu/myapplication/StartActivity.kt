package ru.fefu.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.fefu.myapplication.ui.newactive.NewActiveFragment

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView2, NewActiveFragment.newInstance(), "replace tag")
                .commitNow()
        }

    }
}