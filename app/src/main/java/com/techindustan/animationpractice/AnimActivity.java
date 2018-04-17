package com.techindustan.animationpractice;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.Space;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.appolica.flubber.Flubber;
import com.appolica.flubber.animation.providers.FadeIn;
import com.appolica.flubber.animation.providers.SlideUp;
import com.appolica.flubber.interpolator.providers.bezier.EaseIn;
import com.daimajia.easing.Glider;
import com.daimajia.easing.Skill;
import com.techindustan.animationpractice.anim.FadeInUP;
import com.techindustan.animationpractice.anim.SlideUpCus;
import com.techindustan.animationpractice.anim.SpringCustom;
import com.techindustan.animationpractice.anim.SqueezeUpXY;
import com.techindustan.animationpractice.anim.SqueezeupCustom;
import com.techindustan.animationpractice.anim.TranslateY;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnimActivity extends AppCompatActivity {

    @BindView(R.id.bubble1)
    ImageView bubbleDark;
    @BindView(R.id.circleA1)
    ImageView circleA1;
    @BindView(R.id.circleA2)
    ImageView circleA2;
    @BindView(R.id.circleA3)
    ImageView circleA3;
    @BindView(R.id.circleA4)
    ImageView circleA4;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.marginSpacer)
    Space marginSpacer;
    @BindView(R.id.bubble2)
    ImageView bubble2;
    @BindView(R.id.circleB1)
    ImageView circleB1;
    @BindView(R.id.circleB2)
    ImageView circleB2;
    @BindView(R.id.circleB3)
    ImageView circleB3;
    @BindView(R.id.circleB4)
    ImageView circleB4;
    @BindView(R.id.linearLayout2)
    LinearLayout linearLayout2;
    @BindView(R.id.consLay)
    ConstraintLayout consLay;
    @BindView(R.id.animate)
    Button animate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        //tuesday2(bubble2);

        animateBubble2();
    }


    void animateBubbleDark() {

        bubbleDark.setPivotX(60);
        bubbleDark.setPivotY(100);
        Log.e("measureHeight", bubbleDark.getY() + "");
        final Animator fadeIN = Flubber.with().animation(Flubber.AnimationPreset.FADE_IN).duration(300).createFor(bubbleDark);

        ObjectAnimator scaleUpY = ObjectAnimator.ofFloat(bubbleDark, "scaleY", 0f, 1f);
        ObjectAnimator scaleUpX = ObjectAnimator.ofFloat(bubbleDark, "scaleX", 0f, 0.85f);

        final Animator flubbeEase = Flubber.with().animation(new SlideUpCus()).interpolator(new EaseIn()).duration(500).createFor(bubbleDark);
        final Animator flubbeSpring = Flubber.with().animation(new TranslateY()).interpolator(Flubber.Curve.SPRING).duration(1000).createFor(bubbleDark);
        flubbeSpring.setStartDelay(500);

        final AnimatorSet setScale = new AnimatorSet();
        setScale.playTogether(scaleUpX, scaleUpY, flubbeEase, fadeIN);

        flubbeSpring.start();
        //setScale.setInterpolator(new BounceInterpolator());
        setScale.setDuration(500);

        setScale.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                animateBubbleDarkEnd();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        setScale.start();

    }

    void animateBubble2() {

        bubble2.setPivotX(60);
        bubble2.setPivotY(100);
        Log.e("measureHeight", bubble2.getY() + "");
        final Animator fadeIN = Flubber.with().animation(Flubber.AnimationPreset.FADE_IN).duration(300).createFor(bubble2);

        ObjectAnimator scaleUpY = ObjectAnimator.ofFloat(bubble2, "scaleY", 0f, 1f);
        ObjectAnimator scaleUpX = ObjectAnimator.ofFloat(bubble2, "scaleX", 0f, 0.85f);

        final Animator flubbeEase = Flubber.with().animation(new SlideUpCus()).interpolator(new EaseIn()).duration(500).createFor(bubble2);
        final Animator flubbeSpring = Flubber.with().animation(new TranslateY()).interpolator(Flubber.Curve.SPRING).duration(1000).createFor(bubble2);
        flubbeSpring.setStartDelay(500);

        final AnimatorSet setScale = new AnimatorSet();
        setScale.playTogether(scaleUpX, scaleUpY, flubbeEase, fadeIN);

        flubbeSpring.start();
        //setScale.setInterpolator(new BounceInterpolator());
        setScale.setDuration(500);

        setScale.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                animateBubble2End();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        setScale.start();

    }

    void animateBubbleDarkEnd() {
        Log.e("measureHeight", bubbleDark.getY() + "");
        int dur = 200;
        ObjectAnimator scaleUpX = ObjectAnimator.ofFloat(bubbleDark, "scaleX", 0.85f, 1f);
        scaleUpX.setDuration(dur);
        //final Animator flubbeEase = Flubber.with().animation(Flubber.AnimationPreset.).interpolator(Flubber.Curve.BZR_EASE_IN_OUT_CUBIC).duration(500).createFor(bubbleDark);
        final AnimatorSet setScale = new AnimatorSet();
        setScale.playTogether(scaleUpX);
        setScale.setInterpolator(new AccelerateDecelerateInterpolator());
        setScale.setDuration(dur);

        setScale.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        animateCirclesA();
                    }
                }, 500);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        setScale.start();

    }

    void animateBubble2End() {
        Log.e("measureHeight", bubble2.getY() + "");
        int dur = 200;
        ObjectAnimator scaleUpX = ObjectAnimator.ofFloat(bubble2, "scaleX", 0.85f, 1f);
        scaleUpX.setDuration(dur);
        //final Animator flubbeEase = Flubber.with().animation(Flubber.AnimationPreset.).interpolator(Flubber.Curve.BZR_EASE_IN_OUT_CUBIC).duration(500).createFor(bubbleDark);
        final AnimatorSet setScale = new AnimatorSet();
        setScale.playTogether(scaleUpX);
        setScale.setInterpolator(new AccelerateDecelerateInterpolator());
        setScale.setDuration(dur);

        setScale.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        animateCirclesB();
                    }
                }, 500);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        setScale.start();

    }

    void animateCirclesB() {
        int time = 250;
        final Animator fadeInB1 = Flubber.with().animation(Flubber.AnimationPreset.FADE_IN).interpolator(Flubber.Curve.BZR_EASE_IN_OUT).duration(time).createFor(circleB1);
        final Animator fadeInB2 = Flubber.with().animation(Flubber.AnimationPreset.FADE_IN).interpolator(Flubber.Curve.BZR_EASE_IN_OUT).duration(time).createFor(circleB2);
        final Animator fadeInB3 = Flubber.with().animation(Flubber.AnimationPreset.FADE_IN).interpolator(Flubber.Curve.BZR_EASE_IN_OUT).duration(time).createFor(circleB3);
        final Animator fadeInB4 = Flubber.with().animation(Flubber.AnimationPreset.FADE_IN).interpolator(Flubber.Curve.BZR_EASE_IN_OUT).duration(time).createFor(circleB4);

        fadeInB1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                circleB1.setAlpha(0.75f);
                fadeInB2.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        fadeInB2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                circleB2.setAlpha(0.75f);
                circleB1.setAlpha(0.5f);
                fadeInB3.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        fadeInB3.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                circleB1.setAlpha(0.25f);
                circleB2.setAlpha(0.5f);
                circleB3.setAlpha(0.75f);
                fadeInB4.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        fadeInB4.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                animateBubbleDark();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        fadeInB1.start();


    }

    void animateCirclesA() {

        int time = 250;
        final Animator fadeInA1 = Flubber.with().animation(Flubber.AnimationPreset.FADE_IN).interpolator(Flubber.Curve.BZR_EASE_IN_OUT).duration(time).createFor(circleA1);
        final Animator fadeInA2 = Flubber.with().animation(Flubber.AnimationPreset.FADE_IN).interpolator(Flubber.Curve.BZR_EASE_IN_OUT).duration(time).createFor(circleA2);
        final Animator fadeInA3 = Flubber.with().animation(Flubber.AnimationPreset.FADE_IN).interpolator(Flubber.Curve.BZR_EASE_IN_OUT).duration(time).createFor(circleA3);
        final Animator fadeInA4 = Flubber.with().animation(Flubber.AnimationPreset.FADE_IN).interpolator(Flubber.Curve.BZR_EASE_IN_OUT).duration(time).createFor(circleA4);

        final Animator fadeInA5 = Flubber.with().animation(Flubber.AnimationPreset.FADE_IN).interpolator(Flubber.Curve.BZR_EASE_IN_OUT).duration(time).createFor(circleA3);
        final Animator fadeInA6 = Flubber.with().animation(Flubber.AnimationPreset.FADE_IN).interpolator(Flubber.Curve.BZR_EASE_IN_OUT).duration(time).createFor(circleA2);
        final Animator fadeInA7 = Flubber.with().animation(Flubber.AnimationPreset.FADE_IN).interpolator(Flubber.Curve.BZR_EASE_IN_OUT).duration(time).createFor(circleA1);

        fadeInA1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                circleB2.setAlpha(1f);
                circleA1.setAlpha(0.75f);
                fadeInA2.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        fadeInA2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                circleB1.setAlpha(1f);
                circleA2.setAlpha(0.75f);
                circleA1.setAlpha(0.5f);
                fadeInA3.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        fadeInA3.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                circleA1.setAlpha(0.25f);
                circleA2.setAlpha(0.5f);
                circleA3.setAlpha(0.75f);
                fadeInA4.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        fadeInA4.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                fadeInA5.start();

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        fadeInA5.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                fadeInA6.start();

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        fadeInA6.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                fadeInA7.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        fadeInA7.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        circleB1.setAlpha(0f);
                        circleB2.setAlpha(0f);
                        circleB3.setAlpha(0f);
                        circleB4.setAlpha(0f);
                        circleA1.setAlpha(0f);
                        circleA2.setAlpha(0f);
                        circleA3.setAlpha(0f);
                        circleA4.setAlpha(0f);
                        bubbleDark.setAlpha(0f);
                        bubble2.setAlpha(0f);
                        animateBubble2();
                    }
                }, 1000);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        fadeInA1.start();


    }

}
