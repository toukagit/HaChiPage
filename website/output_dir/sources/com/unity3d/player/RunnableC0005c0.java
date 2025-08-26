package com.unity3d.player;

import android.content.Context;
import java.util.concurrent.Semaphore;
/* renamed from: com.unity3d.player.c0  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
final class RunnableC0005c0 implements Runnable {
    final /* synthetic */ UnityPlayer a;
    final /* synthetic */ String b;
    final /* synthetic */ int c;
    final /* synthetic */ boolean d;
    final /* synthetic */ boolean e;
    final /* synthetic */ boolean f;
    final /* synthetic */ boolean g;
    final /* synthetic */ String h;
    final /* synthetic */ int i;
    final /* synthetic */ boolean j;
    final /* synthetic */ boolean k;
    final /* synthetic */ Semaphore l;
    final /* synthetic */ UnityPlayer m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0005c0(UnityPlayer unityPlayer, UnityPlayer unityPlayer2, String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2, boolean z5, boolean z6, Semaphore semaphore) {
        this.m = unityPlayer;
        this.a = unityPlayer2;
        this.b = str;
        this.c = i;
        this.d = z;
        this.e = z2;
        this.f = z3;
        this.g = z4;
        this.h = str2;
        this.i = i2;
        this.j = z5;
        this.k = z6;
        this.l = semaphore;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        try {
            try {
                UnityPlayer unityPlayer = this.m;
                if (unityPlayer.mSoftInput != null) {
                    unityPlayer.dismissSoftInput();
                }
                UnityPlayer unityPlayer2 = this.m;
                int a = SoftInputProvider.a();
                context = this.m.mContext;
                UnityPlayer unityPlayer3 = this.a;
                unityPlayer2.mSoftInput = com.unity3d.player.a.a.a(a) != 2 ? new T(context, unityPlayer3) : new N(context, unityPlayer3);
                this.m.mSoftInput.a(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k);
                J j = this.m.mSoftInput;
                j.f = new C0003b0(this);
                j.e();
                this.m.nativeReportKeyboardConfigChanged();
            } catch (Exception e) {
                AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Exception when opening Softinput " + e);
            }
        } finally {
            this.l.release();
        }
    }
}
