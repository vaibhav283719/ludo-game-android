package com.ludogame.android.core.ads

import android.app.Activity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import javax.inject.Inject

class RewardedAdHelper @Inject constructor() {
    private var rewardedAd: RewardedAd? = null

    fun load(activity: Activity) {
        RewardedAd.load(
            activity,
            "ca-app-pub-3940256099942544/5224354917",
            AdRequest.Builder().build(),
            object : RewardedAdLoadCallback() {
                override fun onAdLoaded(ad: RewardedAd) {
                    rewardedAd = ad
                }
            }
        )
    }

    fun show(activity: Activity, onReward: () -> Unit) {
        rewardedAd?.show(activity) { onReward() }
    }
}
