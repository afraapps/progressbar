/*
 * Copyright (c) 2016 Zhang Hai <Dreaming.in.Code.ZH@Gmail.com>
 * All Rights Reserved.
 */

package ir.afraapps.widget.progressbar;

import android.content.Context;
import android.graphics.Canvas;

import androidx.annotation.NonNull;

class HorizontalProgressBackgroundDrawable extends BaseSingleHorizontalProgressDrawable
        implements ShowBackgroundDrawable {

    private boolean mShow = true;

    public HorizontalProgressBackgroundDrawable(Context context) {
        super(context);
    }

    @Override
    public boolean getShowBackground() {
        return mShow;
    }

    @Override
    public void setShowBackground(boolean show) {
        if (mShow != show) {
            mShow = show;
            invalidateSelf();
        }
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        if (mShow) {
            super.draw(canvas);
        }
    }
}
