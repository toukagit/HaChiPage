package com.unity3d.player;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unity3d.player.a  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
public final class C0000a extends SurfaceView {
    private float a;
    private UnityPlayer b;

    public C0000a(Context context, UnityPlayer unityPlayer) {
        super(context);
        this.b = unityPlayer;
    }

    public final void a(float f) {
        this.a = f;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int i = f <= 0.0f ? -1 : -2;
        layoutParams.width = i;
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    public final boolean a() {
        return this.a > 0.0f;
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (a()) {
            return this.b.injectEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.a <= 0.0f) {
            super.onMeasure(i, i2);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (size <= 0 || size2 <= 0 || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE || View.MeasureSpec.getMode(i2) != Integer.MIN_VALUE) {
            super.onMeasure(i, i2);
            return;
        }
        float f = size;
        float f2 = size2;
        float f3 = this.a;
        if (f / f2 < f3) {
            size2 = (int) (f / f3);
        } else {
            size = (int) (f2 * f3);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (a()) {
            return this.b.injectEvent(motionEvent);
        }
        return false;
    }
}
