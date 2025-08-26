package com.unity3d.player;

import android.content.DialogInterface;
/* loaded from: base/dex/classes.dex */
final class Q implements DialogInterface.OnCancelListener {
    final /* synthetic */ T a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q(T t) {
        this.a = t;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        InterfaceC0045x interfaceC0045x = this.a.f;
        if (interfaceC0045x != null) {
            ((C0003b0) interfaceC0045x).a();
        }
    }
}
