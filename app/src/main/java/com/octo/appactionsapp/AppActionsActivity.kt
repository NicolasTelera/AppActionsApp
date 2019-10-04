package com.octo.appactionsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.octo.appactionsapp.AppActionsActivity.Companion.Feature.*
import com.octo.appactionsapp.feature.FeatureOneActivity
import com.octo.appactionsapp.feature.FeatureTwoActivity
import com.octo.appactionsapp.feature.FeatureThreeActivity
import kotlinx.android.synthetic.main.activity_app_actions.*

class AppActionsActivity : AppCompatActivity() {

    companion object {

        private const val QUERY_PARAMETER_NAME = "featureName"

        enum class Feature(val invocation: String) {
            FEATURE_ONE("one"),
            FEATURE_TWO("two"),
            FEATURE_THREE("three")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_actions)

        feature1.setOnClickListener { launchFeature(FEATURE_ONE) }
        feature2.setOnClickListener { launchFeature(FEATURE_TWO) }
        feature3.setOnClickListener { launchFeature(FEATURE_THREE) }

        handleIntent(intent)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent) {
        val appLinkAction = intent.action
        val appLinkData: Uri? = intent.data
        if (Intent.ACTION_VIEW == appLinkAction) {
            appLinkData?.getQueryParameter(QUERY_PARAMETER_NAME)?.let {
                when (it) {
                    FEATURE_ONE.invocation -> launchFeature(FEATURE_ONE)
                    FEATURE_TWO.invocation -> launchFeature(FEATURE_TWO)
                    FEATURE_THREE.invocation -> launchFeature(FEATURE_THREE)
                }
            }
        }
    }

    private fun launchFeature(feature: Feature) {
        startActivity(
            when (feature) {
                FEATURE_ONE -> FeatureOneActivity.newInstance(this)
                FEATURE_TWO -> FeatureTwoActivity.newInstance(this)
                FEATURE_THREE -> FeatureThreeActivity.newInstance(this)
            }
        )
    }
}
