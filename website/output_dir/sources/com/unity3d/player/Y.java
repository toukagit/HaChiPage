package com.unity3d.player;

import android.view.SurfaceHolder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: base/dex/classes.dex */
public final class Y implements SurfaceHolder.Callback {
    final /* synthetic */ Z a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Y(Z z) {
        this.a = z;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        UnityPlayer unityPlayer;
        UnityPlayer unityPlayer2;
        unityPlayer = this.a.b;
        unityPlayer.updateGLDisplay(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme, surfaceHolder.getSurface());
        unityPlayer2 = this.a.b;
        unityPlayer2.sendSurfaceChangedEvent();
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        UnityPlayer unityPlayer;
        C c;
        UnityPlayer unityPlayer2;
        unityPlayer = this.a.b;
        unityPlayer.updateGLDisplay(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme, surfaceHolder.getSurface());
        Z z = this.a;
        c = z.c;
        unityPlayer2 = z.b;
        B b = c.b;
        if (b == null || b.getParent() != null) {
            return;
        }
        unityPlayer2.addView(c.b);
        unityPlayer2.bringChildToFront(c.b);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        C c;
        C0000a c0000a;
        UnityPlayer unityPlayer;
        Z z = this.a;
        c = z.c;
        c0000a = z.a;
        c.getClass();
        if (PlatformSupport.NOUGAT_SUPPORT && c.a != null) {
            if (c.b == null) {
                c.b = new B(c.a);
            }
            c.b.a(c0000a);
        }
        unityPlayer = this.a.b;
        unityPlayer.updateGLDisplay(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme, null);
    }
}
