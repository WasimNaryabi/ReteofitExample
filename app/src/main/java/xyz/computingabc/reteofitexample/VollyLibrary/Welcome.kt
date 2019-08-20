package xyz.computingabc.reteofitexample.VollyLibrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import xyz.computingabc.reteofitexample.R

class Welcome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
    }

    override fun onBackPressed() {
        startActivity(Intent(applicationContext, VollyLibrary::class.java))
        finish()
    }
}
