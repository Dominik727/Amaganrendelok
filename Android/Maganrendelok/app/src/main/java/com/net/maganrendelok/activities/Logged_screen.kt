package com.net.maganrendelok.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.net.maganrendelok.R


class Logged_screen : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer : DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged_screen)

        val toolbar : android.support.v7.widget.Toolbar = findViewById(R.id.toolbar3)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)

        var navigationView : NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener (this)

        var toogle : ActionBarDrawerToggle = ActionBarDrawerToggle(this, drawer, toolbar,
        R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        drawer.addDrawerListener(toogle)
        toogle.syncState()

        supportFragmentManager.beginTransaction().replace(R.id.fragmant_layout, ListSurgeries()).commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_surgeryes -> supportFragmentManager.beginTransaction().replace(R.id.fragmant_layout,
                    ListSurgeries()).commit()
            R.id.nav_profile -> supportFragmentManager.beginTransaction().replace(R.id.fragmant_layout,
                    fragment_profile()).commit()
            R.id.nav_about -> supportFragmentManager.beginTransaction().replace(R.id.fragmant_layout,
                    fragment_about()).commit()
            R.id.nav_sign_out -> startActivity(Intent(this, LoginActivity::class.java))
            
        }

        drawer.closeDrawer(GravityCompat.START)

        return true
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            val a = Intent(Intent.ACTION_MAIN)
            a.addCategory(Intent.CATEGORY_HOME)
            a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(a)
        }
    }
}
