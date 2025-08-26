package com.unity3d.player;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.EditText;
/* loaded from: base/dex/classes.dex */
final class M extends EditText {
    final /* synthetic */ J a;
    final /* synthetic */ N b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(N n, Context context, J j) {
        super(context);
        this.b = n;
        this.a = j;
    }

    @Override // android.widget.TextView
    public final void onEditorAction(int i) {
        if (i == com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description) {
            J j = this.a;
            j.a(j.b(), false);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.FreeformWindowSize_tablet) {
            N n = this.b;
            n.a(n.b(), true);
            return true;
        } else if (i == 84) {
            return true;
        } else {
            if (i == 66 && keyEvent.getAction() == 0 && (getInputType() & 131072) == 0) {
                J j = this.a;
                j.a(j.b(), false);
                return true;
            }
            return super.onKeyPreIme(i, keyEvent);
        }
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        this.a.b.reportSoftInputSelection(i, i2 - i);
    }
}
