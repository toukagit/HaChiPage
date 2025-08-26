package com.unity3d.player;

import android.media.Image;
import android.media.ImageReader;
import java.util.concurrent.Semaphore;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unity3d.player.p  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
public final class C0030p implements ImageReader.OnImageAvailableListener {
    final /* synthetic */ C0034r a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0030p(C0034r c0034r) {
        this.a = c0034r;
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public final void onImageAvailable(ImageReader imageReader) {
        Semaphore semaphore;
        Semaphore semaphore2;
        Image image;
        com.unity3d.player.a.b bVar;
        semaphore = C0034r.D;
        if (semaphore.tryAcquire()) {
            Image acquireNextImage = imageReader.acquireNextImage();
            if (acquireNextImage != null) {
                Image.Plane[] planes = acquireNextImage.getPlanes();
                if (acquireNextImage.getFormat() == 35 && planes != null && planes.length == com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.FreeformWindowSize_phone) {
                    bVar = this.a.a;
                    ((Camera2Wrapper) bVar).a(planes[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme].getBuffer(), planes[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector].getBuffer(), planes[2].getBuffer(), planes[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme].getRowStride(), planes[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector].getRowStride(), planes[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector].getPixelStride());
                } else {
                    AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Camera2: Wrong image format.");
                }
                image = this.a.p;
                if (image != null) {
                    image.close();
                }
                this.a.p = acquireNextImage;
            }
            semaphore2 = C0034r.D;
            semaphore2.release();
        }
    }
}
