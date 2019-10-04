package com.octo.appactionsapp.feature

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.octo.appactionsapp.R
import kotlinx.android.synthetic.main.feature_activity.*

class FeatureOneActivity : AppCompatActivity() {

    companion object {
        fun newInstance(context: Context) = Intent(context, FeatureOneActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_activity)
        titleTextView.text = resources.getString(R.string.title_feature_1)
        subTitleTextView.text = resources.getString(R.string.subtitle_feature_1)
        imageView.setImageResource(R.drawable.image_aurora)
    }
}
