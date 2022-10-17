package com.moessa.openLibrary.module.docs_list.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.moessa.openLibrary.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fl_docs, DocsListFragment.newInstance())
                .commit()
        }
    }
}