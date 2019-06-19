package ru.hunkel.servicesipc.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import ru.hunkel.servicesipc.services.impl.PasswordGeneratorImpl

class PasswordGeneratorService : Service() {

    private val TAG = this::class.java.simpleName
    private var service: PasswordGeneratorImpl? = null

    override fun onCreate() {
        super.onCreate()
        service = PasswordGeneratorImpl()
        Log.d(TAG, "onCreate")
    }

    //This method called if service started with startService() command
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand")

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder {
        Log.d(TAG, "onBind")
        if (service == null) {
            service = PasswordGeneratorImpl()
        }
        return service!!
    }

    override fun onRebind(intent: Intent?) {
        Log.d(TAG, "onReBind")
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(TAG, "onUnbind")
        return false
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        System.exit(1)
        stopSelf()
    }
}
