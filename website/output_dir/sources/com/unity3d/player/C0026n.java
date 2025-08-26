package com.unity3d.player;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.util.Range;
import android.view.Surface;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unity3d.player.n  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
public final class C0026n extends CameraCaptureSession.StateCallback {
    final /* synthetic */ C0034r a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0026n(C0034r c0034r) {
        this.a = c0034r;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Camera2: CaptureSession configuration failed.");
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onConfigured(CameraCaptureSession cameraCaptureSession) {
        CameraDevice cameraDevice;
        Object obj;
        StringBuilder append;
        CameraDevice cameraDevice2;
        CaptureRequest.Builder builder;
        Surface surface;
        CaptureRequest.Builder builder2;
        Range range;
        C0034r c0034r = this.a;
        cameraDevice = c0034r.b;
        if (cameraDevice == null) {
            return;
        }
        obj = c0034r.s;
        synchronized (obj) {
            C0034r c0034r2 = this.a;
            c0034r2.r = cameraCaptureSession;
            try {
                try {
                    cameraDevice2 = c0034r2.b;
                    c0034r2.q = cameraDevice2.createCaptureRequest(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector);
                    C0034r c0034r3 = this.a;
                    builder = c0034r3.q;
                    surface = c0034r3.v;
                    builder.addTarget(surface);
                    C0034r c0034r4 = this.a;
                    builder2 = c0034r4.q;
                    CaptureRequest.Key key = CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE;
                    range = c0034r4.n;
                    builder2.set(key, range);
                    this.a.g();
                } catch (IllegalStateException e) {
                    append = new StringBuilder("Camera2: IllegalStateException ").append(e);
                    AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, append.toString());
                }
            } catch (CameraAccessException e2) {
                append = new StringBuilder("Camera2: CameraAccessException ").append(e2);
                AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, append.toString());
            }
        }
    }
}
