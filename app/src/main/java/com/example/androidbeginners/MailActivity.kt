package com.example.androidbeginners

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_mail.*

class MailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mail)

        sendMail()
    }

    //    https://stackoverflow.com/questions/4883199/using-android-intent-action-send-for-sending-email
    private fun sendMail() {
        mail_button.setOnClickListener {
//            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"))
            val emailIntent = Intent(Intent.ACTION_SEND).apply {
                type = "message/rfc822"
                putExtra(Intent.EXTRA_EMAIL, arrayOf(mail_to_text.text.toString()))
                putExtra(Intent.EXTRA_SUBJECT, mail_subject_text.text.toString())
                putExtra(Intent.EXTRA_TEXT, mail_content_text.text)
                putExtra(Intent.EXTRA_TITLE, mail_subject_text.text)
//                selector = intent
            }
            if (emailIntent.resolveActivity(packageManager) != null) {
                startActivity(emailIntent)
            }
        }
    }
}
