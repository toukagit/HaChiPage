package com.unity3d.player;
/* loaded from: base/dex/classes.dex */
final class O0 implements Runnable {
    final /* synthetic */ P0 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public O0(P0 p0) {
        this.a = p0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        V0 v0 = this.a.a.h;
        N0 m63$$Nest$fgetf = V0.m63$$Nest$fgetf(v0);
        if (m63$$Nest$fgetf != null) {
            V0.m58$$Nest$fgeta(v0).removeViewFromPlayer(m63$$Nest$fgetf);
            V0.m67$$Nest$fputi(v0, false);
            V0.m63$$Nest$fgetf(v0).destroyPlayer();
            V0.m65$$Nest$fputf(v0, null);
            U0 m60$$Nest$fgetc = V0.m60$$Nest$fgetc(v0);
            if (m60$$Nest$fgetc != null) {
                ((C0033q0) m60$$Nest$fgetc).a();
            }
        }
        V0.m58$$Nest$fgeta(this.a.a.h).onResume();
    }
}
