package xyz.computingabc.reteofitexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btnRegistor
import kotlinx.android.synthetic.main.activity_user__registor.*
import kotlinx.android.synthetic.main.activity_user_login.*
import kotlinx.android.synthetic.main.activity_user_login.txtEmail
import kotlinx.android.synthetic.main.activity_user_login.txtPwd
import org.json.JSONException
import org.json.JSONObject


class UserRegistor : AppCompatActivity() {

    private var Queue: RequestQueue? = null
    private val URL: String = "http://192.168.1.29/MyJson/newUser.php"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user__registor)

        Queue = Volley.newRequestQueue(this)

        btnRegistor.setOnClickListener {

            val name = txtName?.text.toString()
            val role = txtRole?.text.toString()
            val email = txtEmail?.text.toString()
            val password = txtPwd?.text.toString()


            val stringRequest = object : StringRequest(Request.Method.POST, URL, Response.Listener<String> {
                    response ->

                try {
                    var jsonObject: JSONObject = JSONObject(response)
                    if (jsonObject.names().get(0).equals("success")) {

                        Toast.makeText(applicationContext, "SUCCESS " + jsonObject.getString("success"), Toast.LENGTH_SHORT)
                            .show()
                        startActivity(Intent(applicationContext, UserLogin::class.java))
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
                    params.put("name", name)
                    params.put("email", email)
                    params.put("password", password)
                    params.put("role", role)
                    return params
                }

            }
            Queue!!.add(stringRequest)
        }

    }
}
