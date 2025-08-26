package com.unity3d.player;

import android.graphics.Rect;
import java.util.concurrent.Semaphore;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unity3d.player.g0  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
public final class RunnableC0013g0 implements Runnable {
    boolean a = false;
    boolean b = false;
    final /* synthetic */ Semaphore c;
    final /* synthetic */ UnityPlayer d;
    final /* synthetic */ UnityPlayer e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0013g0(UnityPlayer unityPlayer, Semaphore semaphore, UnityPlayer unityPlayer2) {
        this.e = unityPlayer;
        this.c = semaphore;
        this.d = unityPlayer2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.e.reportSoftInputArea(new Rect());
        this.e.reportSoftInputIsVisible(false);
        if (this.e.mSoftInput != null) {
            this.d.setOnHandleFocusListener(new C0009e0(this));
            UnityPlayer unityPlayer = this.e;
            unityPlayer.mSoftInput.g = new C0011f0(this);
            unityPlayer.dismissSoftInput();
        }
    }
}
