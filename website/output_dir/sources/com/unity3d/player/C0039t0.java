package com.unity3d.player;

import android.content.Context;
import android.view.OrientationEventListener;
/* renamed from: com.unity3d.player.t0  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
final class C0039t0 extends OrientationEventListener {
    final /* synthetic */ UnityPlayer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0039t0(UnityPlayer unityPlayer, Context context, int i) {
        super(context, i);
        this.a = unityPlayer;
    }

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int i) {
        int i2;
        UnityPlayer unityPlayer = this.a;
        I0 i0 = unityPlayer.m_MainThread;
        i2 = unityPlayer.mNaturalOrientation;
        i0.f = i2;
        i0.g = i;
        i0.a(G0.j);
    }
}
