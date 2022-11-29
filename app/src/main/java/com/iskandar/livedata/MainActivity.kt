package com.iskandar.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iskandar.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myRvAdapter: MyRvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myRvAdapter = MyRvAdapter(this)

        binding.viewpager.adapter = myRvAdapter

    }
}