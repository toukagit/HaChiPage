package org.fmod;

import android.media.AudioRecord;
import android.util.Log;
import com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: base/dex/classes.dex */
public final class a implements Runnable {
    private final FMODAudioDevice a;
    private final ByteBuffer b;
    private final int c;
    private final int d;
    private volatile Thread e;
    private volatile boolean f;
    private AudioRecord g;
    private boolean h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FMODAudioDevice fMODAudioDevice, int i, int i2) {
        this.a = fMODAudioDevice;
        this.c = i;
        this.d = i2;
        this.b = ByteBuffer.allocateDirect(AudioRecord.getMinBufferSize(i, i2, 2));
    }

    private void b() {
        AudioRecord audioRecord = this.g;
        if (audioRecord != null) {
            if (audioRecord.getState() == R.style.UnityThemeSelector) {
                this.g.stop();
            }
            this.g.release();
            this.g = null;
        }
        this.b.position(R.style.BaseUnityTheme);
        this.h = false;
    }

    public final int a() {
        return this.b.capacity();
    }

    public final void c() {
        if (this.e != null) {
            d();
        }
        this.f = true;
        this.e = new Thread(this);
        this.e.start();
    }

    public final void d() {
        while (this.e != null) {
            this.f = false;
            try {
                this.e.join();
                this.e = null;
            } catch (InterruptedException unused) {
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = R.string.FreeformWindowSize_phone;
        while (this.f) {
            if (!this.h && i > 0) {
                b();
                AudioRecord audioRecord = new AudioRecord(R.style.UnityThemeSelector, this.c, this.d, 2, this.b.capacity());
                this.g = audioRecord;
                boolean z = audioRecord.getState() != R.style.UnityThemeSelector ? R.style.BaseUnityTheme : true;
                this.h = z;
                if (z) {
                    this.b.position(R.style.BaseUnityTheme);
                    this.g.startRecording();
                    i = R.string.FreeformWindowSize_phone;
                } else {
                    Log.e("FMOD", "AudioRecord failed to initialize (status " + this.g.getState() + ")");
                    i--;
                    b();
                }
            }
            if (this.h && this.g.getRecordingState() == R.string.FreeformWindowSize_phone) {
                AudioRecord audioRecord2 = this.g;
                ByteBuffer byteBuffer = this.b;
                this.a.fmodProcessMicData(this.b, audioRecord2.read(byteBuffer, byteBuffer.capacity()));
                this.b.position(R.style.BaseUnityTheme);
            }
        }
        b();
    }
}
