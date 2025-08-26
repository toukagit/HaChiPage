package com.unity3d.player;
/* loaded from: base/dex/classes.dex */
final class z0 implements Runnable {
    final /* synthetic */ UnityPlayer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z0(UnityPlayer unityPlayer) {
        this.a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        Z z2;
        Z z3;
        Z z4;
        UnityPlayer unityPlayer = this.a;
        z = unityPlayer.mMainDisplayOverride;
        if (z) {
            z4 = unityPlayer.mGlView;
            unityPlayer.removeView(z4);
            return;
        }
        z2 = unityPlayer.mGlView;
        if (z2.getParent() != null) {
            AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.app_name, "Couldn't add view, because it's already assigned to another parent");
            return;
        }
        UnityPlayer unityPlayer2 = this.a;
        z3 = unityPlayer2.mGlView;
        unityPlayer2.addView(z3);
    }
}
