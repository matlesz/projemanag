package com.projemanag.activities

import android.os.Bundle
import com.projemanag.R
import com.projemanag.model.Board
import com.projemanag.utils.Constants
import kotlinx.android.synthetic.main.activity_members.*

class MembersActivity : BaseActivity() {

    // TODO (Step 3: Create a global variable for Board Details.)
    // START
    // A global variable for Board Details.
    private lateinit var mBoardDetails: Board
    // END

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_members)

        // TODO (Step 4: Get the Board Details through intent and assign it to the global variable.)
        // START
        if (intent.hasExtra(Constants.BOARD_DETAIL)) {
            mBoardDetails = intent.getParcelableExtra<Board>(Constants.BOARD_DETAIL)!!
        }
        // END

        // TODO (Step 6: Call the setup action bar function.)
        // START
        setupActionBar()
        // END
    }

    // TODO (Step 5: Create a function to setup action bar.)
    // START
    /**
     * A function to setup action bar
     */
    private fun setupActionBar() {

        setSupportActionBar(toolbar_members_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
        }

        toolbar_members_activity.setNavigationOnClickListener { onBackPressed() }
    }
    // END
}