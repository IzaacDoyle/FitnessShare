package doyle.izaac.fitnessshare.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import doyle.izaac.fitnessshare.R
import doyle.izaac.fitnessshare.databinding.ActivityMainBinding
import doyle.izaac.fitnessshare.databinding.StartupLoginBinding
import doyle.izaac.fitnessshare.firebase.Login

import kotlinx.android.synthetic.main.startup_login.*

class LoginActivity: AppCompatActivity() {
    private val REQUEST_CODE_ACCOUNT = 222
    private lateinit var binding: StartupLoginBinding
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    //private val REQUEST_CODE_LOGIN = 111





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = StartupLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)





       // val account = ArrayList<AccountLoginModel>()


        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result ->
            when (result.resultCode) {
                REQUEST_CODE_ACCOUNT -> {
                    // do something thats account is made
                    Log.d("requestCode","${result.resultCode}")

                }
            }
        }

        binding.LoginLogin.setOnClickListener {
            when {
                TextUtils.isEmpty( Login_Email.text.toString().trim{it <= ' '}) -> {
                    Toast.makeText(
                        this,
                        "please Enter A Email",
                        Toast.LENGTH_SHORT
                    ).show()

                }
                TextUtils.isEmpty( Login_Password.text.toString().trim{it <= ' '})
                -> {
                    Toast.makeText(
                        this,
                        "please Enter A Password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    val email :String = Login_Email.text.toString().trim { it<= ' ' }
                    val password : String = Login_Password.text.toString().trim {it <= ' '  }
                    Login(this,applicationContext,Login_Email.text.toString(),Login_Password.text.toString())
                }
            }

        }

        binding.LoginCreate.setOnClickListener {

            val intent = Intent(applicationContext, CreateNewUser::class.java)
            resultLauncher.launch(intent)
        }


    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //getCurrentUser(this)
    }





}