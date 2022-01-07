package com.moussa.cinemaapp

import android.R
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.squareup.picasso.Picasso
import java.util.ArrayList

class Act1 : AppCompatActivity() {
    var searchView: SearchView? = null
    var movie1ImageView: ImageView? = null
    var movie2ImageView: ImageView? = null
    var movie3ImageView: ImageView? = null
    var movie4ImageView: ImageView? = null
    var movie5ImageView: ImageView? = null
    var movie6ImageView: ImageView? = null
    var movie7ImageView: ImageView? = null
    var movie8ImageView: ImageView? = null
    var movie9ImageView: ImageView? = null
    var movieTextView1: TextView? = null
    var movieTextView2: TextView? = null
    var movieTextView3: TextView? = null
    var movieTextView4: TextView? = null
    var movieTextView5: TextView? = null
    var movieTextView6: TextView? = null
    var movieTextView7: TextView? = null
    var movieTextView8: TextView? = null
    var movieTextView9: TextView? = null
    var titlesListView: ListView? = null
    var titles = ArrayList<String>()
    var arrayAdapter: ArrayAdapter<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.moussa.cinemaapp.R.layout.activity_act1)
        val actionBar = supportActionBar
        // changing color of action bar
        val colorDrawable = ColorDrawable(Color.parseColor("#0000FF"))
        actionBar!!.setBackgroundDrawable(colorDrawable)
        title = "Cinema"
        movie1ImageView = findViewById(com.moussa.cinemaapp.R.id.movie1ImageView)
        movie2ImageView = findViewById(com.moussa.cinemaapp.R.id.movie2ImageView)
        movie3ImageView = findViewById(com.moussa.cinemaapp.R.id.movie3ImageView)
        movie4ImageView = findViewById(com.moussa.cinemaapp.R.id.movie4ImageView)
        movie5ImageView = findViewById(com.moussa.cinemaapp.R.id.movie5ImageView)
        movie6ImageView = findViewById(com.moussa.cinemaapp.R.id.movie6ImageView)
        movie7ImageView = findViewById(com.moussa.cinemaapp.R.id.movie7ImageView)
        movie8ImageView = findViewById(com.moussa.cinemaapp.R.id.movie8ImageView)
        movie9ImageView = findViewById(com.moussa.cinemaapp.R.id.movie9ImageView)
        movieTextView1 = findViewById(com.moussa.cinemaapp.R.id.movieTextView1)
        movieTextView2 = findViewById(com.moussa.cinemaapp.R.id.movieTextView2)
        movieTextView3 = findViewById(com.moussa.cinemaapp.R.id.movieTextView3)
        movieTextView4 = findViewById(com.moussa.cinemaapp.R.id.movieTextView4)
        movieTextView5 = findViewById(com.moussa.cinemaapp.R.id.movieTextView5)
        movieTextView6 = findViewById(com.moussa.cinemaapp.R.id.movieTextView6)
        movieTextView7 = findViewById(com.moussa.cinemaapp.R.id.movieTextView7)
        movieTextView8 = findViewById(com.moussa.cinemaapp.R.id.movieTextView8)
        movieTextView9 = findViewById(com.moussa.cinemaapp.R.id.movieTextView9)
        titlesListView = findViewById(com.moussa.cinemaapp.R.id.titlesListView)
        val movieInfoIntent = Intent(this@Act1, MovieDetail::class.java)
        arrayAdapter = ArrayAdapter(this, R.layout.simple_list_item_1, titles)
        searchView = findViewById(com.moussa.cinemaapp.R.id.searchView)
        searchView?.onActionViewCollapsed()
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                return false
            }

            override fun onQueryTextChange(s: String): Boolean {
                titlesListView?.setAdapter(arrayAdapter)
                arrayAdapter!!.filter.filter(s)
                arrayAdapter!!.notifyDataSetChanged()
                return false
            }
        })
        titlesListView?.setOnItemClickListener(OnItemClickListener { adapterView, view, i, l ->
            movieInfoIntent.putExtra("title", arrayAdapter!!.getItem(i))
            startActivity(movieInfoIntent)
        })

        firebase()

        movie1ImageView?.setOnClickListener(View.OnClickListener {
            movieInfoIntent.putExtra("title", movieTextView1?.getText().toString())
            startActivity(movieInfoIntent)
        })
        movie2ImageView?.setOnClickListener(View.OnClickListener {
            movieInfoIntent.putExtra("title", movieTextView2?.getText().toString())
            startActivity(movieInfoIntent)
        })
        movie3ImageView?.setOnClickListener(View.OnClickListener {
            movieInfoIntent.putExtra("title", movieTextView3?.getText().toString())
            startActivity(movieInfoIntent)
        })
        movie4ImageView?.setOnClickListener(View.OnClickListener {
            movieInfoIntent.putExtra("title", movieTextView4?.getText().toString())
            startActivity(movieInfoIntent)
        })
        movie5ImageView?.setOnClickListener(View.OnClickListener {
            movieInfoIntent.putExtra("title", movieTextView5?.getText().toString())
            startActivity(movieInfoIntent)
        })
        movie6ImageView?.setOnClickListener(View.OnClickListener {
            movieInfoIntent.putExtra("title", movieTextView6?.getText().toString())
            startActivity(movieInfoIntent)
        })
        movie7ImageView?.setOnClickListener(View.OnClickListener {
            movieInfoIntent.putExtra("title", movieTextView7?.getText().toString())
            startActivity(movieInfoIntent)
        })
        movie8ImageView?.setOnClickListener(View.OnClickListener {
            movieInfoIntent.putExtra("title", movieTextView8?.getText().toString())
            startActivity(movieInfoIntent)
        })
        movie9ImageView?.setOnClickListener(View.OnClickListener {
            movieInfoIntent.putExtra("title", movieTextView9?.getText().toString())
            startActivity(movieInfoIntent)
        })
    }

    fun firebase() {
        FirebaseFirestore.getInstance().collection("movies")
            .document("movie1").addSnapshotListener(object : EventListener<DocumentSnapshot?> {
                override fun onEvent(value: DocumentSnapshot?, error: FirebaseFirestoreException?) {
                    val title: String = value?.get("title").toString()
                    val poster: String = value?.get("poster").toString()
                    Picasso.get().load(poster).into(movie1ImageView)
                    movieTextView1!!.text = title
                    titles.add(title)
                }
            })
        FirebaseFirestore.getInstance().collection("movies")
            .document("movie2").addSnapshotListener(object : EventListener<DocumentSnapshot?> {
                override fun onEvent(value: DocumentSnapshot?, error: FirebaseFirestoreException?) {
                    val title: String = value?.get("title").toString()
                    val poster: String = value?.get("poster").toString()
                    Picasso.get().load(poster).into(movie2ImageView)
                    movieTextView2!!.text = title
                    titles.add(title)
                }
            })
        FirebaseFirestore.getInstance().collection("movies")
            .document("movie3").addSnapshotListener(object : EventListener<DocumentSnapshot?> {
                override fun onEvent(value: DocumentSnapshot?, error: FirebaseFirestoreException?) {
                    val title: String = value?.get("title").toString()
                    val poster: String = value?.get("poster").toString()
                    Picasso.get().load(poster).into(movie3ImageView)
                    movieTextView3!!.text = title
                    titles.add(title)
                }
            })
        FirebaseFirestore.getInstance().collection("movies")
            .document("movie4").addSnapshotListener(object : EventListener<DocumentSnapshot?> {
                override fun onEvent(value: DocumentSnapshot?, error: FirebaseFirestoreException?) {
                    val title: String = value?.get("title").toString()
                    val poster: String = value?.get("poster").toString()
                    Picasso.get().load(poster).into(movie4ImageView)
                    movieTextView4!!.text = title
                    titles.add(title)
                }
            })
        FirebaseFirestore.getInstance().collection("movies")
            .document("movie5").addSnapshotListener(object : EventListener<DocumentSnapshot?> {
                override fun onEvent(value: DocumentSnapshot?, error: FirebaseFirestoreException?) {
                    val title: String = value?.get("title").toString()
                    val poster: String = value?.get("poster").toString()
                    Picasso.get().load(poster).into(movie5ImageView)
                    movieTextView5!!.text = title
                    titles.add(title)
                }
            })
        FirebaseFirestore.getInstance().collection("movies")
            .document("movie6").addSnapshotListener(object : EventListener<DocumentSnapshot?> {
                override fun onEvent(value: DocumentSnapshot?, error: FirebaseFirestoreException?) {
                    val title: String = value?.get("title").toString()
                    val poster: String = value?.get("poster").toString()
                    Picasso.get().load(poster).into(movie6ImageView)
                    movieTextView6!!.text = title
                    titles.add(title)
                }
            })
        FirebaseFirestore.getInstance().collection("movies")
            .document("movie7").addSnapshotListener(object : EventListener<DocumentSnapshot?> {
                override fun onEvent(value: DocumentSnapshot?, error: FirebaseFirestoreException?) {
                    val title: String = value?.get("title").toString()
                    val poster: String = value?.get("poster").toString()
                    Picasso.get().load(poster).into(movie7ImageView)
                    movieTextView7!!.text = title
                    titles.add(title)
                }
            })
        FirebaseFirestore.getInstance().collection("movies")
            .document("movie8").addSnapshotListener(object : EventListener<DocumentSnapshot?> {
                override fun onEvent(value: DocumentSnapshot?, error: FirebaseFirestoreException?) {
                    val title: String = value?.get("title").toString()
                    val poster: String = value?.get("poster").toString()
                    Picasso.get().load(poster).into(movie8ImageView)
                    movieTextView8!!.text = title
                    titles.add(title)
                }
            })
        FirebaseFirestore.getInstance().collection("movies")
            .document("movie9").addSnapshotListener(object : EventListener<DocumentSnapshot?> {
                override fun onEvent(value: DocumentSnapshot?, error: FirebaseFirestoreException?) {
                    val title: String = value?.get("title").toString()
                    val poster: String = value?.get("poster").toString()
                    Picasso.get().load(poster).into(movie9ImageView)
                    movieTextView9!!.text = title
                    titles.add(title)
                }
            })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(com.moussa.cinemaapp.R.menu.about_us_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            com.moussa.cinemaapp.R.id.AboutUs -> {
                val intent = Intent(this@Act1, MapsActivity::class.java)
                startActivity(intent)
                return true
            }
            com.moussa.cinemaapp.R.id.Profile -> {
                val intent = Intent(this@Act1, ProfileActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}