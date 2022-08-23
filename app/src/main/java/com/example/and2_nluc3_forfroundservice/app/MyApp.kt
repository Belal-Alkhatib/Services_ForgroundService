package com.example.and2_nluc3_forfroundservice.app

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class MyApp:Application() {
    companion object{
        val CHANNEL_ID = "serviceChannelExample"
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    private fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val serviceChannel = NotificationChannel(CHANNEL_ID,"Example Service Channel",
                NotificationManager.IMPORTANCE_HIGH)

            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(serviceChannel)

            //********** A
            serviceChannel.setShowBadge(true)//لاظهار عدد الاشعارات على ايقونة التطبيق
            serviceChannel.enableVibration(true)//هزاز عند وصول الاشعار
            serviceChannel.enableLights(true)//يعمل الاضاءة عند وصول الاشعار هذا في حال اعطيته اذن

        }
    }
}