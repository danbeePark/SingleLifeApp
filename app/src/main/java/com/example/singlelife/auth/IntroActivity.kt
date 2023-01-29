package com.example.singlelife.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.singlelife.R
import com.example.singlelife.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {

    private lateinit var binding : ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_intro)

        binding.join.setOnClickListener {

            var intent = Intent(this, JoinActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.login.setOnClickListener {

            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}