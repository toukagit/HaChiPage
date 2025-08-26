package com.unity3d.player;

import android.text.InputFilter;
import android.widget.EditText;
/* renamed from: com.unity3d.player.i0  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
final class RunnableC0017i0 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ UnityPlayer b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0017i0(UnityPlayer unityPlayer, int i) {
        this.b = unityPlayer;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        J j = this.b.mSoftInput;
        if (j != null) {
            int i = this.a;
            EditText editText = j.c;
            if (editText != null) {
                if (i <= 0) {
                    editText.setFilters(new InputFilter[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme]);
                    return;
                }
                InputFilter[] inputFilterArr = new InputFilter[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector];
                inputFilterArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = new InputFilter.LengthFilter(i);
                editText.setFilters(inputFilterArr);
            }
        }
    }
}
