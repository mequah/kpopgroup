package com.example.kpopgroup

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat

class DescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        // Mendapatkan data dari Intent
        val groupName = intent.getStringExtra("groupName")
        val groupFullName = intent.getStringExtra("groupFullName")
        val groupFandom = intent.getStringExtra("groupFandom")
        val groupImageResId = intent.getIntExtra("groupImageResId", 0)
        val groupDescription = intent.getStringExtra("groupDescription")

        // Mengatur data ke tampilan
        val imageView: ImageView = findViewById(R.id.groupImage)
        imageView.setImageResource(groupImageResId)

        val groupNameTextView: TextView = findViewById(R.id.groupName)
        groupNameTextView.text = groupName

        val groupFullNameTextView: TextView = findViewById(R.id.groupFullName)
        groupFullNameTextView.text = groupFullName

        val groupFandomTextView: TextView = findViewById(R.id.groupFandom)
        groupFandomTextView.text = groupFandom

        val groupDescriptionTextView: TextView = findViewById(R.id.groupDescription)
        groupDescriptionTextView.text = groupDescription
    }
}

