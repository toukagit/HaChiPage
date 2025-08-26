package com.unity3d.player;
/* loaded from: base/dex/classes.dex */
final class L implements Runnable {
    final /* synthetic */ N a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public L(N n) {
        this.a = n;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.c.requestFocus();
        this.a.f();
    }
}
