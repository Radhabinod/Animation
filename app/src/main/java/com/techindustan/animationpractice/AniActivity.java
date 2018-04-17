package com.techindustan.animationpractice;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.appolica.flubber.Flubber;
import com.techindustan.animationpractice.anim.SqueezeUpXY;
import com.techindustan.animationpractice.anim.SqueezeupCustom;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AniActivity extends AppCompatActivity {

    @BindView(R.id.imgDark)
    ImageView imgDark;
    int duration = 600;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ani);
        ButterKnife.bind(this);
        Animator fadeIn = ObjectAnimator.ofFloat(imgDark, "alpha", 0f, 1f);
        fadeIn.setDuration(duration);
        imgDark.setPivotX(imgDark.getWidth() / 4 - 30);
        final Animator a1 = Flubber.with().animation(new SqueezeUpXY()).interpolator(Flubber.Curve.SPRING).duration(duration).createFor(imgDark);
        AnimatorSet set=new AnimatorSet();
        set.playTogether(a1,fadeIn);

        a1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        a1.start();
                    }
                }, 2000);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        a1.start();


    }
}
