package ru.fefu.myapplication

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.toSpannable


fun SpannableString.makeLinks(
    phrase: String,
    phraseColor: Int,
    listener: () -> Unit
): SpannableString {
    val clickableSpan = object : ClickableSpan() {
        override fun onClick(view: View) {
            listener.invoke()
        }
        override fun updateDrawState(ds: TextPaint) {
            ds.color = phraseColor // you can use custom color
        }
    }
    val start = indexOf(phrase)
    val end = start + phrase.length
    setSpan(
        clickableSpan,
        start,
        end,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    return this
}

class RegistrationActivity : AppCompatActivity(R.layout.registration) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration)
        val backBtn = findViewById<ImageButton>(R.id.backBtn)
        backBtn.setOnClickListener {
            val intent = Intent(this, WelcomeScreenActivity::class.java)
            startActivity(intent)
        }
        val textView = findViewById<TextView>(R.id.textView6)
        val textSpannable = textView.text.toSpannable() as SpannableString
        textSpannable.makeLinks(
            "политикой конфиденциальности",
            Color.BLUE,
            listener = {
                val url = Uri.parse("https://google.com")
                startActivity(Intent(Intent.ACTION_VIEW, url))
            }
        )
        textSpannable.makeLinks(
            "пользовательское соглашение",
            Color.BLUE,
            listener = {
                val url = Uri.parse("https://google.com")
                startActivity(Intent(Intent.ACTION_VIEW, url))
            }
        )
        textView.text = textSpannable
        textView.movementMethod = LinkMovementMethod.getInstance()
    }
}