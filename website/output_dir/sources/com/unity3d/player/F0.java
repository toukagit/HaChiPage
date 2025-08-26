package com.unity3d.player;

import android.telephony.PhoneStateListener;
/* loaded from: base/dex/classes.dex */
final class F0 extends PhoneStateListener {
    final /* synthetic */ UnityPlayer a;

    private F0(UnityPlayer unityPlayer) {
        this.a = unityPlayer;
    }

    @Override // android.telephony.PhoneStateListener
    public final void onCallStateChanged(int i, String str) {
        UnityPlayer.m40$$Nest$mnativeMuteMasterAudio(this.a, i == com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector);
    }
}
