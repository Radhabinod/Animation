package com.techindustan.animationpractice.anim;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;

import com.appolica.flubber.AnimationBody;
import com.appolica.flubber.Flubber;
import com.appolica.flubber.animation.providers.BaseProvider;
import com.appolica.flubber.utils.DimensionUtils;

/**
 * Created by binod on 17/4/18.
 */

public class SqueezeupCustom extends BaseProvider {

    public SqueezeupCustom() {
        super(Flubber.Curve.SPRING);
    }

    @Override
    public Animator getAnimationFor(AnimationBody animationBody, View view) {
        final float startY = DimensionUtils.dp2px(300);
        final float endY = 0f;
        final PropertyValuesHolder translationPVH =
                PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, startY, endY);
        final float startScaleY = 3 * animationBody.getForce();
        final float endScaleY = 1f;
        final PropertyValuesHolder scalePVH =
                PropertyValuesHolder.ofFloat(View.SCALE_Y, startScaleY, endScaleY);
        final ObjectAnimator animation =
                ObjectAnimator.ofPropertyValuesHolder(view, translationPVH, scalePVH);
        return animation;
    }
}
