package com.octo.appactionsapp

import android.app.Application
import android.content.ContentResolver
import android.content.Intent
import android.net.Uri
import android.service.voice.VoiceInteractionService
import androidx.slice.SliceManager

@Suppress("unused")
class AppActionsApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        grantSlicePermissions()
    }

    private fun grantSlicePermissions() {
        val sliceProviderUri = Uri.Builder().apply {
            scheme(ContentResolver.SCHEME_CONTENT)
            authority(applicationContext.packageName)
        }.build()

        val assistantPackage = applicationContext.packageManager.queryIntentServices(
            Intent(VoiceInteractionService.SERVICE_INTERFACE), 0
        )?.let { it[0].serviceInfo.packageName } ?: return

        SliceManager.getInstance(applicationContext).grantSlicePermission(assistantPackage, sliceProviderUri)
    }
}
