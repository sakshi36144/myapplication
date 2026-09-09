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
import com.google.android.material.tabs.TabLayout

class TablayoutnavigationEx : AppCompatActivity() {
    private val fragment: Array<Fragment> = arrayOf(chatFragment(),
        callsFragment(), communitiesFragment()
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tablayoutnavigation_ex)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        //creating tabs by without xml

        //create new tab object by tablayout.newTab()
        val tab =tabLayout.newTab()
//        tab.text="Chat"
//       tab.icon =getDrawable(R.drawable.chat)
        tabLayout.addTab(tabLayout.newTab().setText("Chat").setIcon(R.drawable.chat))



        loadFragment(fragment[0])
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
//                when (tab!!.text) {
//                    "Chat" -> loadFragment(com.exmin.myapplication.navFrag.chatFragment())
//                    "Calls" -> loadFragment(com.exmin.myapplication.navFrag.callsFragment())
//                    "Communities" -> loadFragment(com.exmin.myapplication.navFrag.communitiesFragment())
       loadFragment(fragment=fragment[tab!!.position])
                }



            override fun onTabUnselected(p0: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

            override fun onTabReselected(p0: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container_host, fragment)
            .commit()
    }
}