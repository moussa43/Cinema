package com.moussa.cinemaapp

import android.R
import android.content.Intent
import android.graphics.Color
import android.graphics.Color.red
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.squareup.picasso.Picasso
import java.lang.Exception
import android.graphics.Color.red
import com.google.firebase.firestore.EventListener

class MovieDetail : AppCompatActivity() {
    var titleTextView: TextView? = null
    var plotTextView: TextView? = null
    var date1TextView: TextView? = null
    var date5TextView: TextView? = null
    var date2TextView: TextView? = null
    var date3TextView: TextView? = null
    var date4TextView: TextView? = null
    var jour1TextView: TextView? = null
    var jour2TextView: TextView? = null
    var jour3TextView: TextView? = null
    var jour4TextView: TextView? = null
    var jour5TextView: TextView? = null
    var h1TextView: TextView? = null
    var h2TextView: TextView? = null
    var h3TextView: TextView? = null
    var h4TextView: TextView? = null
    var h5TextView: TextView? = null
    var h6TextView: TextView? = null
    var h7TextView: TextView? = null
    var h8TextView: TextView? = null
    var h9TextView: TextView? = null
    var movieImageView: ImageView? = null
    var reserveButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.moussa.cinemaapp.R.layout.activity_movie_detail)
        val actionBar = supportActionBar
        // changing color of action bar
        val colorDrawable = ColorDrawable(Color.parseColor("#0000FF"))
        actionBar!!.setBackgroundDrawable(colorDrawable)
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.hide()
        title = "Movie Information"
        titleTextView = findViewById(com.moussa.cinemaapp.R.id.titleTextView)
        movieImageView = findViewById(com.moussa.cinemaapp.R.id.movieImageView)
        plotTextView = findViewById(com.moussa.cinemaapp.R.id.plotTextView)
        date1TextView = findViewById(com.moussa.cinemaapp.R.id.date1TextView)
        jour1TextView = findViewById(com.moussa.cinemaapp.R.id.jour1TextView)
        date2TextView = findViewById(com.moussa.cinemaapp.R.id.date2TextView)
        date3TextView = findViewById(com.moussa.cinemaapp.R.id.date3TextView)
        date4TextView = findViewById(com.moussa.cinemaapp.R.id.date4TextView)
        date5TextView = findViewById(com.moussa.cinemaapp.R.id.date5TextView)
        jour2TextView = findViewById(com.moussa.cinemaapp.R.id.jour2TextView)
        jour3TextView = findViewById(com.moussa.cinemaapp.R.id.jour3TextView)
        jour4TextView = findViewById(com.moussa.cinemaapp.R.id.jour4TextView)
        jour5TextView = findViewById(com.moussa.cinemaapp.R.id.jour5TextView)
        h1TextView = findViewById(com.moussa.cinemaapp.R.id.h1TextView)
        h2TextView = findViewById(com.moussa.cinemaapp.R.id.h2TextView)
        h3TextView = findViewById(com.moussa.cinemaapp.R.id.h3TextView)
        h4TextView = findViewById(com.moussa.cinemaapp.R.id.h4TextView)
        h5TextView = findViewById(com.moussa.cinemaapp.R.id.h5TextView)
        h6TextView = findViewById(com.moussa.cinemaapp.R.id.h6TextView)
        h7TextView = findViewById(com.moussa.cinemaapp.R.id.h7TextView)
        h8TextView = findViewById(com.moussa.cinemaapp.R.id.h8TextView)
        h9TextView = findViewById(com.moussa.cinemaapp.R.id.h9TextView)
        reserveButton = findViewById(com.moussa.cinemaapp.R.id.reserveButton)
        choixDates()
        choixHeures()
        reserveButton?.setOnClickListener(View.OnClickListener {
            val getReceipt = Intent(applicationContext, LastActivity::class.java)
            startActivity(getReceipt)
        })

        val intent = intent
        Log.i("TITLEINTEnT", intent.getStringExtra("title")!!)
        titleTextView?.setText(intent.getStringExtra("title"))

        FirebaseFirestore.getInstance().collection("titles")
            .document(titleTextView?.getText().toString()).addSnapshotListener(object : EventListener<DocumentSnapshot?> {
                override fun onEvent(value: DocumentSnapshot?, error: FirebaseFirestoreException?) {
                    val poster: String = value?.get("poster").toString()
                    val plot: String = value?.get("plot").toString()
                    Picasso.get().load(poster).into(movieImageView)
                    plotTextView?.setText(plot)
                }
            })

    }

    fun choixDates() {
        date1TextView!!.setOnClickListener {
            date1TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            jour1TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            date2TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            jour2TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            date3TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            jour3TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            date4TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            jour4TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            date5TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            jour5TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
        }
        jour1TextView!!.setOnClickListener {
            date1TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            jour1TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            date2TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour2TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date3TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour3TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date4TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour4TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date5TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour5TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
        }
        date2TextView!!.setOnClickListener {
            date2TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            jour2TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            date1TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour1TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date3TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour3TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date4TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour4TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date5TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour5TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
        }
        jour2TextView!!.setOnClickListener {
            date2TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            jour2TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            date3TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour3TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date1TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour1TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date4TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour4TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date5TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour5TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
        }
        date3TextView!!.setOnClickListener {
            date3TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            jour3TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            date2TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour2TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date1TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour1TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date4TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour4TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date5TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour5TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
        }
        jour3TextView!!.setOnClickListener {
            date3TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            jour3TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            date2TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour2TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date1TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour1TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date4TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour4TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date5TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour5TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
        }
        date4TextView!!.setOnClickListener {
            date4TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            jour4TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            date2TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour2TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date3TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour3TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date1TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour1TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date5TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour5TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
        }
        jour4TextView!!.setOnClickListener {
            date4TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            jour4TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            date2TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour2TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date3TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour3TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date1TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour1TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date5TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour5TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
        }
        date5TextView!!.setOnClickListener {
            date5TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            jour5TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            date2TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour2TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date3TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour3TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date4TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour4TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date1TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour1TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
        }
        jour5TextView!!.setOnClickListener {
            date5TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            jour5TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            date2TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour2TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date3TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour3TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date4TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour4TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            date1TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
            jour1TextView!!.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.black
                )
            )
        }
    }

    fun choixHeures() {
        h1TextView!!.setOnClickListener {
            h1TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            h2TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h3TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h4TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h5TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h6TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h7TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h8TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h9TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
        }
        h2TextView!!.setOnClickListener {
            h2TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            h1TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h3TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h4TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h5TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h6TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h7TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h8TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h9TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
        }
        h3TextView!!.setOnClickListener {
            h3TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            h2TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h1TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h4TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h5TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h6TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h7TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h8TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h9TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
        }
        h4TextView!!.setOnClickListener {
            h4TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            h2TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h3TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h1TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h5TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h6TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h7TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h8TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h9TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
        }
        h5TextView!!.setOnClickListener {
            h5TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            h2TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h3TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h4TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h1TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h6TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h7TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h8TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h9TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
        }
        h6TextView!!.setOnClickListener {
            h6TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            h2TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h3TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h4TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h1TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h5TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h7TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h8TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h9TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
        }
        h7TextView!!.setOnClickListener {
            h7TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            h2TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h3TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h4TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h1TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h6TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h5TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h8TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h9TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
        }
        h8TextView!!.setOnClickListener {
            h8TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            h2TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h3TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h4TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h1TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h6TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h7TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h5TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h9TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
        }
        h9TextView!!.setOnClickListener {
            h9TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.holo_red_light))
            h2TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h3TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h4TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h1TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h6TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h7TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h8TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
            h5TextView!!.setTextColor(ContextCompat.getColor(applicationContext, R.color.black))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}