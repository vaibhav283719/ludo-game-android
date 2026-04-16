package com.ludogame.android.core.ads

import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import javax.inject.Inject

class BannerAdHelper @Inject constructor(
    private val manager: AdMobManager
) {
    fun load(adView: AdView) {
        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"
        adView.loadAd(manager.createRequest())
    }
}
