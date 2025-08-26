package com.unity3d.player;

import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
/* renamed from: com.unity3d.player.j  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
final class C0018j extends ContentObserver {
    private final InterfaceC0020k a;
    private final AudioManager b;
    private final int c;
    private int d;

    public C0018j(Handler handler, AudioManager audioManager, InterfaceC0020k interfaceC0020k) {
        super(handler);
        this.b = audioManager;
        this.c = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.FreeformWindowSize_phone;
        this.a = interfaceC0020k;
        this.d = audioManager.getStreamVolume(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.FreeformWindowSize_phone);
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return super.deliverSelfNotifications();
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z, Uri uri) {
        int streamVolume;
        AudioManager audioManager = this.b;
        if (audioManager == null || this.a == null || (streamVolume = audioManager.getStreamVolume(this.c)) == this.d) {
            return;
        }
        this.d = streamVolume;
        this.a.onAudioVolumeChanged(streamVolume);
    }
}
