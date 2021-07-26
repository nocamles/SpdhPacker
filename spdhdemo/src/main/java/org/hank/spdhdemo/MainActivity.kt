package org.hank.spdhdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.hank.utils.spdh.SpdhUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SpdhUtils.str2Fields("")
    }
}