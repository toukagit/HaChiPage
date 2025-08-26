package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.view.Surface;
import java.nio.ByteBuffer;
/* loaded from: base/dex/classes.dex */
public class Camera2Wrapper implements com.unity3d.player.a.b {
    private Context a;
    private C0034r b = null;

    public Camera2Wrapper(Context context) {
        this.a = context;
        initCamera2Jni();
    }

    private final native void deinitCamera2Jni();

    private final native void initCamera2Jni();

    private final native void nativeFrameReady(Object obj, Object obj2, Object obj3, int i, int i2, int i3);

    private final native void nativeSurfaceTextureReady(Object obj);

    public final void a() {
        deinitCamera2Jni();
        closeCamera2();
    }

    public final void a(Object obj) {
        nativeSurfaceTextureReady(obj);
    }

    public final void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3) {
        nativeFrameReady(byteBuffer, byteBuffer2, byteBuffer3, i, i2, i3);
    }

    protected void closeCamera2() {
        C0034r c0034r = this.b;
        if (c0034r != null) {
            c0034r.a();
        }
        this.b = null;
    }

    protected int getCamera2Count() {
        return C0034r.a(this.a);
    }

    protected int getCamera2FocalLengthEquivalent(int i) {
        return C0034r.a(this.a, i);
    }

    protected int[] getCamera2Resolutions(int i) {
        return C0034r.b(this.a, i);
    }

    protected int getCamera2SensorOrientation(int i) {
        return C0034r.c(this.a, i);
    }

    protected Rect getFrameSizeCamera2() {
        C0034r c0034r = this.b;
        return c0034r != null ? c0034r.c() : new Rect();
    }

    protected boolean initializeCamera2(int i, int i2, int i3, int i4, int i5, Surface surface) {
        if (this.b != null || UnityPlayer.currentActivity == null) {
            return false;
        }
        C0034r c0034r = new C0034r(this);
        this.b = c0034r;
        return c0034r.a(this.a, i, i2, i3, i4, i5, surface);
    }

    protected boolean isCamera2AutoFocusPointSupported(int i) {
        return C0034r.d(this.a, i);
    }

    protected boolean isCamera2FrontFacing(int i) {
        return C0034r.e(this.a, i);
    }

    protected void pauseCamera2() {
        C0034r c0034r = this.b;
        if (c0034r != null) {
            c0034r.d();
        }
    }

    protected boolean setAutoFocusPoint(float f, float f2) {
        C0034r c0034r = this.b;
        if (c0034r != null) {
            return c0034r.a(f, f2);
        }
        return false;
    }

    protected void startCamera2() {
        C0034r c0034r = this.b;
        if (c0034r != null) {
            c0034r.h();
        }
    }

    protected void stopCamera2() {
        C0034r c0034r = this.b;
        if (c0034r != null) {
            c0034r.i();
        }
    }
}
