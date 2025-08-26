package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: base/dex/classes.dex */
public final class V0 {
    private UnityPlayer a;
    private U0 c;
    private Context b = null;
    private final Semaphore d = new Semaphore(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme);
    private final ReentrantLock e = new ReentrantLock();
    private N0 f = null;
    private int g = 2;
    private boolean h = false;
    private boolean i = false;

    /* renamed from: -$$Nest$fgeta */
    public static /* bridge */ /* synthetic */ UnityPlayer m58$$Nest$fgeta(V0 v0) {
        return v0.a;
    }

    /* renamed from: -$$Nest$fgetb */
    public static /* bridge */ /* synthetic */ Context m59$$Nest$fgetb(V0 v0) {
        return v0.b;
    }

    /* renamed from: -$$Nest$fgetc */
    public static /* bridge */ /* synthetic */ U0 m60$$Nest$fgetc(V0 v0) {
        return v0.c;
    }

    /* renamed from: -$$Nest$fgetd */
    public static /* bridge */ /* synthetic */ Semaphore m61$$Nest$fgetd(V0 v0) {
        return v0.d;
    }

    /* renamed from: -$$Nest$fgetf */
    public static /* bridge */ /* synthetic */ N0 m63$$Nest$fgetf(V0 v0) {
        return v0.f;
    }

    /* renamed from: -$$Nest$fputf */
    public static /* bridge */ /* synthetic */ void m65$$Nest$fputf(V0 v0, N0 n0) {
        v0.f = n0;
    }

    /* renamed from: -$$Nest$fputg */
    public static /* bridge */ /* synthetic */ void m66$$Nest$fputg(V0 v0, int i) {
        v0.g = i;
    }

    /* renamed from: -$$Nest$fputi */
    public static /* bridge */ /* synthetic */ void m67$$Nest$fputi(V0 v0, boolean z) {
        v0.i = z;
    }

    public V0(UnityPlayer unityPlayer) {
        this.a = null;
        this.a = unityPlayer;
    }

    public final void a() {
        this.e.lock();
        N0 n0 = this.f;
        if (n0 != null) {
            n0.updateVideoLayout();
        }
        this.e.unlock();
    }

    public final boolean a(Context context, String str, int i, int i2, int i3, boolean z, long j, long j2, U0 u0) {
        this.e.lock();
        this.c = u0;
        this.b = context;
        this.d.drainPermits();
        this.g = 2;
        runOnUiThread(new Q0(this, str, i, i2, i3, z, j, j2));
        boolean z2 = false;
        try {
            this.e.unlock();
            this.d.acquire();
            this.e.lock();
            if (this.g != 2) {
                z2 = true;
            }
        } catch (InterruptedException unused) {
        }
        runOnUiThread(new R0(this));
        runOnUiThread((!z2 || this.g == com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.FreeformWindowSize_phone) ? new T0(this) : new S0(this));
        this.e.unlock();
        return z2;
    }

    public final void b() {
        this.e.lock();
        N0 n0 = this.f;
        if (n0 != null) {
            if (this.g == 0) {
                n0.cancelOnPrepare();
            } else if (this.i) {
                boolean a = n0.a();
                this.h = a;
                if (!a) {
                    this.f.pause();
                }
            }
        }
        this.e.unlock();
    }

    public final void c() {
        this.e.lock();
        N0 n0 = this.f;
        if (n0 != null && this.i && !this.h) {
            n0.start();
        }
        this.e.unlock();
    }

    public void runOnUiThread(Runnable runnable) {
        Context context = this.b;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(runnable);
        } else {
            AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.app_name, "Not running from an Activity; Ignoring execution request...");
        }
    }
}
