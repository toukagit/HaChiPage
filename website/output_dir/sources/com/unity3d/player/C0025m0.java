package com.unity3d.player;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unity3d.player.m0  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
public final class C0025m0 extends J0 {
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ UnityPlayer d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0025m0(UnityPlayer unityPlayer, int i, int i2) {
        super(unityPlayer);
        this.d = unityPlayer;
        this.b = i;
        this.c = i2;
    }

    @Override // com.unity3d.player.J0
    public final void a() {
        this.d.nativeSetInputSelection(this.b, this.c);
    }
}
