package traveljournal.io.traveljournal

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
import traveljournal.io.traveljournal.src.TripsViewAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        viewManager = LinearLayoutManager(this)
        viewAdapter = TripsViewAdapter(getData())

        /* TODO investigate how to handle clicking of adapter items.
           would rather now have the adapter have the responsibility
           of starting new intents/activities
        */

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }

        fab.setOnClickListener { view ->
            /** Called when the user taps the Send button */
            //val editText = findViewById<EditText>(R.id.editText)
            //val message = editText.text.toString()
            val intent = Intent(this, AddNewTripActivity::class.java).apply {
                putExtra("123", "this is some extra stuff")
            }
            startActivity(intent)
        }


    }


    //TODO replce this with real data sourcex
    private fun getData():List<String>{

        return listOf("Switzerland", "Prague", "Lisbon", "Paris")

    }

}
