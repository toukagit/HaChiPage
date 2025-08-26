package com.unity3d.player;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: base/dex/classes.dex */
public abstract class J0 implements Runnable {
    final /* synthetic */ UnityPlayer a;

    private J0(UnityPlayer unityPlayer) {
        this.a = unityPlayer;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.isFinishing()) {
            return;
        }
        a();
    }
}
