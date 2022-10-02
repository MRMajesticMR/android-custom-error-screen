package com.majestic.customerrorscreen

import android.content.Context
import android.content.Intent

class GlobalExceptionHandler private constructor(
    private val applicationContext: Context,
    private val defaultHandler: Thread.UncaughtExceptionHandler,
    private val activityToBeLaunched: Class<*>,
) : Thread.UncaughtExceptionHandler {

    private companion object {

        const val INTENT_DATA_NAME = "INTENT_DATA_NAME"

    }

    override fun uncaughtException(thread: Thread, e: Throwable) {
        try {
            launchActivity(applicationContext, activityToBeLaunched, e)
        } catch (e: Exception) {
            defaultHandler.uncaughtException(thread, e)
        }
    }

    private fun launchActivity(
        applicationContext: Context,
        activity: Class<*>,
        exception: Throwable
    ) {
        val crashedIntent = Intent(applicationContext, activity).also {
            it.putExtra(INTENT_DATA_NAME, exception)
        }

        crashedIntent.addFlags(
            Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_NEW_TASK
        )

        crashedIntent.addFlags(
            Intent.FLAG_ACTIVITY_CLEAR_TASK
        )

        applicationContext.startActivity(crashedIntent)
    }
}