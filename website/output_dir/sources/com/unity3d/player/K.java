package com.unity3d.player;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Insets;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: base/dex/classes.dex */
public final class K extends Dialog implements View.OnClickListener {
    protected Context a;
    protected UnityPlayer b;
    protected H c;
    protected J d;

    public K(Context context, UnityPlayer unityPlayer) {
        super(context);
        this.c = null;
        this.d = null;
        this.a = context;
        this.b = unityPlayer;
    }

    public final Rect a() {
        Rect rect = new Rect();
        this.b.getWindowVisibleDisplayFrame(rect);
        int[] iArr = new int[2];
        this.b.getLocationOnScreen(iArr);
        Point point = new Point(rect.left - iArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme], rect.height() - this.c.getHeight());
        Point point2 = new Point();
        getWindow().getWindowManager().getDefaultDisplay().getSize(point2);
        int height = this.b.getHeight();
        int i = height - point2.y;
        int i2 = height - point.y;
        int height2 = this.c.getHeight() + i;
        UnityPlayer unityPlayer = this.b;
        if (i2 != height2) {
            unityPlayer.reportSoftInputIsVisible(true);
        } else {
            unityPlayer.reportSoftInputIsVisible(false);
        }
        return new Rect(point.x, point.y, this.c.getWidth(), i2);
    }

    public final void a(J j, boolean z, boolean z2) {
        this.d = j;
        Window window = getWindow();
        window.requestFeature(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.x = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        attributes.y = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        window.setAttributes(attributes);
        b();
        this.c = createSoftInputView(this.d.c);
        window.setLayout(-1, -2);
        window.clearFlags(2);
        window.clearFlags(134217728);
        window.clearFlags(67108864);
        if (!z2) {
            window.addFlags(32);
            window.addFlags(262144);
        }
        a(z);
        getWindow().setSoftInputMode(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.app_name);
    }

    public final void a(boolean z) {
        H h = this.c;
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) h.b.getLayoutParams();
            layoutParams.height = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector;
            h.b.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) h.a.getLayoutParams();
            layoutParams2.height = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector;
            h.a.setLayoutParams(layoutParams2);
            Rect rect = h.e;
            h.setPadding(rect.left, rect.top, rect.right, rect.bottom);
            h.setVisibility(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.FreeformWindowSize_tablet);
        } else {
            h.setVisibility(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme);
            Rect rect2 = h.d;
            h.setPadding(rect2.left, rect2.top, rect2.right, rect2.bottom);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) h.b.getLayoutParams();
            layoutParams3.height = -2;
            h.b.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) h.a.getLayoutParams();
            layoutParams4.height = -2;
            h.a.setLayoutParams(layoutParams4);
        }
        h.invalidate();
        h.requestLayout();
    }

    public final void b() {
        ColorDrawable colorDrawable = new ColorDrawable(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme);
        if (!PlatformSupport.VANILLA_ICE_CREAM_SUPPORT) {
            getWindow().setBackgroundDrawable(colorDrawable);
            return;
        }
        Insets insets = this.b.getActivity().getWindow().getDecorView().getRootWindowInsets().getInsets(WindowInsets.Type.displayCutout());
        getWindow().setBackgroundDrawable(new InsetDrawable((Drawable) colorDrawable, insets.left, insets.top, insets.right, (int) com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme));
    }

    protected H createSoftInputView(EditText editText) {
        H h = new H(this.a, editText);
        h.a.setOnClickListener(this);
        setContentView(h);
        return h;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.d.d() || !(motionEvent.getAction() == com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.FreeformWindowSize_tablet || this.d.d)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        J j = this.d;
        j.a(j.b(), false);
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
    }
}
