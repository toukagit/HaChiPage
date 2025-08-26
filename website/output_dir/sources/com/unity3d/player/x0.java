package com.unity3d.player;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: base/dex/classes.dex */
public final class x0 implements Runnable {
    final /* synthetic */ UnityPlayer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x0(UnityPlayer unityPlayer) {
        this.a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.nativeSendSurfaceChangedEvent();
    }
}
