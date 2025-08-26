package com.unity3d.player;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unity3d.player.a0  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
public final class RunnableC0001a0 implements Runnable {
    final /* synthetic */ UnityPlayer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0001a0(UnityPlayer unityPlayer) {
        this.a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.nativeResume();
    }
}
