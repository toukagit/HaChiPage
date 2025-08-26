package com.unity3d.player;
/* renamed from: com.unity3d.player.u0  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
final class RunnableC0041u0 implements Runnable {
    final /* synthetic */ float a;
    final /* synthetic */ UnityPlayer b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0041u0(UnityPlayer unityPlayer, float f) {
        this.b = unityPlayer;
        this.a = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Z z;
        z = this.b.mGlView;
        z.a(this.a);
    }
}
