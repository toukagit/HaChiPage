package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: base/dex/classes.dex */
public final class I0 extends Thread {
    Handler a;
    boolean b;
    boolean c;
    int d;
    int e;
    int f;
    int g;
    int h;
    final /* synthetic */ UnityPlayer i;

    /* renamed from: -$$Nest$ma */
    public static /* bridge */ /* synthetic */ void m11$$Nest$ma(I0 i0, G0 g0) {
        i0.a(g0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public I0(UnityPlayer unityPlayer) {
        this.i = unityPlayer;
        this.b = false;
        this.c = false;
        this.d = 2;
        this.e = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        this.h = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.app_name;
    }

    public void a(G0 g0) {
        Handler handler = this.a;
        if (handler != null) {
            Message.obtain(handler, 2269, g0).sendToTarget();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        setName("UnityMain");
        Looper.prepare();
        this.a = new Handler(Looper.myLooper(), new H0(this));
        Looper.loop();
    }
}
