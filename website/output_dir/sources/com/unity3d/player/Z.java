package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: base/dex/classes.dex */
public final class Z extends FrameLayout {
    private C0000a a;
    private UnityPlayer b;
    private C c;

    public Z(Context context, UnityPlayer unityPlayer) {
        super(context);
        int i;
        this.c = new C(context);
        this.b = unityPlayer;
        C0000a c0000a = new C0000a(context, unityPlayer);
        this.a = c0000a;
        c0000a.setId(context.getResources().getIdentifier("unitySurfaceView", "id", context.getPackageName()));
        if (a()) {
            this.a.getHolder().setFormat(-3);
            this.a.setZOrderOnTop(true);
            i = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        } else {
            this.a.getHolder().setFormat(-1);
            i = -16777216;
        }
        setBackgroundColor(i);
        this.a.getHolder().addCallback(new Y(this));
        this.a.setFocusable(true);
        this.a.setFocusableInTouchMode(true);
        this.a.setContentDescription(a(context));
        addView(this.a, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    private static String a(Context context) {
        return context.getResources().getString(context.getResources().getIdentifier("game_view_content_description", "string", context.getPackageName()));
    }

    private static boolean a() {
        Activity activity = UnityPlayer.currentActivity;
        if (activity == null) {
            return false;
        }
        Resources.Theme theme = activity.getTheme();
        int[] iArr = new int[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector];
        iArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = 16842840;
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(iArr);
        boolean z = obtainStyledAttributes.getBoolean(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(float f) {
        this.a.a(f);
    }

    public final void b() {
        C c = this.c;
        UnityPlayer unityPlayer = this.b;
        B b = c.b;
        if (b != null && b.getParent() != null) {
            unityPlayer.removeView(c.b);
        }
        this.c.b = null;
    }

    public final boolean c() {
        C0000a c0000a = this.a;
        return c0000a != null && c0000a.a();
    }
}
