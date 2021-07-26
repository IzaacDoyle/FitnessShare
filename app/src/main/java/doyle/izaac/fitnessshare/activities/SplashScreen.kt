package doyle.izaac.fitnessshare.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import doyle.izaac.fitnessshare.R

class SplashScreen: AppCompatActivity() {

    /*
    F_FS_Splash
    S_FS_Splash
    Itness_FS_Splash
    Hare_FS_Splash
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen_fs)



        Handler().postDelayed({
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        },3000)


    }


}