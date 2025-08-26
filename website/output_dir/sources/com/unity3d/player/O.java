package com.unity3d.player;

import android.content.DialogInterface;
/* loaded from: base/dex/classes.dex */
final class O implements DialogInterface.OnDismissListener {
    final /* synthetic */ T a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public O(T t) {
        this.a = t;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.invokeOnClose();
    }
}
