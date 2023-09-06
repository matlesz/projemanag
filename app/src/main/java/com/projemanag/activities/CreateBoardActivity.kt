package com.projemanag.activities

import android.os.Bundle
import com.projemanag.R
import kotlinx.android.synthetic.main.activity_create_board.*

// TODO (Step 2: Create a CreateBoardActivity.)
// START
class CreateBoardActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_board)

        // TODO (Step 8: Call the setup action bar function)
        setupActionBar()
    }

    // TODO (Step 7: Create a function to setup action bar.)
    // START
    /**
     * A function to setup action bar
     */
    private fun setupActionBar() {

        setSupportActionBar(toolbar_create_board_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
        }

        toolbar_create_board_activity.setNavigationOnClickListener { onBackPressed() }
    }
    // END
}
// END