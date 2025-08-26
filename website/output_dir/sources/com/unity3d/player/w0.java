package com.unity3d.player;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: base/dex/classes.dex */
public final class w0 implements Runnable {
    final /* synthetic */ UnityPlayer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w0(UnityPlayer unityPlayer) {
        this.a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.unity3d.player.a.e eVar;
        UnityPlayer unityPlayer = this.a;
        eVar = unityPlayer.m_SplashScreen;
        unityPlayer.removeView(eVar);
        this.a.m_SplashScreen = null;
    }
}
