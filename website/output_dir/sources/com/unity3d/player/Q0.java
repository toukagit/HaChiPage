package com.unity3d.player;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: base/dex/classes.dex */
public final class Q0 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ boolean e;
    final /* synthetic */ long f;
    final /* synthetic */ long g;
    final /* synthetic */ V0 h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q0(V0 v0, String str, int i, int i2, int i3, boolean z, long j, long j2) {
        this.h = v0;
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = z;
        this.f = j;
        this.g = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        V0 v0 = this.h;
        if (V0.m63$$Nest$fgetf(v0) != null) {
            AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.app_name, "Video already playing");
            V0 v02 = this.h;
            V0.m66$$Nest$fputg(v02, 2);
            V0.m61$$Nest$fgetd(v02).release();
            return;
        }
        V0.m65$$Nest$fputf(v0, new N0(V0.m59$$Nest$fgetb(this.h), this.a, this.b, this.c, this.d, this.e, this.f, this.g, new P0(this)));
        V0 v03 = this.h;
        if (V0.m63$$Nest$fgetf(v03) != null) {
            V0.m58$$Nest$fgeta(v03).bringToFront();
            V0 v04 = this.h;
            V0.m58$$Nest$fgeta(v04).addView(V0.m63$$Nest$fgetf(v04));
        }
    }
}
