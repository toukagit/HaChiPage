package com.unity3d.player;

import java.util.concurrent.Semaphore;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: base/dex/classes.dex */
public final class C0 implements Runnable {
    final /* synthetic */ Semaphore a;
    final /* synthetic */ UnityPlayer b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0(UnityPlayer unityPlayer, Semaphore semaphore) {
        this.b = unityPlayer;
        this.a = semaphore;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean nativePause;
        nativePause = this.b.nativePause();
        if (nativePause) {
            UnityPlayer unityPlayer = this.b;
            unityPlayer.mQuitting = true;
            unityPlayer.shutdown();
            this.b.queueDestroy();
        }
        this.a.release();
    }
}
