package com.ludogame.android.core.ads

import android.app.Activity
import android.content.Context
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AdMobManager @Inject constructor() {
    fun initialize(context: Context) {
        MobileAds.initialize(context)
    }

    fun createRequest(): AdRequest = AdRequest.Builder().build()

    fun showInterstitial(activity: Activity, helper: InterstitialAdHelper) {
        helper.show(activity)
    }
}
