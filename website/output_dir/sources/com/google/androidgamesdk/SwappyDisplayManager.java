package com.google.androidgamesdk;

import android.app.Activity;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R;
/* loaded from: base/dex/classes.dex */
public class SwappyDisplayManager implements DisplayManager.DisplayListener {
    private Activity mActivity;
    private long mCookie;
    private Display.Mode mCurrentMode;
    private d mLooper;
    private WindowManager mWindowManager;
    private final String LOG_TAG = "SwappyDisplayManager";
    private final boolean DEBUG = false;
    private final long ONE_MS_IN_NS = 1000000;
    private final long ONE_S_IN_NS = 1000000000;

    public SwappyDisplayManager(long j, Activity activity) {
        String string;
        try {
            Bundle bundle = activity.getPackageManager().getActivityInfo(activity.getIntent().getComponent(), 128).metaData;
            if (bundle != null && (string = bundle.getString("android.app.lib_name")) != null) {
                System.loadLibrary(string);
            }
        } catch (Throwable th) {
            Log.e("SwappyDisplayManager", th.getMessage());
        }
        this.mCookie = j;
        this.mActivity = activity;
        WindowManager windowManager = (WindowManager) activity.getSystemService(WindowManager.class);
        this.mWindowManager = windowManager;
        Display defaultDisplay = windowManager.getDefaultDisplay();
        this.mCurrentMode = defaultDisplay.getMode();
        updateSupportedRefreshRates(defaultDisplay);
        DisplayManager displayManager = (DisplayManager) this.mActivity.getSystemService(DisplayManager.class);
        synchronized (this) {
            d dVar = new d();
            this.mLooper = dVar;
            dVar.start();
            displayManager.registerDisplayListener(this, this.mLooper.a);
        }
    }

    private boolean modeMatchesCurrentResolution(Display.Mode mode) {
        return mode.getPhysicalHeight() == this.mCurrentMode.getPhysicalHeight() && mode.getPhysicalWidth() == this.mCurrentMode.getPhysicalWidth();
    }

    private native void nOnRefreshPeriodChanged(long j, long j2, long j3, long j4);

    private native void nSetSupportedRefreshPeriods(long j, long[] jArr, int[] iArr);

    private void updateSupportedRefreshRates(Display display) {
        Display.Mode[] supportedModes = display.getSupportedModes();
        int i = R.style.BaseUnityTheme;
        int i2 = i;
        while (i < supportedModes.length) {
            if (modeMatchesCurrentResolution(supportedModes[i])) {
                i2 += R.style.UnityThemeSelector;
            }
            i += R.style.UnityThemeSelector;
        }
        long[] jArr = new long[i2];
        int[] iArr = new int[i2];
        int i3 = R.style.BaseUnityTheme;
        for (int i4 = R.style.BaseUnityTheme; i4 < supportedModes.length; i4 += R.style.UnityThemeSelector) {
            if (modeMatchesCurrentResolution(supportedModes[i4])) {
                jArr[i3] = 1.0E9f / supportedModes[i4].getRefreshRate();
                iArr[i3] = supportedModes[i4].getModeId();
                i3 += R.style.UnityThemeSelector;
            }
        }
        nSetSupportedRefreshPeriods(this.mCookie, jArr, iArr);
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayAdded(int i) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayChanged(int i) {
        synchronized (this) {
            Display defaultDisplay = this.mWindowManager.getDefaultDisplay();
            float refreshRate = defaultDisplay.getRefreshRate();
            Display.Mode mode = defaultDisplay.getMode();
            boolean z = true;
            boolean z2 = (mode.getPhysicalWidth() != this.mCurrentMode.getPhysicalWidth() ? R.style.UnityThemeSelector : R.style.BaseUnityTheme) | (mode.getPhysicalHeight() != this.mCurrentMode.getPhysicalHeight() ? R.style.UnityThemeSelector : R.style.BaseUnityTheme);
            if (refreshRate == this.mCurrentMode.getRefreshRate()) {
                z = R.style.BaseUnityTheme;
            }
            this.mCurrentMode = mode;
            if (z2) {
                updateSupportedRefreshRates(defaultDisplay);
            }
            if (z) {
                long j = 1.0E9f / refreshRate;
                nOnRefreshPeriodChanged(this.mCookie, j, defaultDisplay.getAppVsyncOffsetNanos(), j - (this.mWindowManager.getDefaultDisplay().getPresentationDeadlineNanos() - 1000000));
            }
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayRemoved(int i) {
    }

    public void setPreferredDisplayModeId(int i) {
        this.mActivity.runOnUiThread(new c(this, i));
    }

    public void terminate() {
        this.mLooper.a.getLooper().quit();
    }
}
