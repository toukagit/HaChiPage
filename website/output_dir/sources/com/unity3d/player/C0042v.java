package com.unity3d.player;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unity3d.player.v  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
public final class C0042v extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ NetworkConnectivityNougat a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0042v(NetworkConnectivityNougat networkConnectivityNougat) {
        this.a = networkConnectivityNougat;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        super.onAvailable(network);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        NetworkConnectivityNougat networkConnectivityNougat;
        int i;
        super.onCapabilitiesChanged(network, networkCapabilities);
        if (networkCapabilities.hasTransport(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme)) {
            networkConnectivityNougat = this.a;
            i = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector;
        } else {
            networkConnectivityNougat = this.a;
            i = 2;
        }
        networkConnectivityNougat.b = i;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        super.onLost(network);
        this.a.b = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onUnavailable() {
        super.onUnavailable();
        this.a.b = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
    }
}
