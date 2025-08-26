package com.unity3d.player;

import android.content.Context;
/* loaded from: base/dex/classes.dex */
public class AudioVolumeHandler implements InterfaceC0020k {
    private C0022l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioVolumeHandler(Context context) {
        C0022l c0022l = new C0022l(context);
        this.a = c0022l;
        c0022l.a(this);
    }

    public final void a() {
        this.a.a();
        this.a = null;
    }

    @Override // com.unity3d.player.InterfaceC0020k
    public final native void onAudioVolumeChanged(int i);
}
