package com.unity3d.player;

import java.util.concurrent.Semaphore;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: base/dex/classes.dex */
public final class B0 implements Runnable {
    final /* synthetic */ Semaphore a;
    final /* synthetic */ UnityPlayer b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B0(UnityPlayer unityPlayer, Semaphore semaphore) {
        this.b = unityPlayer;
        this.a = semaphore;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.shutdown();
        this.a.release();
    }
}
