package com.unity3d.player;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.EditText;
/* loaded from: base/dex/classes.dex */
final class S extends EditText {
    final /* synthetic */ J a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S(Context context, J j) {
        super(context);
        this.a = j;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.FreeformWindowSize_tablet) {
            J j = this.a;
            j.a(j.b(), true);
            return true;
        } else if (i == 84) {
            return true;
        } else {
            if (i == 66 && keyEvent.getAction() == 0 && (getInputType() & 131072) == 0) {
                J j2 = this.a;
                j2.a(j2.b(), false);
                return true;
            } else if (i == 111 && keyEvent.getAction() == 0) {
                J j3 = this.a;
                j3.a(j3.b(), true);
                return true;
            } else {
                return super.onKeyPreIme(i, keyEvent);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            requestFocus();
            this.a.f();
        }
    }
}
