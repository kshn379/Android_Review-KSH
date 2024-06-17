package com.example.android_review02_kshn379

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var inputName: EditText
    private lateinit var inputAddButton: Button
    private lateinit var inputResearch: EditText
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchAdapter: SearchAdapter

    private val itemList = arrayListOf(
        Search(R.drawable.search, "KSH", "anythingType") ,
        Search(R.drawable.search, "MTJ", "somethingType"),
        Search(R.drawable.search, "BDS", "Typing")
    )
    private val displayedItemList = arrayListOf<Search>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputName = findViewById(R.id.input_name)
        inputAddButton = findViewById(R.id.input_add)
        inputResearch = findViewById(R.id.input_research)
        recyclerView = findViewById(R.id.rv_search)
//        searchAdapter = SearchAdapter(displayedItemList)

        }
    }