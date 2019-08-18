package xyz.computingabc.reteofitexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnLogin.setOnClickListener {
            startActivity(Intent(applicationContext,UserLogin::class.java))
            finish()
        }

        btnRegistor.setOnClickListener {
            startActivity(Intent(applicationContext,UserRegistor::class.java))
            finish()
        }
    }
}
