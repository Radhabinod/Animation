package com.techindustan.animationpractice;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bubble2)
    ImageView bubble2;
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
    @BindView(R.id.circleB1)
    ImageView circleB1;
    @BindView(R.id.circleB2)
    ImageView circleB2;
    @BindView(R.id.circleB3)
    ImageView circleB3;
    @BindView(R.id.circleB4)
    ImageView circleB4;
    @BindView(R.id.animate)
    Button animate;
    @BindView(R.id.consLay)
    ConstraintLayout consLay;
    int WIDTH = 0;
    int HEIGHT = 0;
    int cTime = 300;
    int fOutTime = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraints_main);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        HEIGHT = displayMetrics.heightPixels;
        WIDTH = displayMetrics.widthPixels;
        animate.setVisibility(View.GONE);
        final Animation a = AnimationUtils.loadAnimation(this, R.anim.scale_bounce);
        a.setRepeatMode(Animation.INFINITE);
        bubble2.setVisibility(View.GONE);
        bubble2.startAnimation(a);
        bubble2.setVisibility(View.VISIBLE);
        a.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                bubble2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                bubble2.setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bubble2.startAnimation(a);
                    }
                }, 3000);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        //finalAnimation();

    }

    @OnClick(R.id.animate)
    public void onViewClicked() {

        /*final Animation img1TransAnim = AnimationUtils.loadAnimation(this, R.anim.translationset);
        Animation img2TransAnim = AnimationUtils.loadAnimation(this, R.anim.translationset);
        bubbleDark.startAnimation(img1TransAnim);
        img1TransAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                bubble2.setAnimation(img1TransAnim);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });*/



       /* Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(1000);

        ObjectAnimator objectAnimatorX
                = ObjectAnimator.ofFloat(bubbleDark, "translationX", 0f, 500f);
        ObjectAnimator objectAnimatorY
                = ObjectAnimator.ofFloat(bubbleDark, "translationY", 200f, 0f);
        //objectAnimatorX.setDuration(200);
        objectAnimatorY.setDuration(1000);


        //objectAnimatorX.start();
        objectAnimatorY.start();
        objectAnimatorY.setTarget(fadeIn);*/
        //animateViews();
        //finalAnimation();

       /* final Animation anim = new ScaleAnimation(
                1f, 1f, // Start and end values for the X axis scaling
                1.7f, 1f, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, 0f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, 1f); // Pivot point of Y scaling
        anim.setFillAfter(true); // Needed to keep the result of the animation
        anim.setDuration(300);

        final Animation anim2 = new ScaleAnimation(
                1f, 1f, // Start and end values for the X axis scaling
                1.7f, 1f, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, 0f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, 1f); // Pivot point of Y scaling
        anim.setFillAfter(true); // Needed to keep the result of the animation*/
        /*anim.setDuration(300);
        bubble2.startAnimation(anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                bubbleDark.startAnimation(anim2);
            }
        }, 700);*/
        /*ObjectAnimator scaleUp = ObjectAnimator.ofPropertyValuesHolder(bubble2,
                PropertyValuesHolder.ofFloat("scaleX", 1f),
                PropertyValuesHolder.ofFloat("scaleY", 1.4f));
        scaleUp.setDuration(1);

        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(bubble2,
                PropertyValuesHolder.ofFloat("scaleX", 1f),
                PropertyValuesHolder.ofFloat("scaleY", 1f));
        scaleDown.setDuration(200);

        ObjectAnimator scaleUpB = ObjectAnimator.ofPropertyValuesHolder(bubbleDark,
                PropertyValuesHolder.ofFloat("scaleX", 1f),
                PropertyValuesHolder.ofFloat("scaleY", 1.4f));
        scaleUp.setDuration(1);

        ObjectAnimator scaleDownB = ObjectAnimator.ofPropertyValuesHolder(bubbleDark,
                PropertyValuesHolder.ofFloat("scaleX", 1f),
                PropertyValuesHolder.ofFloat("scaleY", 1f));
        scaleDown.setDuration(200);

        final AnimatorSet set = new AnimatorSet();
        set.playSequentially(scaleUp, scaleDown,scaleUpB,scaleDownB);
        set.start();*/
        finalAnimation();


    }

    void animate() {
        //Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
        Animation animTranslate = new TranslateAnimation(0, 0, 1000, 0);
        animTranslate.setDuration(3000);
        animTranslate.setFillAfter(true);

        ObjectAnimator objectAnimatorY
                = ObjectAnimator.ofFloat(bubbleDark, "translationY", 500f, 0f);
        //objectAnimatorY.setInterpolator(new DecelerateInterpolator());
        objectAnimatorY.setDuration(1000);
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(bubbleDark, View.ALPHA, 0, 1);
        alphaAnimation.setDuration(1500);


        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(3000);

        Animation fade = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadin);

        AnimationSet animSet = new AnimationSet(false); //change to false
        animSet.addAnimation(fade);
        animSet.addAnimation(animTranslate);
        //animSet.setRepeatMode(Animation.INFINITE);
        bubble2.setAnimation(fade);
        objectAnimatorY.start();
        alphaAnimation.start();

    }

    void animateViews() {

        ObjectAnimator fadein2 = ObjectAnimator.ofFloat(bubbleDark, "alpha", 1f);
        fadein2.setDuration(500);

        ObjectAnimator fadein1 = ObjectAnimator.ofFloat(bubble2, "alpha", 1f);
        fadein1.setDuration(500);


        ObjectAnimator objectAnimatorY2
                = ObjectAnimator.ofFloat(bubbleDark, "translationY", 200f, -100f);
        objectAnimatorY2.setDuration(500);

        ObjectAnimator yAnimDownImg2
                = ObjectAnimator.ofFloat(bubbleDark, "translationY", -100f, 0f);
        objectAnimatorY2.setDuration(200);

        ObjectAnimator objectAnimatorY1
                = ObjectAnimator.ofFloat(bubble2, "translationY", 100f, -100f);
        objectAnimatorY1.setDuration(500);
        ObjectAnimator yAnimDownImg1
                = ObjectAnimator.ofFloat(bubble2, "translationY", -100f, 0f);
        objectAnimatorY2.setDuration(200);


        final ObjectAnimator fade2 = ObjectAnimator.ofFloat(bubbleDark, "alpha", 0f);
        fade2.setDuration(fOutTime);
        final ObjectAnimator fade1 = ObjectAnimator.ofFloat(bubble2, "alpha", 0f);
        fade1.setDuration(fOutTime);


        ObjectAnimator om1 = ObjectAnimator.ofFloat(circleA1, "alpha", 1f);
        om1.setDuration(cTime);
        ObjectAnimator om2 = ObjectAnimator.ofFloat(circleA2, "alpha", 1f);
        om1.setDuration(cTime);
        ObjectAnimator om3 = ObjectAnimator.ofFloat(circleA3, "alpha", 1f);
        om1.setDuration(cTime);
        ObjectAnimator om4 = ObjectAnimator.ofFloat(circleA4, "alpha", 1f);
        om1.setDuration(cTime);


        ObjectAnimator om1F = ObjectAnimator.ofFloat(circleA1, "alpha", 0f);
        om1.setDuration(fOutTime);
        ObjectAnimator om2F = ObjectAnimator.ofFloat(circleA2, "alpha", 0f);
        om1.setDuration(fOutTime);
        ObjectAnimator om3F = ObjectAnimator.ofFloat(circleA3, "alpha", 0f);
        om1.setDuration(fOutTime);
        ObjectAnimator om4F = ObjectAnimator.ofFloat(circleA4, "alpha", 0f);
        om1.setDuration(fOutTime);

        ObjectAnimator omB1 = ObjectAnimator.ofFloat(circleB1, "alpha", 1f);
        om1.setDuration(cTime);
        ObjectAnimator omB2 = ObjectAnimator.ofFloat(circleB2, "alpha", 1f);
        om1.setDuration(cTime);
        ObjectAnimator omB3 = ObjectAnimator.ofFloat(circleB3, "alpha", 1f);
        om1.setDuration(cTime);
        ObjectAnimator omB4 = ObjectAnimator.ofFloat(circleB4, "alpha", 1f);
        om1.setDuration(cTime);

        ObjectAnimator omB1F = ObjectAnimator.ofFloat(circleB1, "alpha", 0f);
        om1.setDuration(fOutTime);
        ObjectAnimator omB2F = ObjectAnimator.ofFloat(circleB2, "alpha", 0f);
        om1.setDuration(fOutTime);
        ObjectAnimator omB3F = ObjectAnimator.ofFloat(circleB3, "alpha", 0f);
        om1.setDuration(fOutTime);
        ObjectAnimator omB4F = ObjectAnimator.ofFloat(circleB4, "alpha", 0f);
        om1.setDuration(fOutTime);


        final List<Animator> fadeoff = new ArrayList<>();
        fadeoff.add(om1F);
        fadeoff.add(om2F);
        fadeoff.add(om3F);
        fadeoff.add(om4F);
        fadeoff.add(omB1F);
        fadeoff.add(omB2F);
        fadeoff.add(omB3F);
        fadeoff.add(omB4F);
        fadeoff.add(fade1);
        fadeoff.add(fade2);
/*
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(zoomTarget, "scaleY", 0.5f);
        scaleYAnimator.setRepeatMode(ValueAnimator.REVERSE);
        scaleYAnimator.setRepeatCount(1);
        scaleYAnimator.setDuration(1000);

        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(zoomTarget, "rotation", 0f, 360f);
        rotationAnimator.setRepeatMode(ValueAnimator.RESTART);
        rotationAnimator.setRepeatCount(1);
        rotationAnimator.setDuration(1000);*/

//sequencial animation
        final AnimatorSet set = new AnimatorSet();
        final AnimatorSet set2 = new AnimatorSet();
       /* set.play(objectAnimatorY2).after(objectAnimatorY1);//.with(fadein1).with(fadein2).after(fade1).after(fade2);
        set.play(fade1).with(fade2);*/
        List<Animator> anims = new ArrayList<>();
        //anims.add(fadein1);
        anims.add(objectAnimatorY1);
        anims.add(yAnimDownImg1);
        anims.add(omB1);
        anims.add(omB2);
        anims.add(omB3);
        anims.add(omB4);
        //anims.add(fadein2);
        anims.add(objectAnimatorY2);
        anims.add(yAnimDownImg2);
        anims.add(om1);
        anims.add(om2);
        anims.add(om3);
        anims.add(om4);
        set.playSequentially(anims);


       /* List<Animator> anims2 = new ArrayList<>();
        anims2.add(fade2);
        anims2.add(fade1);*/
        //set.playTogether(fadeoff);

        set2.addListener(new AnimatorListenerAdapter() {


            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                set.start();

            }

            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
                Log.e("canceledd", "cancel");
                set.cancel();
            }
        });
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);


            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        set2.playTogether(fadeoff);
                        set2.start();


                        //set.start();
                        /*bubbleDark.setVisibility(View.VISIBLE);
                        bubble2.setVisibility(View.VISIBLE);*/
                    }
                }, 1000);
            }
        });

        set.start();


    }

    void finalAnimation() {

        ObjectAnimator fadein2 = ObjectAnimator.ofFloat(bubbleDark, "alpha", 1f);
        fadein2.setDuration(200);
        ObjectAnimator fadein1 = ObjectAnimator.ofFloat(bubble2, "alpha", 1f);
        fadein1.setDuration(200);
        final ObjectAnimator fade2 = ObjectAnimator.ofFloat(bubbleDark, "alpha", 0f);
        fade2.setDuration(fOutTime);
        final ObjectAnimator fade1 = ObjectAnimator.ofFloat(bubble2, "alpha", 0f);
        fade1.setDuration(fOutTime);

        ObjectAnimator consFadeOut = ObjectAnimator.ofFloat(consLay, "alpha", 0f);
        consFadeOut.setDuration(150);
        ObjectAnimator consFadeIn = ObjectAnimator.ofFloat(consLay, "alpha", 1f);
        consFadeIn.setDuration(150);


        ObjectAnimator transUpB2
                = ObjectAnimator.ofFloat(bubbleDark, "translationY", 10f, -20f);
        transUpB2.setDuration(100);

        ObjectAnimator transDownB2
                = ObjectAnimator.ofFloat(bubbleDark, "translationY", -20f, 0f);
        transDownB2.setDuration(50);


        ObjectAnimator transUpB1
                = ObjectAnimator.ofFloat(bubble2, "translationY", 20f, 0f);
        transUpB1.setDuration(50);
        ObjectAnimator transDownB1
                = ObjectAnimator.ofFloat(bubble2, "translationY", -30f, 0f);
        transDownB1.setDuration(50);

        ObjectAnimator transDownB2Bounce
                = ObjectAnimator.ofFloat(bubble2, "translationY", -15f, 0f);
        transDownB2Bounce.setDuration(50);
        ObjectAnimator ttransDownB2Bounce
                = ObjectAnimator.ofFloat(bubbleDark, "translationY", -10f, 0f);
        ttransDownB2Bounce.setDuration(50);


        ObjectAnimator om1 = ObjectAnimator.ofFloat(circleA1, "alpha", 1f);
        om1.setDuration(cTime);
        ObjectAnimator om2 = ObjectAnimator.ofFloat(circleA2, "alpha", 1f);
        om1.setDuration(cTime);
        ObjectAnimator om3 = ObjectAnimator.ofFloat(circleA3, "alpha", 1f);
        om1.setDuration(cTime);
        ObjectAnimator om4 = ObjectAnimator.ofFloat(circleA4, "alpha", 1f);
        om1.setDuration(cTime);

        ObjectAnimator om1Out = ObjectAnimator.ofFloat(circleA1, "alpha", .6f);
        om1Out.setDuration(cTime);
        ObjectAnimator om2Out = ObjectAnimator.ofFloat(circleA2, "alpha", .6f);
        om2Out.setDuration(cTime);


        ObjectAnimator om1F = ObjectAnimator.ofFloat(circleA1, "alpha", 0f);
        om1.setDuration(fOutTime);
        ObjectAnimator om2F = ObjectAnimator.ofFloat(circleA2, "alpha", 0f);
        om1.setDuration(fOutTime);
        ObjectAnimator om3F = ObjectAnimator.ofFloat(circleA3, "alpha", 0f);
        om1.setDuration(fOutTime);
        ObjectAnimator om4F = ObjectAnimator.ofFloat(circleA4, "alpha", 0f);
        om1.setDuration(fOutTime);

        ObjectAnimator omB1 = ObjectAnimator.ofFloat(circleB1, "alpha", 1f);
        om1.setDuration(cTime);
        ObjectAnimator omB2 = ObjectAnimator.ofFloat(circleB2, "alpha", 1f);
        om1.setDuration(cTime);
        ObjectAnimator omB3 = ObjectAnimator.ofFloat(circleB3, "alpha", 1f);
        om1.setDuration(cTime);
        ObjectAnimator omB4 = ObjectAnimator.ofFloat(circleB4, "alpha", 1f);
        om1.setDuration(cTime);

        ObjectAnimator omB1Out = ObjectAnimator.ofFloat(circleB1, "alpha", .6f);
        omB1Out.setDuration(cTime);
        ObjectAnimator omB2Out = ObjectAnimator.ofFloat(circleB2, "alpha", .6f);
        omB2Out.setDuration(cTime);

        ObjectAnimator omB1F = ObjectAnimator.ofFloat(circleB1, "alpha", 0f);
        om1.setDuration(fOutTime);
        ObjectAnimator omB2F = ObjectAnimator.ofFloat(circleB2, "alpha", 0f);
        om1.setDuration(fOutTime);
        ObjectAnimator omB3F = ObjectAnimator.ofFloat(circleB3, "alpha", 0f);
        om1.setDuration(fOutTime);
        ObjectAnimator omB4F = ObjectAnimator.ofFloat(circleB4, "alpha", 0f);
        om1.setDuration(fOutTime);


        ObjectAnimator scaleUpBubble1 = ObjectAnimator.ofPropertyValuesHolder(bubble2,
                PropertyValuesHolder.ofFloat("scaleX", 1f),
                PropertyValuesHolder.ofFloat("scaleY", 1.4f));
        scaleUpBubble1.setDuration(1);

        ObjectAnimator scaleDownBuubble1 = ObjectAnimator.ofPropertyValuesHolder(bubble2,
                PropertyValuesHolder.ofFloat("scaleX", 1f),
                PropertyValuesHolder.ofFloat("scaleY", 1f));
        scaleDownBuubble1.setDuration(15);

        ObjectAnimator scaleUpDark = ObjectAnimator.ofPropertyValuesHolder(bubbleDark,
                PropertyValuesHolder.ofFloat("scaleX", 1f),
                PropertyValuesHolder.ofFloat("scaleY", 1.4f));
        scaleUpDark.setDuration(1);

        ObjectAnimator scaleDownB = ObjectAnimator.ofPropertyValuesHolder(bubbleDark,
                PropertyValuesHolder.ofFloat("scaleX", 1f),
                PropertyValuesHolder.ofFloat("scaleY", 1f));
        scaleDownB.setDuration(15);


        final List<Animator> fadeoff = new ArrayList<>();
        fadeoff.add(om1F);
        fadeoff.add(om2F);
        fadeoff.add(om3F);
        fadeoff.add(om4F);
        fadeoff.add(omB1F);
        fadeoff.add(omB2F);
        fadeoff.add(omB3F);
        fadeoff.add(omB4F);
        fadeoff.add(fade1);
        fadeoff.add(fade2);

        AnimatorSet seqSet1 = new AnimatorSet();
        seqSet1.playTogether(consFadeIn, transUpB1, fadein1, scaleUpBubble1);
        AnimatorSet seqSet1Down = new AnimatorSet();
        seqSet1Down.playTogether(scaleDownBuubble1);
        //seqSet1.setInterpolator(new BounceInterpolator());
        //seqSet1.setDuration(500);

        AnimatorSet seqSet2 = new AnimatorSet();
        seqSet2.playTogether(transUpB2, fadein2, scaleUpDark);
        //seqSet2.setInterpolator(new BounceInterpolator());
        AnimatorSet seqSet2Down = new AnimatorSet();
        seqSet2Down.playTogether(transDownB2, scaleDownB);
        AnimatorSet setBounce = new AnimatorSet();
        setBounce.playSequentially(transDownB2Bounce);
        AnimatorSet setBounceDark = new AnimatorSet();
        setBounceDark.playSequentially(ttransDownB2Bounce);


        AnimatorSet setCircle2On = new AnimatorSet();
        final List<Animator> circle2On = new ArrayList<>();
        circle2On.add(omB1);
        circle2On.add(omB2);

        AnimatorSet an = new AnimatorSet();
        an.playTogether(omB3, omB1Out);
        circle2On.add(an);
        AnimatorSet an2 = new AnimatorSet();
        an2.playTogether(omB4, omB2Out);
        circle2On.add(an2);
        setCircle2On.playSequentially(circle2On);

        AnimatorSet sss = new AnimatorSet();
        sss.playSequentially(om1, om2);
        //setCircle2On.playTogether(omB1Out,omB2Out);

        AnimatorSet setCircle1On = new AnimatorSet();
        final List<Animator> circle1On = new ArrayList<>();
        circle1On.add(om1);
        circle1On.add(om2);
        AnimatorSet a1 = new AnimatorSet();
        a1.playTogether(om3, om1Out);
        circle1On.add(a1);
        AnimatorSet a2 = new AnimatorSet();
        a2.playTogether(om4, om2Out);
        circle1On.add(a2);
        //circle1On.add(om1);
        setCircle1On.playSequentially(circle1On);


        //seqSet2.setDuration(500);
        AnimatorSet seqSet3 = new AnimatorSet();
        //seqSet3.playTogether(fadeoff);
        seqSet3.playTogether(consFadeOut);
        seqSet3.playTogether(fadeoff);
        // seqSet3.setDuration(500);
        final AnimatorSet finalAnimSet = new AnimatorSet();
        finalAnimSet.playSequentially(seqSet1, seqSet1Down, setBounce, setCircle2On, seqSet2, seqSet2Down, setBounceDark, setCircle1On, sss, seqSet3);
        //finalAnimSet.playSequentially(seqSet1, seqSet1Down, setCircle2On, seqSet2, seqSet2Down, setCircle1On, seqSet3);
        finalAnimSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finalAnimSet.start();
                    }
                }, 800);

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        finalAnimSet.start();


    }

    void circle1Anim(){

    }


}
