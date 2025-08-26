package com.unity3d.player;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: base/dex/classes.dex */
public final class R0 implements Runnable {
    final /* synthetic */ V0 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public R0(V0 v0) {
        this.a = v0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UnityPlayer unityPlayer;
        unityPlayer = this.a.a;
        unityPlayer.onPause();
    }
}
