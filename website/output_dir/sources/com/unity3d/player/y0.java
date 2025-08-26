package com.unity3d.player;

import android.view.Surface;
import java.util.concurrent.Semaphore;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: base/dex/classes.dex */
public final class y0 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ Surface b;
    final /* synthetic */ Semaphore c;
    final /* synthetic */ UnityPlayer d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y0(UnityPlayer unityPlayer, int i, Surface surface, Semaphore semaphore) {
        this.d = unityPlayer;
        this.a = i;
        this.b = surface;
        this.c = semaphore;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.nativeRecreateGfxState(this.a, this.b);
        this.c.release();
    }
}
