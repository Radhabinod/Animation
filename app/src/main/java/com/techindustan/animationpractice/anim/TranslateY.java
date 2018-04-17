package com.techindustan.animationpractice.anim;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

import com.appolica.flubber.AnimationBody;
import com.appolica.flubber.animation.providers.BaseProvider;

/**
 * Created by binod on 17/4/18.
 */

public class TranslateY extends BaseProvider {
    @Override
    public Animator getAnimationFor(AnimationBody animationBody, View view) {
        return ObjectAnimator.ofFloat(
                view,
                View.TRANSLATION_Y,
                -10,
                animationBody.getEndY());
    }
}
