package com.unity3d.player.a;

import com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R;
/* loaded from: base/dex/classes.dex */
public abstract /* synthetic */ class a {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[R.string.FreeformWindowSize_phone];
        // fill-array-data instruction
        iArr[0] = 1;
        iArr[1] = 2;
        iArr[2] = 3;
        a = iArr;
    }

    public static /* synthetic */ int a(int i) {
        if (i != 0) {
            return i - 1;
        }
        throw null;
    }

    public static /* synthetic */ int[] b(int i) {
        int[] iArr = new int[i];
        System.arraycopy(a, R.style.BaseUnityTheme, iArr, R.style.BaseUnityTheme, i);
        return iArr;
    }
}
