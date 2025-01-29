package ru.fefu.myapplication

import android.app.Activity
import android.os.Bundle


class HelloWorldActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_world)
    }
}
