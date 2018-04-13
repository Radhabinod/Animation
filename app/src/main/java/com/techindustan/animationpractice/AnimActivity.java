package com.techindustan.animationpractice;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.Space;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.daimajia.easing.Glider;
import com.daimajia.easing.Skill;

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

      /*  AnimatorSet animatorSet = new AnimatorSet();


        final AnimationSet as = new AnimationSet(true);
        as.setFillEnabled(true);
        as.setInterpolator(new BounceInterpolator());

        TranslateAnimation ta = new TranslateAnimation(0, 0, 20, 0);
        ta.setDuration(2000);
        as.addAnimation(ta);

        ScaleAnimation scaleAnimation = new ScaleAnimation(0f, 0f, 1.5f, 1f);
        scaleAnimation.setDuration(1000);
        as.setStartOffset(1000);
        as.addAnimation(scaleAnimation);
        TranslateAnimation ta2 = new TranslateAnimation(0, 0, 15, 0);
        ta2.setDuration(2000);
        ta2.setStartOffset(2000); // allowing 2000 milliseconds for ta to finish
        as.addAnimation(ta2);

        //bubble2.setAnimation(as);
        as.setRepeatMode(Animation.INFINITE);
        //bubble2.startAnimation(as);*/

        /*final Animation a = AnimationUtils.loadAnimation(this, R.anim.test);
        a.setRepeatMode(Animation.INFINITE);
        bubble2.startAnimation(a);*/
        ObjectAnimator transY = ObjectAnimator.ofFloat(bubble2, "translationY", 20, 0);
        //transY.setDuration(100);
        ObjectAnimator scaleUpBubble2 = ObjectAnimator.ofPropertyValuesHolder(bubble2,
                PropertyValuesHolder.ofFloat("scaleX", 1f),
                PropertyValuesHolder.ofFloat("scaleY", 1.15f));
        scaleUpBubble2.setDuration(100);
        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(bubble2,
                PropertyValuesHolder.ofFloat("scaleX", .7f),
                PropertyValuesHolder.ofFloat("scaleY", .7f));
        scaleDown.setDuration(200);

        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(bubble2, "scaleX", 0.5f);
        ObjectAnimator scaleUpY = ObjectAnimator.ofFloat(bubble2, "scaleY", 1.15f);


        ObjectAnimator scaleToNormal = ObjectAnimator.ofPropertyValuesHolder(bubble2,
                PropertyValuesHolder.ofFloat("scaleX", 1f),
                PropertyValuesHolder.ofFloat("scaleY", 1f));
        scaleToNormal.setDuration(100);

        final AnimatorSet set = new AnimatorSet();
        set.playTogether(scaleUpBubble2);

        //set.playTogether(transY, scaleUpY);
        final AnimatorSet setSmall = new AnimatorSet();

        set.playTogether(
                Glider.glide(Skill.ElasticEaseOut, 400, transY), scaleToNormal
        );

        setSmall.playSequentially(set, scaleToNormal);


        final AnimatorSet s = new AnimatorSet();
        s.playTogether(Glider.glide(Skill.BounceEaseInOut, 1000, scaleUpBubble2), transY);


        animate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //bubble2.startAnimation(a);
                //setSmall.start();
                //shinkGrow(animate);
                //s.start();
                anim();
            }
        });


        set.setDuration(600);
        set.start();


    }

    void anim() {
        Log.e("pivotX", bubble2.getPivotX() + "");
        bubble2.setPivotX(bubble2.getPivotX() / 4);
        //bubble2.setPivotY(0);
        ObjectAnimator fadeInBubble = ObjectAnimator.ofFloat(bubble2, "alpha", 1f);
        ObjectAnimator transYBubble2 = ObjectAnimator.ofFloat(bubble2, "translationY", 10, 0);
        ObjectAnimator scaleUpYBubble2 = ObjectAnimator.ofFloat(bubble2, "scaleY", 1.2f);
        ObjectAnimator scaleDownXBubble2 = ObjectAnimator.ofFloat(bubble2, "scaleX", 0.95f);
        ObjectAnimator scaleDownYBubble2 = ObjectAnimator.ofFloat(bubble2, "scaleY", 0.8f);
        ObjectAnimator scaleNormalYBubble2 = ObjectAnimator.ofFloat(bubble2, "scaleY", 1f);
        ObjectAnimator scaleNormalXBubble2 = ObjectAnimator.ofFloat(bubble2, "scaleX", 1f);

        AnimatorSet set1 = new AnimatorSet();
        set1.playTogether(transYBubble2, scaleUpYBubble2, fadeInBubble);
        AnimatorSet set2 = new AnimatorSet();
        set2.playTogether(scaleDownXBubble2, scaleDownYBubble2);
        AnimatorSet set3 = new AnimatorSet();
        set3.playTogether(scaleNormalXBubble2, scaleNormalYBubble2);


        final AnimatorSet setFinal = new AnimatorSet();
        setFinal.playSequentially(set1, set2, set3);
        setFinal.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //setFinal.start();
                        /*animDark();*/
                        animCircle1();
                    }
                }, 300);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        setFinal.setDuration(150);
        setFinal.start();
    }

    void animDark() {
        Log.e("Dark pivotX", bubbleDark.getPivotX() + " real"+(bubbleDark.getX()-40)+" GX"+bubbleDark.getX());
        bubbleDark.setPivotX(bubbleDark.getWidth()/4);


        //bubble2.setPivotY(0);
        ObjectAnimator transYBubble2 = ObjectAnimator.ofFloat(bubbleDark, "translationY", 20, 0);
        ObjectAnimator scaleUpYBubble2 = ObjectAnimator.ofFloat(bubbleDark, "scaleY", 1.2f);
        ObjectAnimator scaleDownXBubble2 = ObjectAnimator.ofFloat(bubbleDark, "scaleX", 0.7f);
        ObjectAnimator scaleDownYBubble2 = ObjectAnimator.ofFloat(bubbleDark, "scaleY", 0.8f);
        ObjectAnimator scaleNormalYBubble2 = ObjectAnimator.ofFloat(bubbleDark, "scaleY", 1f);
        ObjectAnimator scaleNormalXBubble2 = ObjectAnimator.ofFloat(bubbleDark, "scaleX", 1f);
        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(bubbleDark, "alpha", 0f);
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(bubbleDark, "alpha", 1f);
        ObjectAnimator fadeOutBubble = ObjectAnimator.ofFloat(bubble2, "alpha", 0f);
        ObjectAnimator fadeInBubble = ObjectAnimator.ofFloat(bubble2, "alpha", 1f);

        AnimatorSet set1 = new AnimatorSet();
        set1.playTogether(transYBubble2, scaleUpYBubble2, fadeIn);
        AnimatorSet set2 = new AnimatorSet();
        set2.playTogether(scaleDownXBubble2, scaleDownYBubble2);
        AnimatorSet set3 = new AnimatorSet();
        set3.playTogether(scaleNormalXBubble2,  scaleNormalYBubble2);

        /*AnimatorSet set4 = new AnimatorSet();
        set4.playTogether(fadeOut, fadeOutBubble);*/


        final AnimatorSet setFinal = new AnimatorSet();
        setFinal.playSequentially(set1, set2, set3);
        setFinal.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //anim();
                        animCircle2();
                    }
                }, 300);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        setFinal.setDuration(150);
        setFinal.start();
    }

    void animCircle2() {
        int fOutTime = 200, cTime = 300;
        ObjectAnimator om1 = ObjectAnimator.ofFloat(circleA1, "alpha", 1f);
        om1.setDuration(cTime);
        ObjectAnimator om2 = ObjectAnimator.ofFloat(circleA2, "alpha", 1f);
        om2.setDuration(cTime);
        ObjectAnimator om3 = ObjectAnimator.ofFloat(circleA3, "alpha", 1f);
        om3.setDuration(cTime);
        ObjectAnimator om4 = ObjectAnimator.ofFloat(circleA4, "alpha", 1f);
        om4.setDuration(cTime);

        ObjectAnimator om1Out = ObjectAnimator.ofFloat(circleA1, "alpha", .5f);
        om1Out.setDuration(cTime);
        ObjectAnimator om2Out = ObjectAnimator.ofFloat(circleA2, "alpha", .5f);
        om2Out.setDuration(cTime);

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
        AnimatorSet a3 = new AnimatorSet();
        a3.playSequentially(om2,om1);
        circle1On.add(a3);

        setCircle1On.playSequentially(circle1On);

        setCircle1On.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fadeoutAll();
                    }
                }, 200);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        setCircle1On.start();


    }

    void animCircle1() {
        //Toast.makeText(this, "reach", Toast.LENGTH_SHORT).show();
        int fOutTime = 200, cTime = 300;
        ObjectAnimator omB1 = ObjectAnimator.ofFloat(circleB1, "alpha", 1f);
        omB1.setDuration(cTime);
        ObjectAnimator omB2 = ObjectAnimator.ofFloat(circleB2, "alpha", 1f);
        omB2.setDuration(cTime);
        ObjectAnimator omB3 = ObjectAnimator.ofFloat(circleB3, "alpha", 1f);
        omB3.setDuration(cTime);
        ObjectAnimator omB4 = ObjectAnimator.ofFloat(circleB4, "alpha", 1f);
        omB4.setDuration(cTime);

        ObjectAnimator omB1Out = ObjectAnimator.ofFloat(circleB1, "alpha", .6f);
        omB1Out.setDuration(cTime);
        ObjectAnimator omB2Out = ObjectAnimator.ofFloat(circleB2, "alpha", .6f);
        omB2Out.setDuration(cTime);

        final List<Animator> circle2On = new ArrayList<>();
        circle2On.add(omB1);
        circle2On.add(omB2);
        AnimatorSet an = new AnimatorSet();
        an.playTogether(omB3, omB1Out);
        circle2On.add(an);
        AnimatorSet an2 = new AnimatorSet();
        an2.playTogether(omB4, omB2Out);
        circle2On.add(an2);
        AnimatorSet anfinal = new AnimatorSet();
        anfinal.playSequentially(circle2On);


        anfinal.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                animDark();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        anfinal.start();
    }

    void fadeoutAll(){
        int fOutTime=100;
        ObjectAnimator om1F = ObjectAnimator.ofFloat(circleA1, "alpha", 0f);
        om1F.setDuration(fOutTime);
        ObjectAnimator om2F = ObjectAnimator.ofFloat(circleA2, "alpha", 0f);
        om2F.setDuration(fOutTime);
        ObjectAnimator om3F = ObjectAnimator.ofFloat(circleA3, "alpha", 0f);
        om3F.setDuration(fOutTime);
        ObjectAnimator om4F = ObjectAnimator.ofFloat(circleA4, "alpha", 0f);
        om4F.setDuration(fOutTime);

        ObjectAnimator omB1F = ObjectAnimator.ofFloat(circleB1, "alpha", 0f);
        omB1F.setDuration(fOutTime);
        ObjectAnimator omB2F = ObjectAnimator.ofFloat(circleB2, "alpha", 0f);
        omB2F.setDuration(fOutTime);
        ObjectAnimator omB3F = ObjectAnimator.ofFloat(circleB3, "alpha", 0f);
        omB3F.setDuration(fOutTime);
        ObjectAnimator omB4F = ObjectAnimator.ofFloat(circleB4, "alpha", 0f);
        omB4F.setDuration(fOutTime);

        final ObjectAnimator fade2 = ObjectAnimator.ofFloat(bubbleDark, "alpha", 0f);
        fade2.setDuration(fOutTime);
        final ObjectAnimator fade1 = ObjectAnimator.ofFloat(bubble2, "alpha", 0f);
        fade1.setDuration(fOutTime);

        ObjectAnimator consFadeOut = ObjectAnimator.ofFloat(consLay, "alpha", 0f);
        consFadeOut.setDuration(150);
        ObjectAnimator consFadeIn = ObjectAnimator.ofFloat(consLay, "alpha", 1f);
        consFadeIn.setDuration(150);

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
        AnimatorSet set1=new AnimatorSet();
        set1.playTogether(fadeoff);

        AnimatorSet set=new AnimatorSet();
        set.playSequentially(consFadeOut,set1,consFadeIn);
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        anim();
                    }
                },300);

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        set.start();

    }
}
