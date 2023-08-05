package com.yakogdan.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            "loaded" -> {
                val percent = intent.getIntExtra("percent", 0)
                Toast.makeText(context, "Loaded $percent%", Toast.LENGTH_SHORT).show()
            }
            ACTION_CLICKED -> {
                val count = intent.getIntExtra(EXTRA_COUNT, 0)
                Toast.makeText(context, "Clicked $count", Toast.LENGTH_SHORT).show()
            }

            Intent.ACTION_BATTERY_LOW -> {
                Toast.makeText(context, "ACTION_BATTERY_LOW", Toast.LENGTH_SHORT).show()
            }

            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                val turnedOn = intent.getBooleanExtra("state", false)
                Toast.makeText(
                    context,
                    "Airplane mode changed. Turned on: $turnedOn",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    companion object {
        const val ACTION_CLICKED = "clicked"
        const val EXTRA_COUNT = "count"
    }
}