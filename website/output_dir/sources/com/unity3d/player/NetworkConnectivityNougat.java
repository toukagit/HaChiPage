package com.unity3d.player;

import android.content.Context;
import android.net.ConnectivityManager;
/* loaded from: base/dex/classes.dex */
public class NetworkConnectivityNougat extends NetworkConnectivity {
    private int b;
    private final ConnectivityManager.NetworkCallback c;

    public NetworkConnectivityNougat(Context context) {
        super(context);
        this.b = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        C0042v c0042v = new C0042v(this);
        this.c = c0042v;
        if (this.a == null) {
            return;
        }
        this.b = super.b();
        this.a.registerDefaultNetworkCallback(c0042v);
    }

    @Override // com.unity3d.player.NetworkConnectivity
    public final void a() {
        ConnectivityManager connectivityManager = this.a;
        if (connectivityManager == null) {
            return;
        }
        connectivityManager.unregisterNetworkCallback(this.c);
    }

    @Override // com.unity3d.player.NetworkConnectivity
    public final int b() {
        return this.b;
    }
}
