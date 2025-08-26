package com.unity3d.player;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unity3d.player.l  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
public final class C0022l {
    private final Context a;
    private final AudioManager b;
    private C0018j c;

    public C0022l(Context context) {
        this.a = context;
        this.b = (AudioManager) context.getSystemService("audio");
    }

    public final void a() {
        if (this.c != null) {
            this.a.getContentResolver().unregisterContentObserver(this.c);
            this.c = null;
        }
    }

    public final void a(InterfaceC0020k interfaceC0020k) {
        this.c = new C0018j(new Handler(Looper.getMainLooper()), this.b, interfaceC0020k);
        this.a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.c);
    }
}
