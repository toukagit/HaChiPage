package com.unity3d.player;

import android.view.ViewTreeObserver;
/* loaded from: base/dex/classes.dex */
final class P implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ T a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public P(T t) {
        this.a = t;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.a.reportSoftInputArea();
        this.a.h.b();
    }
}
