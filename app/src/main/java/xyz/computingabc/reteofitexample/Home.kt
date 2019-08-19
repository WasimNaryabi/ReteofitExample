package xyz.computingabc.reteofitexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnVolly.setOnClickListener {
            startActivity(Intent(applicationContext,MainActivity::class.java))
            finish()
        }
    }

    override fun onBackPressed() {
        // Initialize a new instance of
        val builder = AlertDialog.Builder(this)

        // Set the alert dialog title
        builder.setTitle("Exit Permission")

        // Display a message on alert dialog
        builder.setMessage("Are you want to Exit the app")
        builder.setIcon(R.drawable.ic_alert)

        // Set a positive button and its click listener on alert dialog
        builder.setPositiveButton("YES"){dialog, which ->
            // Do something when user press the positive button
           finish()
        }


        // Display a negative button on alert dialog
        builder.setNegativeButton("No"){dialog,which ->


        }


        // Finally, make the alert dialog using builder
        val dialog: AlertDialog = builder.create()

        // Display the alert dialog on app interface
        dialog.show()
    }
}
