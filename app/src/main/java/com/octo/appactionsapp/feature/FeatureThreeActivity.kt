package com.octo.appactionsapp.feature

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.octo.appactionsapp.R
import kotlinx.android.synthetic.main.feature_activity.*

class FeatureThreeActivity : AppCompatActivity() {

    companion object {
        fun newInstance(context: Context) = Intent(context, FeatureThreeActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_activity)
        titleTextView.text = resources.getString(R.string.title_feature_3)
        subTitleTextView.text = resources.getString(R.string.subtitle_feature_3)
        imageView.setImageResource(R.drawable.image_leaf)
    }
}
