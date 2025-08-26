package com.unity3d.player;

import android.util.Log;
/* renamed from: com.unity3d.player.u  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
abstract class AbstractC0040u {
    protected static boolean a = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public static void Log(int i, String str) {
        if (a) {
            return;
        }
        if (i == com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description) {
            Log.e("Unity", str);
        }
        if (i == com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.app_name) {
            Log.w("Unity", str);
        }
    }
}
