package com.unity3d.player;
/* renamed from: com.unity3d.player.s0  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
final class RunnableC0037s0 implements Runnable {
    final /* synthetic */ UnityPlayer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0037s0(UnityPlayer unityPlayer) {
        this.a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IUnityPlayerLifecycleEvents iUnityPlayerLifecycleEvents;
        this.a.setupUnityToBePaused();
        this.a.windowFocusChanged(false);
        iUnityPlayerLifecycleEvents = this.a.m_UnityPlayerLifecycleEvents;
        iUnityPlayerLifecycleEvents.onUnityPlayerUnloaded();
    }
}
