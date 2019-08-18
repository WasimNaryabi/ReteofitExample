package xyz.computingabc.reteofitexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Welcome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
    }

    override fun onBackPressed() {
        startActivity(Intent(applicationContext,MainActivity::class.java))
        finish()
    }
}
