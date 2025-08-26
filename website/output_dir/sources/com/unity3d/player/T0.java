package com.unity3d.player;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: base/dex/classes.dex */
public final class T0 implements Runnable {
    final /* synthetic */ V0 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public T0(V0 v0) {
        this.a = v0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        N0 n0;
        UnityPlayer unityPlayer;
        UnityPlayer unityPlayer2;
        N0 n02;
        U0 u0;
        V0 v0 = this.a;
        n0 = v0.f;
        if (n0 != null) {
            unityPlayer2 = v0.a;
            unityPlayer2.removeViewFromPlayer(n0);
            v0.i = false;
            n02 = v0.f;
            n02.destroyPlayer();
            v0.f = null;
            u0 = v0.c;
            if (u0 != null) {
                ((C0033q0) u0).a();
            }
        }
        unityPlayer = this.a.a;
        unityPlayer.onResume();
    }
}
