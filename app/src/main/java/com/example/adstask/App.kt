package com.example.adstask

import android.app.Application
import com.rad.RXError
import com.rad.RXSDK
import com.rad.rcommonlib.utils.RXLogUtil

class App : Application() {
    override fun onCreate() {
        super.onCreate()
//        RXSDK.setGDPRAuth(true)
        RXSDK.init("261", object : RXSDK.RXSDKInitListener {
            override fun onSDKInitFailure(error: RXError) {
                RXLogUtil.d("onSDKInitFailure ", error.msg)
            }

            override fun onSDKInitSuccess() {
                RXLogUtil.d("onSDKInitSuccess")

            }

        })
    }
}