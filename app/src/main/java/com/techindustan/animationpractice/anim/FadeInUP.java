package com.techindustan.animationpractice.anim;

import android.animation.ObjectAnimator;
import android.support.annotation.NonNull;
import android.view.View;

import com.appolica.flubber.AnimationBody;
import com.appolica.flubber.animation.providers.BaseFadeIn;
import com.appolica.flubber.utils.DimensionUtils;

/**
 * Created by binod on 17/4/18.
 */

public class FadeInUP extends BaseFadeIn {
    @NonNull
    protected ObjectAnimator getTranslation(AnimationBody animationBody, View view) {

        final float startY = DimensionUtils.dp2px(100) * animationBody.getForce();
        final float endY = 0f;

        final ObjectAnimator translateAnimation =
                ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, startY, endY);

        return translateAnimation;
    }
}
