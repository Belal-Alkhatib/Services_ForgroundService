package com.example.and2_nluc3_forfroundservice

import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.and2_nluc3_forfroundservice.app.MyApp.Companion.CHANNEL_ID

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this,0,
            notificationIntent,0)//  flag: PendingIntent.FLAG_UPDATE_CURRENT  لز كان في بندج انتنت قديمة وغير مستخدمة يستخدمها؛

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("الخدمة الحالية")
            .setContentText("Bilal O Alkhatib")
            .setSmallIcon(R.drawable.ic_notifications_24)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .setPriority(NotificationManager.IMPORTANCE_DEFAULT)
            .build()

        startForeground(1,notification)
        return START_REDELIVER_INTENT
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}