package com.unity3d.player;

import android.content.Context;
import android.provider.Settings;
/* loaded from: base/dex/classes.dex */
public class OrientationLockListener implements U {
    private W a;
    private Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OrientationLockListener(Context context) {
        this.b = context;
        this.a = new W(context);
        nativeUpdateOrientationLockState(Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme));
        this.a.a(this);
    }

    public final void a() {
        this.a.a();
        this.a = null;
    }

    public final void b() {
        nativeUpdateOrientationLockState(Settings.System.getInt(this.b.getContentResolver(), "accelerometer_rotation", com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme));
    }

    public final native void nativeUpdateOrientationLockState(int i);
}
