package com.unity3d.player;

import android.hardware.camera2.CameraDevice;
import java.util.concurrent.Semaphore;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unity3d.player.o  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
public final class C0028o extends CameraDevice.StateCallback {
    final /* synthetic */ C0034r a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0028o(C0034r c0034r) {
        this.a = c0034r;
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onClosed(CameraDevice cameraDevice) {
        Semaphore semaphore;
        semaphore = C0034r.D;
        semaphore.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onDisconnected(CameraDevice cameraDevice) {
        Semaphore semaphore;
        AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.app_name, "Camera2: CameraDevice disconnected.");
        this.a.a(cameraDevice);
        semaphore = C0034r.D;
        semaphore.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onError(CameraDevice cameraDevice, int i) {
        Semaphore semaphore;
        AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Camera2: Error opeining CameraDevice " + i);
        this.a.a(cameraDevice);
        semaphore = C0034r.D;
        semaphore.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onOpened(CameraDevice cameraDevice) {
        Semaphore semaphore;
        this.a.b = cameraDevice;
        semaphore = C0034r.D;
        semaphore.release();
    }
}
