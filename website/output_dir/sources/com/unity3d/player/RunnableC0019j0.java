package com.unity3d.player;
/* renamed from: com.unity3d.player.j0  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
final class RunnableC0019j0 implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ UnityPlayer b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0019j0(UnityPlayer unityPlayer, boolean z) {
        this.b = unityPlayer;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        J j = this.b.mSoftInput;
        if (j != null) {
            j.a(this.a);
        }
    }
}
