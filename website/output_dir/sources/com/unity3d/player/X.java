package com.unity3d.player;

import android.os.Build;
import java.lang.Thread;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: base/dex/classes.dex */
public final class X implements Thread.UncaughtExceptionHandler {
    private volatile Thread.UncaughtExceptionHandler a;
    private String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof X) {
            X x = (X) defaultUncaughtExceptionHandler;
            int i = -1;
            int i2 = -1;
            while (true) {
                int indexOf = str.indexOf(47, i + com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector);
                if (indexOf == -1) {
                    break;
                }
                i2 = i;
                i = indexOf;
            }
            x.b = i2 < 0 ? "Unknown" : str.substring(i2 + com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void a() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler == this) {
            return;
        }
        this.a = defaultUncaughtExceptionHandler;
        this.b = "Unknown";
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        try {
            StringBuilder sb = new StringBuilder();
            Object[] objArr = new Object[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector];
            objArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = thread.getName();
            StringBuilder append = sb.append(String.format("FATAL EXCEPTION [%s]\n", objArr));
            Object[] objArr2 = new Object[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector];
            objArr2[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = "2022.3.56f1c1";
            StringBuilder append2 = append.append(String.format("Unity version     : %s\n", objArr2));
            Object[] objArr3 = new Object[2];
            objArr3[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = Build.MANUFACTURER;
            objArr3[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector] = Build.MODEL;
            StringBuilder append3 = append2.append(String.format("Device model      : %s %s\n", objArr3));
            Object[] objArr4 = new Object[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector];
            objArr4[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = Build.FINGERPRINT;
            StringBuilder append4 = append3.append(String.format("Device fingerprint: %s\n", objArr4));
            Object[] objArr5 = new Object[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector];
            objArr5[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = Arrays.toString(Build.SUPPORTED_ABIS);
            StringBuilder append5 = append4.append(String.format("CPU supported ABI : %s\n", objArr5));
            Object[] objArr6 = new Object[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector];
            objArr6[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = "Release";
            StringBuilder append6 = append5.append(String.format("Build Type        : %s\n", objArr6));
            Object[] objArr7 = new Object[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector];
            objArr7[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = "IL2CPP";
            StringBuilder append7 = append6.append(String.format("Scripting Backend : %s\n", objArr7));
            Object[] objArr8 = new Object[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector];
            objArr8[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = this.b;
            StringBuilder append8 = append7.append(String.format("Libs loaded from  : %s\n", objArr8));
            Object[] objArr9 = new Object[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector];
            objArr9[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = Boolean.TRUE;
            Error error = new Error(append8.append(String.format("Strip Engine Code : %s\n", objArr9)).toString());
            error.setStackTrace(new StackTraceElement[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme]);
            error.initCause(th);
            this.a.uncaughtException(thread, error);
        } catch (Throwable unused) {
            this.a.uncaughtException(thread, th);
        }
    }
}
