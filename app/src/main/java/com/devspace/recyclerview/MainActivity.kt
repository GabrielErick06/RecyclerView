package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devspace.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Create data class
        //Create list from data class type
        //Set Adapter
        //Linear layout manager

        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val adapter = ContactListAdapter()
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)
        val ivList = findViewById<ImageView>(R.id.iv_list)


        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

        ivGrid.setOnClickListener {
            rvList.layoutManager = GridLayoutManager(this, 2)
        }

        ivList.setOnClickListener {
            rvList.layoutManager = LinearLayoutManager(this)
        }

        adapter.setOnClickListener { contact ->
            val intent = Intent(this, ContactDetailActivity::class.java)
            Log.d("Gabe", contact.toString())
            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("icon", contact.icon)

            startActivity(intent)


        }

    }
}

private val contacts = listOf(
    Contact(
        "Gabriel",
        "(41) 995659986",
        R.drawable.sample2
    ),
    Contact(
        "Anny",
        "(41) 998745454",
        R.drawable.sample3
    ),
    Contact(
        "Guta",
        "(41) 945782356",
        R.drawable.sample5
    ),
    Contact(
        "Thyago",
        "(41) 998563256",
        R.drawable.sample10
    ),
    Contact(
        "Rosana",
        "(41) 997844512",
        R.drawable.sample11
    ),
    Contact(
        "Haroldo",
        "(41) 991256547",
        R.drawable.sample9
    ),
    Contact(
        "Rodrigo",
        "(41) 998742124",
        R.drawable.sample14
    ),
    Contact(
        "Bruna",
        "(41) 998982424",
        R.drawable.sample7
    ),
    Contact(
        "Luiza",
        "(41) 996655959",
        R.drawable.sample4,
    ),
    Contact(
        "Rose",
        "(41) 991515959",
        R.drawable.sample1
    ),
    Contact(
        "Solange",
        "(41) 993536262",
        R.drawable.sample16
    ),
    Contact(
        "Mario",
        "(41) 998256464",
        R.drawable.sample8
    ),
    Contact(
        "Graziele",
        "(41) 995543636",
        R.drawable.sample6
    ),
    Contact(
        "Eloah",
        "(41) 994563232",
        R.drawable.sample11
    ),
    Contact(
        "Silvana",
        "(41) 991593289",
        R.drawable.sample15
    ),
    Contact(
        "Dayana",
        "(41) 997895115",
        R.drawable.sample13
    )

)
