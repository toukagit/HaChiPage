package com.google.androidgamesdk;

import android.view.Choreographer;
/* loaded from: base/dex/classes.dex */
final class a implements Runnable {
    final /* synthetic */ ChoreographerCallback a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChoreographerCallback choreographerCallback) {
        this.a = choreographerCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Choreographer.getInstance().postFrameCallback(this.a);
    }
}
