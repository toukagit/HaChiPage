package com.unity3d.player;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unity3d.player.l0  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
public final class C0023l0 extends J0 {
    final /* synthetic */ boolean b;
    final /* synthetic */ String c;
    final /* synthetic */ int d;
    final /* synthetic */ UnityPlayer e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0023l0(UnityPlayer unityPlayer, boolean z, String str, int i) {
        super(unityPlayer);
        this.e = unityPlayer;
        this.b = z;
        this.c = str;
        this.d = i;
    }

    @Override // com.unity3d.player.J0
    public final void a() {
        if (this.b) {
            this.e.nativeSoftInputCanceled();
        } else {
            String str = this.c;
            if (str != null) {
                this.e.nativeSetInputString(str);
            }
        }
        if (this.d == com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector) {
            this.e.nativeSoftInputClosed();
        }
    }
}
