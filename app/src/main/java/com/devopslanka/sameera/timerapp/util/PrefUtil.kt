package com.devopslanka.sameera.timerapp.util

import android.content.Context
import android.preference.PreferenceManager
import com.devopslanka.sameera.timerapp.TimerActivity

class PrefUtil {
    //    similar to static members in java or c#
    companion object {

        private const val TIMER_LENGTH_ID = "com.devopslanka.sameera.timerapp.timer_length"
        fun getTimerLength(context: Context): Int {
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getInt(TIMER_LENGTH_ID, 10)
        }


        private const val PREVIOUS_TIMER_LENGTH_SECONDS_ID = "com.devopslanka.sameera.timerapp.previous_timer_length"

        //accept context and is gonna return Long
        fun getPreviousTimerLengthSeconds(context: Context): Long {
            val preferances = PreferenceManager.getDefaultSharedPreferences(context)
            return preferances.getLong(PREVIOUS_TIMER_LENGTH_SECONDS_ID, 0)
        }

        fun setPreviousTimerLengthSeconds(seconds: Long, context: Context) {
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putLong(PREVIOUS_TIMER_LENGTH_SECONDS_ID, seconds)
            editor.apply()
        }

        private const val TIMER_STATE_ID = "com.devopslanka.sameera.timerapp.timer_state"
        fun getTimerState(context: Context): TimerActivity.TimerState {
            val preferances = PreferenceManager.getDefaultSharedPreferences(context)
            val ordinal = preferances.getInt(TIMER_STATE_ID, 0)
            return TimerActivity.TimerState.values()[ordinal]
        }

        fun setTimerState(state: TimerActivity.TimerState, context: Context) {
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            val ordinal = state.ordinal
            editor.putInt(TIMER_STATE_ID, ordinal)
            editor.apply()
        }

        private const val SECONDS_REMANING_ID = "com.devopslanka.sameera.timerapp.seconds_remaning"

        //accept context and is gonna return Long
        fun getSecondsRemaning(context: Context): Long {
            val preferances = PreferenceManager.getDefaultSharedPreferences(context)
            return preferances.getLong(SECONDS_REMANING_ID, 0)
        }

        fun setSecondsRemaning(seconds: Long, context: Context) {
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putLong(SECONDS_REMANING_ID, seconds)
            editor.apply()
        }

        private const val ALARM_SET_TIME_ID = "com.devopslanka.sameera.timerapp.backgrounded_time"

        fun getAlarmSetTime(context: Context): Long {
            val preferances = PreferenceManager.getDefaultSharedPreferences(context)
            return preferances.getLong(ALARM_SET_TIME_ID, 0)


        }

        fun setAlarmSetTime(time: Long, context: Context) {
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putLong(ALARM_SET_TIME_ID, time)
            editor.apply()
        }
    }
}