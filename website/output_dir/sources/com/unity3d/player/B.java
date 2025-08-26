package com.unity3d.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.View;
/* loaded from: base/dex/classes.dex */
final class B extends View implements PixelCopy.OnPixelCopyFinishedListener {
    Bitmap a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(Context context) {
        super(context);
    }

    public final void a(SurfaceView surfaceView) {
        Bitmap createBitmap = Bitmap.createBitmap(surfaceView.getWidth(), surfaceView.getHeight(), Bitmap.Config.ARGB_8888);
        this.a = createBitmap;
        PixelCopy.request(surfaceView, createBitmap, this, new Handler(Looper.getMainLooper()));
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int i) {
        if (i == 0) {
            ColorDrawable colorDrawable = new ColorDrawable(-16777216);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), this.a);
            Drawable[] drawableArr = new Drawable[2];
            drawableArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = colorDrawable;
            drawableArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector] = bitmapDrawable;
            setBackground(new LayerDrawable(drawableArr));
        }
    }
}
