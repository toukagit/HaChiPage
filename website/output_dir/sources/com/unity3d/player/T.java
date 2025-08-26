package com.unity3d.player;

import android.content.Context;
import android.widget.EditText;
/* loaded from: base/dex/classes.dex */
final class T extends J {
    K h;

    public T(Context context, UnityPlayer unityPlayer) {
        super(context, unityPlayer);
    }

    @Override // com.unity3d.player.J
    public final void a(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2, boolean z5, boolean z6) {
        K k = new K(this.a, this.b);
        this.h = k;
        k.a(this, z5, z6);
        this.h.setOnDismissListener(new O(this));
        super.a(str, i, z, z2, z3, z4, str2, i2, z5, z6);
        this.b.getViewTreeObserver().addOnGlobalLayoutListener(new P(this));
        this.c.requestFocus();
        this.h.setOnCancelListener(new Q(this));
    }

    @Override // com.unity3d.player.J
    public final void a(boolean z) {
        this.d = z;
        this.h.a(z);
    }

    @Override // com.unity3d.player.J
    public final void c() {
        this.h.dismiss();
    }

    @Override // com.unity3d.player.J
    protected EditText createEditText(J j) {
        return new S(this.a, j);
    }

    @Override // com.unity3d.player.J
    public final void e() {
        this.h.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportSoftInputArea() {
        if (this.h.isShowing()) {
            this.b.reportSoftInputArea(this.h.a());
        }
    }
}
