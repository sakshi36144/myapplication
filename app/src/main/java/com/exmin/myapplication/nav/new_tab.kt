package com.exmin.myapplication.nav

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.exmin.myapplication.R
import com.exmin.myapplication.navFrag.callsFragment
import com.exmin.myapplication.navFrag.chatFragment
import com.exmin.myapplication.navFrag.communitiesFragment

class new_tab : AppCompatActivity() {
    private val fragments: Array<Fragment> = arrayOf(
        chatFragment(),
        callsFragment(), communitiesFragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_new_tab)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val One = findViewById<TextView>(R.id.one)
        val Two = findViewById<TextView>(R.id.two)
        val Three = findViewById<TextView>(R.id.three)
        loadFragment(fragments[0]) // Load the first fragment by default

        One.setOnClickListener {
            loadFragment(fragments[0])
        }
        Two.setOnClickListener {
            loadFragment(fragments[1])
        }
        Three.setOnClickListener {
            loadFragment(fragments[2])
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .commit()
    }
}

