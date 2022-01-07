package com.moussa.cinemaapp

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class LastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last)

        val actionBar = supportActionBar
        // changing color of action bar
        val colorDrawable = ColorDrawable(Color.parseColor("#0000FF"))
        actionBar!!.setBackgroundDrawable(colorDrawable)
        actionBar.setDisplayHomeAsUpEnabled(true)
        title = "Confirmation"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}