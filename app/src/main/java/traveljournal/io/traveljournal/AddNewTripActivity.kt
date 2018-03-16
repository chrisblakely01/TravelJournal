package traveljournal.io.traveljournal

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import traveljournal.io.traveljournal.R

import kotlinx.android.synthetic.main.activity_add_new_trip.*

class AddNewTripActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_trip)
        setSupportActionBar(toolbar)

        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra("123")

        // Capture the layout's TextView and set the string as its text
        findViewById<TextView>(R.id.extra_message).apply {
            text = message
        }

    }

}
