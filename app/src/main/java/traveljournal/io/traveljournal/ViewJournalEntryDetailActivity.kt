package traveljournal.io.traveljournal

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_view_journal_entry_detail.*

class ViewJournalEntryDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_journal_entry_detail)
        setSupportActionBar(toolbar)
        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra("123")

        // Capture the layout's TextView and set the string as its text
        findViewById<TextView>(R.id.extra_message).apply {
            text = message
        }
    }

}
