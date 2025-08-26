package com.unity3d.player;
/* renamed from: com.unity3d.player.d0  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
final class RunnableC0007d0 implements Runnable {
    final /* synthetic */ UnityPlayer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0007d0(UnityPlayer unityPlayer) {
        this.a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Z z;
        z = this.a.mGlView;
        if (z != null) {
            z.b();
        }
    }
}
