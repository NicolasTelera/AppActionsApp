package com.octo.appactionsapp

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.graphics.drawable.IconCompat
import androidx.slice.Slice
import androidx.slice.SliceProvider
import androidx.slice.builders.*
import androidx.slice.builders.ListBuilder.LARGE_IMAGE
import com.octo.appactionsapp.feature.FeatureOneActivity
import com.octo.appactionsapp.feature.FeatureTwoActivity
import com.octo.appactionsapp.feature.FeatureThreeActivity

@SuppressLint("Slices")
class AppActionsSliceProvider : SliceProvider() {

    companion object {
        private const val DEFAULT_TITLE = "URI not found."
        private const val DEFAULT_ACTION_TITLE = "Open App"
    }

    override fun onCreateSliceProvider() = true

    override fun onBindSlice(sliceUri: Uri): Slice? {
        return context?.let { context ->
            when (sliceUri.path) {
                "/" -> buildDefaultSlice(
                    context,
                    sliceUri,
                    buildActivityAction(Intent(context, AppActionsActivity::class.java))
                )
                "/one" -> buildFeatureSlice(
                    context,
                    sliceUri,
                    buildActivityAction(FeatureOneActivity.newInstance(context)),
                    R.string.title_feature_1,
                    R.string.subtitle_feature_1,
                    R.drawable.image_aurora
                )
                "/two" -> buildFeatureSlice(
                    context,
                    sliceUri,
                    buildActivityAction(FeatureTwoActivity.newInstance(context)),
                    R.string.title_feature_2,
                    R.string.subtitle_feature_2,
                    R.drawable.image_flower
                )
                "/three" -> buildFeatureSlice(
                    context,
                    sliceUri,
                    buildActivityAction(FeatureThreeActivity.newInstance(context)),
                    R.string.title_feature_3,
                    R.string.subtitle_feature_3,
                    R.drawable.image_leaf
                )
                else -> list(context, sliceUri, ListBuilder.INFINITY) {
                    row { title = DEFAULT_TITLE }
                }
            }
        }
    }

    private fun buildDefaultSlice(
        context: Context,
        sliceUri: Uri,
        action: SliceAction
    ) = list(context, sliceUri, ListBuilder.INFINITY) {
        row {
            title = context.resources.getString(R.string.app_name)
            subtitle = context.resources.getString(R.string.click_to_open_app)
            primaryAction = action
        }
    }

    @SuppressLint("DefaultLocale")
    private fun buildFeatureSlice(
        context: Context,
        sliceUri: Uri,
        action: SliceAction,
        @StringRes titleRes: Int,
        @StringRes subtitleRes: Int,
        @DrawableRes imageRes: Int
    ) = list(context, sliceUri, ListBuilder.INFINITY) {
        row {
            title = context.resources.getString(titleRes).toUpperCase()
            subtitle = context.resources.getString(subtitleRes)
            primaryAction = action
        }
        gridRow {
            cell {
                addImage(
                    IconCompat.createWithResource(context, imageRes),
                    LARGE_IMAGE
                )
            }
        }
    }

    private fun buildActivityAction(intent: Intent) = SliceAction.create(
        PendingIntent.getActivity(context, 0, intent, 0),
        IconCompat.createWithResource(context, R.drawable.ic_launcher_foreground),
        ListBuilder.ICON_IMAGE,
        DEFAULT_ACTION_TITLE
    )

    override fun onSlicePinned(sliceUri: Uri?) {}

    override fun onSliceUnpinned(sliceUri: Uri?) {}
}
