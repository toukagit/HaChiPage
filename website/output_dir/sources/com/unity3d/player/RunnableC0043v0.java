package com.unity3d.player;

import android.view.WindowManager;
/* renamed from: com.unity3d.player.v0  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
final class RunnableC0043v0 implements Runnable {
    final /* synthetic */ float a;
    final /* synthetic */ UnityPlayer b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0043v0(UnityPlayer unityPlayer, float f) {
        this.b = unityPlayer;
        this.a = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WindowManager.LayoutParams attributes = this.b.m_Window.getAttributes();
        attributes.screenBrightness = this.a;
        this.b.m_Window.setAttributes(attributes);
    }
}
