package com.realtomjoney.card_flip_animation

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import com.realtomjoney.card_flip_animation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBindings()

        binding.textView.setOnClickListener {
            val animation1 = ObjectAnimator.ofFloat(binding.textView, "scaleX", 1f, 0f)
            val animation2 = ObjectAnimator.ofFloat(binding.textView, "scaleX", 0f, 1f)

            animation1.interpolator = DecelerateInterpolator()
            animation2.interpolator = AccelerateInterpolator()

            animation1.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    binding.textView.text = "Back"
                    animation2.start()
                }
            })

            animation1.start()
        }
    }

    private fun setBindings() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}