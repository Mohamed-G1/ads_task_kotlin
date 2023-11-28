package com.example.adstask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import com.gamify.space.Gamify
import com.gamify.space.GamifyError
import com.rad.RXError
import com.rad.RXSDK
import com.rad.out.RXAdInfo
import com.rad.out.RXSdkAd
import com.rad.out.banner.RXBannerAd
import com.rad.out.banner.RXBannerEventListener
import com.rad.out.interstitial.RXInterstitialAd
import com.rad.out.interstitial.RXInterstitialEventListener
import com.rad.out.nativead.RXNativeAd
import com.rad.out.nativead.RXNativeEventListener
import com.rad.out.reward.RXRewardVideoAd
import com.rad.out.reward.RXRewardVideoEventListener
import com.rad.out.splash.RXSplashAd
import com.rad.out.splash.RXSplashEventListener
import com.rad.rcommonlib.glide.load.model.stream.HttpGlideUrlLoader.TIMEOUT
import com.rad.rcommonlib.utils.RXLogUtil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Gamify.initSDK("O6Z1x4LpMl6jKSmq1GJdMhZZB999Otk3")
        initGspaceAd()

        val loadAdButton = findViewById<Button>(R.id.loadAdButton)
        loadAdButton.setOnClickListener {
            loadAndShowGspaceAd()
        }

        val loadRoulaxButton = findViewById<Button>(R.id.loadARoulaxdButton)
        loadRoulaxButton.setOnClickListener {
            loadAndShowRoulaxAd()
        }


    }

    private fun initGspaceAd() {
        Gamify.setListener(object : Gamify.GamifyListener {
            override fun onInitSuccess() {
                Log.d("onInitSuccess", "Success")
            }

            override fun onInitFailed(p0: GamifyError?) {
                Log.d("onInitFailed", p0?.msg.toString())
            }

            override fun onIconReady(p0: String?) {
            }

            override fun onIconLoadFailed(p0: String?, p1: GamifyError?) {
            }

            override fun onIconShowFailed(p0: String?, p1: GamifyError?) {
            }

            override fun onIconClick(p0: String?) {
            }

            override fun onInteractiveOpen(p0: String?) {
            }

            override fun onInteractiveOpenFailed(p0: String?, p1: GamifyError?) {
            }

            override fun onInteractiveClose(p0: String?) {
            }

            override fun onOfferWallOpen(p0: String?) {
            }

            override fun onOfferWallOpenFailed(p0: String?, p1: GamifyError?) {
            }

            override fun onOfferWallClose(p0: String?) {
            }

            override fun onGSpaceOpen(p0: String?) {
            }

            override fun onGSpaceOpenFailed(p0: String?, p1: GamifyError?) {
            }

            override fun onGSpaceClose(p0: String?) {
            }

            override fun onUserInteraction(p0: String?, p1: String?) {
            }


        })
    }

    private fun loadAndShowGspaceAd() {
        Gamify.loadIcon("10882")
        if (Gamify.isIconReady("10882")) {
            val mLinearLayout =
                findViewById<LinearLayout>(R.id.linearLayout)
            val iconView = Gamify.showIcon("10882")
            iconView?.let {
                if (it.parent != null) {
                    (it.parent as ViewGroup).removeView(it)
                }
                it.layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                mLinearLayout.addView(it)
            }
        }

    }


    private fun loadAndShowRoulaxAd() {
        RXSDK.createRXSdkAd()
            .loadBanner(this@MainActivity, "495", object : RXSdkAd.RXBannerAdListener {
                override fun failure(adInfo: RXAdInfo, error: RXError) {
                    Log.d("failure,,", error.msg)
                    Toast.makeText(this@MainActivity, error.msg, Toast.LENGTH_SHORT).show()
                }

                override fun success(adInfo: RXAdInfo, bannerAd: RXBannerAd) {
                    bannerAd.setRXBannerListener(object : RXBannerEventListener {
                        override fun onAdClick(pAdInfo: RXAdInfo) {

                        }

                        override fun onAdClose(pAdInfo: RXAdInfo) {

                        }

                        override fun onAdShow(pAdInfo: RXAdInfo) {

                        }

                        override fun onRenderFail(pAdInfo: RXAdInfo, pError: RXError) {

                        }

                        override fun onRenderSuccess(pView: View) {
                            findViewById<ViewGroup>(R.id.linearLayout).addView(pView)
                        }
                    })
                    bannerAd.render()


                }
            })

    }

}