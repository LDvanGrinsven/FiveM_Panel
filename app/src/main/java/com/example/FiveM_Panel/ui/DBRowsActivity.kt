package com.example.FiveM_Panel.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.FiveM_Panel.DBRowsAdapter
import com.example.FiveM_Panel.R
import com.example.FiveM_Panel.database.DBRows
import com.example.FiveM_Panel.database.FiveM
import com.example.FiveM_Panel.database.JDBCControl
import com.example.FiveM_Panel.database.JDBCControl.getConnection
import kotlinx.android.synthetic.main.dbrows_main.*


const val FIVE = "FIVE"
class DBRowsActivity : AppCompatActivity() {

    val rows = arrayListOf<DBRows>()
    var numberOfRows = 0
    private val rowsAdapter = DBRowsAdapter(rows)
    private lateinit var viewModel: DBRowsActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dbrows)
        initViews()
        initViewModel()
        val table = "users"
        val data = intent.getParcelableExtra<FiveM>(FIVE)
        getConnection(data.DBname, table, data.ipaddress, data.username, data.password)
    }
    override fun onBackPressed() {
        val returnIntent = Intent()
        returnIntent.putExtra("hasBackPressed", true)
        setResult(Activity.RESULT_OK, returnIntent)
        JDBCControl.drows.clear()
        finish()
    }
    private fun initViews() {
        // Initialize the recycler view with a linear layout manager, adapter
        rvDBRows.layoutManager =
            LinearLayoutManager(this@DBRowsActivity, RecyclerView.VERTICAL, false)
        rvDBRows.adapter = rowsAdapter
        rvDBRows.addItemDecoration(
            DividerItemDecoration(
                this@DBRowsActivity,
                DividerItemDecoration.VERTICAL
            )
        )
        initViewModel()
    }
    fun initViewModel() {
        viewModel = ViewModelProvider (this).get(DBRowsActivityViewModel::class.java)

        viewModel.rowsitems.observe(this, Observer {
            rows.clear()
            rows.addAll(it)
            rowsAdapter.notifyDataSetChanged()
        })
    }
}
