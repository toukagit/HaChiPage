package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
/* loaded from: base/dex/classes.dex */
public class NetworkConnectivity extends Activity {
    protected ConnectivityManager a;

    public NetworkConnectivity(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.a = connectivityManager;
        if (connectivityManager == null) {
            AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "NetworkConnectivity: ConnectivityManager not found");
        }
    }

    public void a() {
    }

    public int b() {
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = this.a;
        if (connectivityManager == null) {
            return com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        }
        if (PlatformSupport.MARSHMALLOW_SUPPORT) {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null && (networkCapabilities = this.a.getNetworkCapabilities(activeNetwork)) != null) {
                if (networkCapabilities.hasTransport(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme)) {
                    return com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector;
                }
                return 2;
            }
        } else {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 0) {
                    return com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector;
                }
                return 2;
            }
        }
        return com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
    }
}
