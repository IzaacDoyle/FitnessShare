package doyle.izaac.fitnessshare.firebase

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import doyle.izaac.fitnessshare.activities.MainActivity


private var mAuth: FirebaseAuth = FirebaseAuth.getInstance()





fun Login(parent: Activity,context: Context,Email: String,Password: String){

mAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener {
    task ->
        if (task.isSuccessful) {
            val firebaseUser: FirebaseUser = task.result!!.user!!
            val intent = Intent(parent, MainActivity::class.java)
            parent.startActivity(intent)
            mAuth = Firebase.auth

            parent.finish()
                    } else {

        }

}



}
fun CreateNewUser(context: Context,parent:Activity,Email:String,Password: String){
    Log.d("NewUser","$Email $Password")
    mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener { task ->
        if (task.isSuccessful) {
            val firebaseUser: FirebaseUser = task.result!!.user!!
            Toast.makeText(context, "Account Created", Toast.LENGTH_SHORT).show()
            parent.setResult(222)
            parent.finish()

        } else {
            Toast.makeText(context, "${task.exception} An Error has Occured Please Try Again", Toast.LENGTH_SHORT).show()
        }
    }

}

fun getCurrentUser(): FirebaseUser? {
 return Firebase.auth.currentUser
}


fun Logout(){
    Firebase.auth.signOut()
}



