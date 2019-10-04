package com.octo.appactionsapp.feature

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.octo.appactionsapp.R
import kotlinx.android.synthetic.main.feature_activity.*

class FeatureTwoActivity : AppCompatActivity() {

    companion object {
        fun newInstance(context: Context) = Intent(context, FeatureTwoActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_activity)
        titleTextView.text = resources.getString(R.string.title_feature_2)
        subTitleTextView.text = resources.getString(R.string.subtitle_feature_2)
        imageView.setImageResource(R.drawable.image_flower)
    }
}
