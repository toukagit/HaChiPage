package com.unity3d.player;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: base/dex/classes.dex */
public final class S0 implements Runnable {
    final /* synthetic */ V0 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public S0(V0 v0) {
        this.a = v0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        N0 n0;
        UnityPlayer unityPlayer;
        N0 n02;
        V0 v0 = this.a;
        n0 = v0.f;
        if (n0 != null) {
            unityPlayer = v0.a;
            unityPlayer.addViewToPlayer(n0, true);
            V0 v02 = this.a;
            v02.i = true;
            n02 = v02.f;
            n02.requestFocus();
        }
    }
}
