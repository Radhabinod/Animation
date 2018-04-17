package com.techindustan.animationpractice.anim;

import android.view.animation.Interpolator;

import com.appolica.flubber.AnimationBody;
import com.appolica.flubber.interpolator.SpringInterpolator;

/**
 * Created by binod on 17/4/18.
 */

public class SpringCustom implements com.appolica.flubber.Flubber.InterpolatorProvider {
    @Override
    public Interpolator createInterpolatorFor(AnimationBody animationBody) {
        final float damping = 0.5f;//animationBody.getDamping();
        final float velocity =10 ;//animationBody.getVelocity();

        return new SpringInterpolator(damping, velocity);
    }
}
