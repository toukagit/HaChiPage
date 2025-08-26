package com.unity3d.player;

import android.view.KeyEvent;
import android.widget.TextView;
/* loaded from: base/dex/classes.dex */
final class I implements TextView.OnEditorActionListener {
    final /* synthetic */ J a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public I(J j) {
        this.a = j;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description) {
            J j = this.a;
            j.a(j.b(), false);
        }
        return false;
    }
}
