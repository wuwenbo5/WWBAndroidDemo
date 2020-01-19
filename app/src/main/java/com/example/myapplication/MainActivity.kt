package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.example.myapplication.anim.AnimActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,View.OnClickListener{


    override fun onClick(view: View?) {
        var id = view?.id
        when (id) {
            R.id.btn_one -> {
                Log.e(TAG,"--------------click btn one")
                startActivity( Intent(application,ExampActivity::class.java))
            }
            R.id.btn_two -> {
                Log.e(TAG,"--------------click btn two")
            }
            R.id.btn_object_anim -> {
                startActivity( Intent(application, AnimActivity::class.java))
            }
        }
    }

    private val TAG = javaClass.simpleName;
    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                textMessage.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                textMessage.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                textMessage.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        btn_one.setOnClickListener(this)
        btn_two.setOnClickListener (this)
        btn_object_anim.setOnClickListener (this)
    }
}
