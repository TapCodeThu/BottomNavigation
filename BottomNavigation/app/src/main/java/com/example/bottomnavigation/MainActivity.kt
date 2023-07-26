package com.example.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener {menuItem->
            when(menuItem.itemId){
                R.id.bottom_home->{
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.bottom_search->{
                    replaceFragment(SearchFragment())
                    true
                }
                R.id.bottom_add->{
                    Toast.makeText(this,"Upload image.",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.bottom_person->{
                    replaceFragment(PersonFragment())
                    true
                }
                else -> false
            }

        }
        replaceFragment(HomeFragment())

    }
    private fun replaceFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_container,fragment).commit()
    }
}