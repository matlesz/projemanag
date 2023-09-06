package com.projemanag.activities

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.projemanag.R
import com.projemanag.firebase.FirestoreClass
import com.projemanag.model.Board
import com.projemanag.utils.Constants
import kotlinx.android.synthetic.main.activity_task_list.*

class TaskListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_list)

        // TODO (Step 5: Get the board documentId through intent.)
        var boardDocumentId = ""
        if (intent.hasExtra(Constants.DOCUMENT_ID)) {
            boardDocumentId = intent.getStringExtra(Constants.DOCUMENT_ID)!!
        }

        // TODO (Step 10: Call the function to get the Board Details.)
        // START
        // Show the progress dialog.
        showProgressDialog(resources.getString(R.string.please_wait))
        FirestoreClass().getBoardDetails(this@TaskListActivity, boardDocumentId)
        // END
    }

    // TODO (Step 6: Create a function to setup action bar.)
    // START
    /**
     * A function to setup action bar
     */
    private fun setupActionBar(title: String) {

        setSupportActionBar(toolbar_task_list_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
            actionBar.title = title
        }

        toolbar_task_list_activity.setNavigationOnClickListener { onBackPressed() }
    }
    // END

    // TODO (Step 7: Create a function to get the result of Board Detail.)
    // START
    /**
     * A function to get the result of Board Detail.
     */
    fun boardDetails(board: Board) {

        hideProgressDialog()

        // TODO (Step 8: call the setup actionbar function.)
        // START
        // Call the function to setup action bar.
        setupActionBar(board.name)
        // END
    }
    // END
}