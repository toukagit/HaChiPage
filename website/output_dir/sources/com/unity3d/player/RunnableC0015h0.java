package com.unity3d.player;

import android.widget.EditText;
/* renamed from: com.unity3d.player.h0  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
final class RunnableC0015h0 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ UnityPlayer b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0015h0(UnityPlayer unityPlayer, String str) {
        this.b = unityPlayer;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        EditText editText;
        J j = this.b.mSoftInput;
        if (j == null || (str = this.a) == null || (editText = j.c) == null) {
            return;
        }
        editText.setText(str);
        j.c.setSelection(str.length());
    }
}
