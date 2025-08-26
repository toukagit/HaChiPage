package com.unity3d.player;

import android.widget.EditText;
/* renamed from: com.unity3d.player.k0  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
final class RunnableC0021k0 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ UnityPlayer c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0021k0(UnityPlayer unityPlayer, int i, int i2) {
        this.c = unityPlayer;
        this.a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        J j = this.c.mSoftInput;
        if (j != null) {
            int i2 = this.a;
            int i3 = this.b;
            EditText editText = j.c;
            if (editText == null || editText.getText().length() < (i = i3 + i2)) {
                return;
            }
            j.c.setSelection(i2, i);
        }
    }
}
