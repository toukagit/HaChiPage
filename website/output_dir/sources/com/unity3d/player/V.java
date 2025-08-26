package com.unity3d.player;

import android.database.ContentObserver;
import android.os.Handler;
/* loaded from: base/dex/classes.dex */
final class V extends ContentObserver {
    private U a;

    public V(Handler handler, U u) {
        super(handler);
        this.a = u;
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return super.deliverSelfNotifications();
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        U u = this.a;
        if (u != null) {
            ((OrientationLockListener) u).b();
        }
    }
}
