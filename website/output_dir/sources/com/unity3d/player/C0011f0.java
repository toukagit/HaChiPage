package com.unity3d.player;
/* renamed from: com.unity3d.player.f0  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
final class C0011f0 implements InterfaceC0046y {
    final /* synthetic */ RunnableC0013g0 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0011f0(RunnableC0013g0 runnableC0013g0) {
        this.a = runnableC0013g0;
    }

    public final void a() {
        RunnableC0013g0 runnableC0013g0 = this.a;
        runnableC0013g0.a = true;
        if (runnableC0013g0.b) {
            runnableC0013g0.c.release();
        }
    }
}
