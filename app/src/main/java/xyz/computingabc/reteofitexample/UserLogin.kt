package xyz.computingabc.reteofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import android.widget.Toast
import android.content.Intent
import com.android.volley.AuthFailureError
import kotlinx.android.synthetic.main.activity_main.btnLogin
import kotlinx.android.synthetic.main.activity_user_login.*
import org.json.JSONException


class UserLogin : AppCompatActivity() {

    private var Queue: RequestQueue? = null
    private val URL: String = "http://192.168.1.29/MyJson/userControl.php"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)

        Queue = Volley.newRequestQueue(this)

        btnLogin.setOnClickListener {

            val email = txtEmail?.text.toString()
            val password = txtPwd?.text.toString()

            val stringRequest = object : StringRequest(Request.Method.POST, URL, Response.Listener<String> {
                    response ->

                try {
                    var jsonObject: JSONObject = JSONObject(response)
                    if (jsonObject.names().get(0).equals("success")) {

                        Toast.makeText(applicationContext, "SUCCESS " + jsonObject.getString("success"), Toast.LENGTH_SHORT)
                            .show()
                        startActivity(Intent(applicationContext, Welcome::class.java))
                    } else {
                        Toast.makeText(applicationContext, "Error" + jsonObject.getString("error"), Toast.LENGTH_SHORT)
                            .show()
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }

                /**/

            }, Response.ErrorListener { error ->
            }) {

                @Throws(AuthFailureError::class)
                override fun getParams(): Map<String, String> {
                    val params = HashMap<String, String>()
                    params.put("email", email)
                    params.put("password", password)
                    return params
                }

            }
            Queue!!.add(stringRequest)
        }
    }
}
