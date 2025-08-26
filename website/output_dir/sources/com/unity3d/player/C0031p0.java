package com.unity3d.player;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unity3d.player.p0  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
public final class C0031p0 extends J0 {
    final /* synthetic */ boolean b;
    final /* synthetic */ UnityPlayer c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0031p0(UnityPlayer unityPlayer, boolean z) {
        super(unityPlayer);
        this.c = unityPlayer;
        this.b = z;
    }

    @Override // com.unity3d.player.J0
    public final void a() {
        this.c.nativeSetKeyboardIsVisible(this.b);
    }
}
