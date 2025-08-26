package com.unity3d.player;

import android.graphics.SurfaceTexture;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unity3d.player.q  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
public final class C0032q implements SurfaceTexture.OnFrameAvailableListener {
    final /* synthetic */ C0034r a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0032q(C0034r c0034r) {
        this.a = c0034r;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        com.unity3d.player.a.b bVar;
        bVar = this.a.a;
        ((Camera2Wrapper) bVar).a(surfaceTexture);
    }
}
