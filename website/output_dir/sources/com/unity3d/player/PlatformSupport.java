package com.unity3d.player;

import android.os.Build;
/* loaded from: base/dex/classes.dex */
public class PlatformSupport {
    static final boolean MARSHMALLOW_SUPPORT;
    static final boolean NOUGAT_SUPPORT;
    static final boolean PIE_SUPPORT;
    static final boolean RED_VELVET_CAKE_SUPPORT;
    static final boolean SNOW_CONE_SUPPORT;
    static final boolean TIRAMISU_SUPPORT;
    static final boolean UPSIDE_DOWN_CAKE_SUPPORT;
    static final boolean VANILLA_ICE_CREAM_SUPPORT;

    static {
        int i = Build.VERSION.SDK_INT;
        MARSHMALLOW_SUPPORT = i >= 23 ? com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector : com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        NOUGAT_SUPPORT = i >= 24 ? com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector : com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        PIE_SUPPORT = i >= 28 ? com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector : com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        RED_VELVET_CAKE_SUPPORT = i >= 30 ? com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector : com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        SNOW_CONE_SUPPORT = i >= 31 ? com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector : com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        TIRAMISU_SUPPORT = i >= 33 ? com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector : com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        UPSIDE_DOWN_CAKE_SUPPORT = i >= 34 ? com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector : com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        VANILLA_ICE_CREAM_SUPPORT = i < 35 ? com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme : true;
    }
}
