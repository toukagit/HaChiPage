package com.unity3d.player;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unity3d.player.n0  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
public final class DialogInterface$OnClickListenerC0027n0 implements DialogInterface.OnClickListener {
    final /* synthetic */ UnityPlayer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnClickListenerC0027n0(UnityPlayer unityPlayer) {
        this.a = unityPlayer;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.finish();
    }
}
