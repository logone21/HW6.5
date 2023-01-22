package com.example.hw64

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.hw64.databinding.ActivityMainBinding
import com.example.hw64.fragment.FirstFragment
import com.example.hw64.fragment.SecondFragment
import com.example.hw64.fragment.ThirdFragment
import com.example.hw64.ui.MainViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    private val fragmentList= listOf(FirstFragment(), SecondFragment(), ThirdFragment())
    private val fragmetTitles= listOf("First","Second","Result")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val adapter= PagerAdapter(this,fragmentList)

        binding.viewPager.adapter=adapter
        TabLayoutMediator(binding.tabLayout,binding.viewPager){ tab: TabLayout.Tab, i: Int ->
            tab.text = fragmetTitles[i]
        }.attach()
    }
}