package com.unity3d.player;
/* loaded from: base/dex/classes.dex */
abstract class SoftInputProvider {
    public static int a() {
        int nativeGetSoftInputType = nativeGetSoftInputType();
        int[] b = com.unity3d.player.a.a.b(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.FreeformWindowSize_phone);
        int length = b.length;
        for (int i = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme; i < length; i += com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector) {
            int i2 = b[i];
            if (com.unity3d.player.a.c.a(i2) == nativeGetSoftInputType) {
                return i2;
            }
        }
        return com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector;
    }

    private static final native int nativeGetSoftInputType();
}
