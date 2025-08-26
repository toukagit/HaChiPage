package com.unity3d.player;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: base/dex/classes.dex */
public final class P0 implements L0 {
    final /* synthetic */ Q0 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public P0(Q0 q0) {
        this.a = q0;
    }

    public final void a(int i) {
        ReentrantLock reentrantLock;
        ReentrantLock reentrantLock2;
        Semaphore semaphore;
        boolean z;
        reentrantLock = this.a.h.e;
        reentrantLock.lock();
        V0 v0 = this.a.h;
        v0.g = i;
        if (i == com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.FreeformWindowSize_phone) {
            z = v0.i;
            if (z) {
                v0.runOnUiThread(new O0(this));
            }
        }
        if (i != 0) {
            semaphore = this.a.h.d;
            semaphore.release();
        }
        reentrantLock2 = this.a.h.e;
        reentrantLock2.unlock();
    }
}
