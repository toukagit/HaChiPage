package org.fmod;

import android.media.AudioTrack;
import android.util.Log;
import com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R;
import java.nio.ByteBuffer;
/* loaded from: base/dex/classes.dex */
public class FMODAudioDevice implements Runnable {
    private volatile Thread a = null;
    private volatile boolean b = false;
    private AudioTrack c = null;
    private boolean d = false;
    private ByteBuffer e = null;
    private byte[] f = null;
    private volatile a g;

    private native int fmodGetInfo(int i);

    private native int fmodProcess(ByteBuffer byteBuffer);

    private void releaseAudioTrack() {
        AudioTrack audioTrack = this.c;
        if (audioTrack != null) {
            if (audioTrack.getState() == R.style.UnityThemeSelector) {
                this.c.stop();
            }
            this.c.release();
            this.c = null;
        }
        this.e = null;
        this.f = null;
        this.d = false;
    }

    public synchronized void close() {
        stop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int fmodProcessMicData(ByteBuffer byteBuffer, int i);

    public boolean isRunning() {
        return this.a != null && this.a.isAlive();
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = R.string.FreeformWindowSize_phone;
        while (this.b) {
            if (!this.d && i > 0) {
                releaseAudioTrack();
                int fmodGetInfo = fmodGetInfo(R.style.BaseUnityTheme);
                int i2 = fmodGetInfo(R.string.FreeformWindowSize_tablet) == R.style.UnityThemeSelector ? R.string.FreeformWindowSize_tablet : 12;
                int minBufferSize = AudioTrack.getMinBufferSize(fmodGetInfo, i2, 2);
                int fmodGetInfo2 = fmodGetInfo(R.string.FreeformWindowSize_tablet) * 2;
                int round = Math.round(minBufferSize * 1.1f) & (~(fmodGetInfo2 - 1));
                int fmodGetInfo3 = fmodGetInfo(R.style.UnityThemeSelector);
                int fmodGetInfo4 = fmodGetInfo(2) * fmodGetInfo3 * fmodGetInfo2;
                AudioTrack audioTrack = new AudioTrack(R.string.FreeformWindowSize_phone, fmodGetInfo, i2, 2, fmodGetInfo4 > round ? fmodGetInfo4 : round, R.style.UnityThemeSelector);
                this.c = audioTrack;
                boolean z = audioTrack.getState() == R.style.UnityThemeSelector ? R.style.UnityThemeSelector : R.style.BaseUnityTheme;
                this.d = z;
                if (z) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fmodGetInfo3 * fmodGetInfo2);
                    this.e = allocateDirect;
                    this.f = new byte[allocateDirect.capacity()];
                    this.c.play();
                    i = R.string.FreeformWindowSize_phone;
                } else {
                    Log.e("FMOD", "AudioTrack failed to initialize (status " + this.c.getState() + ")");
                    releaseAudioTrack();
                    i--;
                }
            }
            if (this.d) {
                if (fmodGetInfo(R.string.FreeformWindowSize_phone) == R.style.UnityThemeSelector) {
                    fmodProcess(this.e);
                    ByteBuffer byteBuffer = this.e;
                    byteBuffer.get(this.f, R.style.BaseUnityTheme, byteBuffer.capacity());
                    this.c.write(this.f, R.style.BaseUnityTheme, this.e.capacity());
                    this.e.position(R.style.BaseUnityTheme);
                } else {
                    releaseAudioTrack();
                }
            }
        }
        releaseAudioTrack();
    }

    public synchronized void start() {
        if (this.a != null) {
            stop();
        }
        this.a = new Thread(this, "FMODAudioDevice");
        this.a.setPriority(10);
        this.b = true;
        this.a.start();
        if (this.g != null) {
            this.g.c();
        }
    }

    public synchronized int startAudioRecord(int i, int i2, int i3) {
        if (this.g == null) {
            this.g = new a(this, i, i2);
            this.g.c();
        }
        return this.g.a();
    }

    public synchronized void stop() {
        while (this.a != null) {
            this.b = false;
            try {
                this.a.join();
                this.a = null;
            } catch (InterruptedException unused) {
            }
        }
        if (this.g != null) {
            this.g.d();
        }
    }

    public synchronized void stopAudioRecord() {
        if (this.g != null) {
            this.g.d();
            this.g = null;
        }
    }
}
