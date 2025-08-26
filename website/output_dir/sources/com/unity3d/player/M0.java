package com.unity3d.player;
/* loaded from: base/dex/classes.dex */
public final class M0 implements Runnable {
    private N0 a;
    private boolean b = false;

    public M0(N0 n0) {
        this.a = n0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        if (this.b) {
            return;
        }
        int i = N0.z;
        this.a.cancelOnPrepare();
    }
}
