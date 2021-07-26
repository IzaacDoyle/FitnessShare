package doyle.izaac.fitnessshare.activities

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import doyle.izaac.fitnessshare.databinding.CreateAccountBinding
import doyle.izaac.fitnessshare.firebase.CreateNewUser
import kotlinx.android.synthetic.main.create_account.*

class CreateNewUser: AppCompatActivity() {

    private lateinit var binding: CreateAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.CreateCreate.setOnClickListener {
            when {
                TextUtils.isEmpty(binding.CreateEmail.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show()
                }
                TextUtils.isEmpty(binding.CreatePassword.text.toString().trim{it<= ' '}) -> {
                    Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show()
                }
                TextUtils.isEmpty(binding.CreatePasswordRetype.text.toString().trim { it<= ' ' }) ->{
                    Toast.makeText(this, "Please Enter  Retyped Password", Toast.LENGTH_SHORT).show()
                }
                else->{
                    if(binding.CreatePassword.text.toString()!=binding.CreatePasswordRetype.text.toString()){
                        Toast.makeText(this, "Please Enter  matching Passwords", Toast.LENGTH_SHORT).show()
                        //Log Needs to be removed
                        //  Log.d("NewUserPW","${Create_Password.text.toString()} ${Create_PasswordRetype.text.toString()}")
                    }else{
                        val email:String = Create_Email.text.toString().trim { it<= ' ' }
                        val password:String = Create_Password.text.toString().trim { it<= ' ' }
                        CreateNewUser(applicationContext,this,email,password)
                    }

            }
        }


    }

}
}