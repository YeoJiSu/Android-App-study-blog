package com.example.lab7_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.lab7_3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val datas = mutableListOf<String>()
        for (i in 1..3) {datas.add("Item $i")}

        binding.viewpager.adapter = MyPagerAdapter(datas)
        binding.viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

    }
}