package com.unity3d.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: base/dex/classes.dex */
public final class N extends J {
    private boolean h;
    private Handler i;
    private Runnable j;

    public N(Context context, UnityPlayer unityPlayer) {
        super(context, unityPlayer);
        this.h = false;
    }

    @Override // com.unity3d.player.J
    public final void a(boolean z) {
        EditText editText;
        int i;
        this.d = z;
        if (z) {
            editText = this.c;
            i = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.FreeformWindowSize_tablet;
        } else {
            editText = this.c;
            i = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        }
        editText.setVisibility(i);
        this.c.invalidate();
        this.c.requestLayout();
    }

    @Override // com.unity3d.player.J
    public final void c() {
        Runnable runnable;
        Handler handler = this.i;
        if (handler != null && (runnable = this.j) != null) {
            handler.removeCallbacks(runnable);
        }
        this.b.removeView(this.c);
        this.h = false;
        invokeOnClose();
    }

    @Override // com.unity3d.player.J
    protected EditText createEditText(J j) {
        return new M(this, this.a, j);
    }

    @Override // com.unity3d.player.J
    public final boolean d() {
        return false;
    }

    @Override // com.unity3d.player.J
    public final void e() {
        if (this.h) {
            return;
        }
        this.b.addView(this.c);
        this.b.bringChildToFront(this.c);
        this.c.setVisibility(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme);
        this.c.requestFocus();
        this.j = new L(this);
        Handler handler = new Handler(Looper.getMainLooper());
        this.i = handler;
        handler.postDelayed(this.j, 400L);
        this.h = true;
    }
}
