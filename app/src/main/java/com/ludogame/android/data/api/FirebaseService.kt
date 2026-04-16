package com.ludogame.android.data.api

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseService @Inject constructor(
    val auth: FirebaseAuth,
    val database: FirebaseDatabase
)
