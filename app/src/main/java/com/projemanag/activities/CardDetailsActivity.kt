package com.projemanag.activities

import android.os.Bundle
import com.projemanag.R
import com.projemanag.model.Board
import com.projemanag.model.Card
import com.projemanag.utils.Constants
import kotlinx.android.synthetic.main.activity_card_details.*

class CardDetailsActivity : BaseActivity() {

    // TODO (Step 5: Create all the global variables to get all the data that is sent through intent and use them further as per requirement.)
    // START
    // A global variable for board details
    private lateinit var mBoardDetails: Board
    // A global variable for task item position
    private var mTaskListPosition: Int = -1
    // A global variable for card item position
    private var mCardPosition: Int = -1
    // END

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_details)

        // TODO (Step 7: Call the getIntentData function here.)
        // START
        getIntentData()
        // END

        // TODO (Step 2: Call the setup action bar function here.)
        // START
        setupActionBar()
        // END
    }

    // TODO (Step 1: Create a function to setup actionBar.)
    // START
    /**
     * A function to setup action bar
     */
    private fun setupActionBar() {

        setSupportActionBar(toolbar_card_details_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
            // TODO (Step 8: Set the title of action bar.)
            // START
            actionBar.title = mBoardDetails.taskList[mTaskListPosition].cards[mCardPosition].name
            // END
        }

        toolbar_card_details_activity.setNavigationOnClickListener { onBackPressed() }
    }
    // END

    // TODO (Step 6: Create a function to get all the data that is sent through intent.)
    // START
    // A function to get all the data that is sent through intent.
    private fun getIntentData() {

        if (intent.hasExtra(Constants.BOARD_DETAIL)) {
            mBoardDetails = intent.getParcelableExtra(Constants.BOARD_DETAIL) as Board
        }
        if (intent.hasExtra(Constants.TASK_LIST_ITEM_POSITION)) {
            mTaskListPosition = intent.getIntExtra(Constants.TASK_LIST_ITEM_POSITION, -1)
        }
        if (intent.hasExtra(Constants.CARD_LIST_ITEM_POSITION)) {
            mCardPosition = intent.getIntExtra(Constants.CARD_LIST_ITEM_POSITION, -1)
        }
    }
    // END
}