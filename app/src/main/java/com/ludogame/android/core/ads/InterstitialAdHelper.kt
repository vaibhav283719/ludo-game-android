package com.ludogame.android.core.ads

import android.app.Activity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import javax.inject.Inject

class InterstitialAdHelper @Inject constructor() {
    private var interstitialAd: InterstitialAd? = null

    fun load(activity: Activity) {
        InterstitialAd.load(
            activity,
            "ca-app-pub-3940256099942544/1033173712",
            AdRequest.Builder().build(),
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(ad: InterstitialAd) {
                    interstitialAd = ad
                }
            }
        )
    }

    fun show(activity: Activity) {
        interstitialAd?.show(activity)
    }
}
