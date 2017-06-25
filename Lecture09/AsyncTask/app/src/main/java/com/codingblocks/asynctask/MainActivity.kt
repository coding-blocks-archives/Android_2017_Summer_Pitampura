package com.codingblocks.asynctask

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*;


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {
            // wait 10 sec
            // tvResult.setText("DONE");
            val myTask = NSecWaitTask(tvResult)

            myTask.execute(Integer.valueOf(etWaitTime.text.toString()))
        }
        button2.setOnClickListener {
            tvResult.text = "SOME TEXT";

            var myStr: String = tvResult.text as String;
        }

    }

    companion object {
        val TAG = "ASYNC"
    }


}
