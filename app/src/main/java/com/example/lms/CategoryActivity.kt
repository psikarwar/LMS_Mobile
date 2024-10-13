package com.example.lms

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lms.databinding.ActivityCategoryBinding
import com.google.android.material.tabs.TabLayoutMediator

class CategoryActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCategoryBinding
    private lateinit var adapter: ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        adapter.addFragment(AllCoursesFragment(), "All")
        adapter.addFragment(AllCoursesFragment(), "Favourite")
        adapter.addFragment(AllCoursesFragment(), "Recommended")

        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = adapter.getPageTitle(position)
        }.attach()

//        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab) {
//                // Handle tab selection
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab) {
//                // Handle tab unSelection
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab) {
//                // Handle tab reselection
//            }
//        })
    }
}