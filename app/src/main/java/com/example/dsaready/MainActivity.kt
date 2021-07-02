package com.example.dsaready

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.dsaready.databinding.ActivityMainBinding
import com.example.dsaready.ui.AboutActivity
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        toggle= ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navView.itemIconTintList = null
        binding.navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.shareApp ->{

                    var unicode = 0x1F600
                    var shareMessage=StringBuilder()
                    shareMessage.append("Hi! Get Data Structures and Algorithms ready with DSA Ready ");
                    shareMessage.append(Character.toChars(unicode));
                    shareMessage.append("\n https://github.com/gopal326/DSA-Ready")

                    val shareIntent = Intent()
                    shareIntent.action = Intent.ACTION_SEND
                    shareIntent.type="text/plain"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage.toString());
                    startActivity(Intent.createChooser(shareIntent, "send to"))
                }

                R.id.aboutApp ->{
                    val intent = Intent(this, AboutActivity::class.java)
                    startActivity(intent)
                }

//                R.id.rateApp ->{
//                    val intent = Intent(this,RateActivity::class.java)
//                    startActivity(intent)
//                }
            }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}