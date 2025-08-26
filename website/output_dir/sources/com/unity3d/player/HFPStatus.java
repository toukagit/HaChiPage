package com.unity3d.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
/* loaded from: base/dex/classes.dex */
public class HFPStatus {
    private Context a;
    private AudioManager d;
    private BroadcastReceiver b = null;
    private boolean c = false;
    private boolean e = false;
    private int f = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector;

    public HFPStatus(Context context) {
        this.d = null;
        this.a = context;
        this.d = (AudioManager) context.getSystemService("audio");
        initHFPStatusJni();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.e) {
            this.e = false;
            this.d.stopBluetoothSco();
        }
    }

    private final native void deinitHFPStatusJni();

    private final native void initHFPStatusJni();

    public final void b() {
        clearHFPStat();
        deinitHFPStatusJni();
    }

    protected void clearHFPStat() {
        BroadcastReceiver broadcastReceiver = this.b;
        if (broadcastReceiver != null) {
            this.a.unregisterReceiver(broadcastReceiver);
            this.b = null;
        }
        this.f = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector;
        a();
    }

    protected boolean getHFPStat() {
        return this.f == 2;
    }

    protected void requestHFPStat() {
        clearHFPStat();
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.unity3d.player.HFPStatus.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                if (intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1) != com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector) {
                    return;
                }
                HFPStatus hFPStatus = HFPStatus.this;
                hFPStatus.f = 2;
                hFPStatus.a();
                HFPStatus hFPStatus2 = HFPStatus.this;
                if (hFPStatus2.c) {
                    hFPStatus2.d.setMode(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.FreeformWindowSize_phone);
                }
            }
        };
        this.b = broadcastReceiver;
        this.a.registerReceiver(broadcastReceiver, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
        try {
            this.e = true;
            this.d.startBluetoothSco();
        } catch (NullPointerException unused) {
            AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.app_name, "startBluetoothSco() failed. no bluetooth device connected.");
        }
    }

    protected void setHFPRecordingStat(boolean z) {
        this.c = z;
        if (z) {
            return;
        }
        this.d.setMode(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme);
    }
}
