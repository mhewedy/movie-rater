package com.google.mlkit.vision.demo.processors

import android.app.ListActivity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.mlkit.vision.demo.R


class ExtractedTextActivity : ListActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extracted_text)

        val lines: List<String>? = intent.getStringExtra("TEXT_LINES")?.lines()

        listAdapter = ArrayAdapter(this,
                android.R.layout.simple_list_item_1, lines.orEmpty())
    }

    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        val item = listAdapter.getItem(position) as String
        val browserIntent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/search?q=imdb rating $item"))
        startActivity(browserIntent)

    }
}