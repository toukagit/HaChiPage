package com.unity3d.player;

import android.graphics.Rect;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unity3d.player.o0  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
public final class C0029o0 extends J0 {
    final /* synthetic */ Rect b;
    final /* synthetic */ UnityPlayer c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0029o0(UnityPlayer unityPlayer, Rect rect) {
        super(unityPlayer);
        this.c = unityPlayer;
        this.b = rect;
    }

    @Override // com.unity3d.player.J0
    public final void a() {
        UnityPlayer unityPlayer = this.c;
        Rect rect = this.b;
        unityPlayer.nativeSetInputArea(rect.left, rect.top, rect.right, rect.bottom);
    }
}
