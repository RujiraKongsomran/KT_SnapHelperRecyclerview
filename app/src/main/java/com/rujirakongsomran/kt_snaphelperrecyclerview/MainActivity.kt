package com.rujirakongsomran.kt_snaphelperrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper
import com.rujirakongsomran.kt_snaphelperrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val nounList = generateDummyList(500)
        val snapHelper = GravitySnapHelper(Gravity.TOP)
        snapHelper.attachToRecyclerView(binding.recyclerview)
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = NounAdapter(nounList)
        binding.recyclerview.setHasFixedSize(true)

    }

    private fun generateDummyList(size: Int): List<NounItem> {

        val list = ArrayList<NounItem>()

        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_basketball
                1 -> R.drawable.ic_bicycle
                else -> R.drawable.ic_cake
            }
            val item = NounItem(
                drawable,
                "Item $i",
                "Line 2"
            )
            list.add(item)
        }
        return list
    }
}