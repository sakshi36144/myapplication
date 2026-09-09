package com.exmin.myapplication.nav

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.exmin.myapplication.R
import com.exmin.myapplication.navFrag.callsFragment
import com.exmin.myapplication.navFrag.chatFragment
import com.exmin.myapplication.navFrag.communitiesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigation : AppCompatActivity() {
    private val fragments: Array<Fragment> = arrayOf(
        chatFragment(),
        callsFragment(), communitiesFragment()
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bottom_navigation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomnavigation)
        //load default fragment
        loadFragment(fragments[0])
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.btn_item -> {
                    loadFragment(fragments[0])
                    true
                }
                R.id.call -> {
                    loadFragment(fragments[1])
                    true
                }
                R.id.btn_update -> {
                    loadFragment(fragments[2])
                    true
                }
                else -> false
            }
        }

    }
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.btmnavigation, fragment)
            .commit()
    }
}