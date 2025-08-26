package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.assetpacks.AssetPackException;
import com.google.android.play.core.assetpacks.AssetPackManager;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStates;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unity3d.player.f  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
public final class C0010f implements OnCompleteListener {
    private IAssetPackManagerDownloadStatusCallback a;
    private Looper b = Looper.myLooper();
    private String c;

    public C0010f(String str, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        this.a = iAssetPackManagerDownloadStatusCallback;
        this.c = str;
    }

    public final void onComplete(Task task) {
        int errorCode;
        C0016i c0016i;
        C0016i c0016i2;
        Object obj;
        HashSet hashSet;
        AssetPackManager assetPackManager;
        AssetPackManager assetPackManager2;
        try {
            AssetPackStates assetPackStates = (AssetPackStates) task.getResult();
            Map packStates = assetPackStates.packStates();
            if (packStates.size() == 0) {
                return;
            }
            for (AssetPackState assetPackState : packStates.values()) {
                if (assetPackState.errorCode() != 0 || assetPackState.status() == com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.FreeformWindowSize_tablet || assetPackState.status() == com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.app_name || assetPackState.status() == 0) {
                    String name = assetPackState.name();
                    int status = assetPackState.status();
                    int errorCode2 = assetPackState.errorCode();
                    long j = assetPackStates.totalBytes();
                    new Handler(this.b).post(new RunnableC0002b(Collections.singleton(this.a), name, status, j, status == com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.FreeformWindowSize_tablet ? j : 0L, com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme, errorCode2));
                } else {
                    c0016i = C0016i.d;
                    String name2 = assetPackState.name();
                    IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback = this.a;
                    Looper looper = this.b;
                    c0016i.getClass();
                    c0016i2 = C0016i.d;
                    synchronized (c0016i2) {
                        obj = c0016i.c;
                        if (obj == null) {
                            C0004c c0004c = new C0004c(c0016i, iAssetPackManagerDownloadStatusCallback, looper);
                            assetPackManager2 = c0016i.a;
                            assetPackManager2.registerListener(c0004c);
                            c0016i.c = c0004c;
                        } else {
                            ((C0004c) obj).a(iAssetPackManagerDownloadStatusCallback);
                        }
                        hashSet = c0016i.b;
                        hashSet.add(name2);
                        assetPackManager = c0016i.a;
                        assetPackManager.fetch(Collections.singletonList(name2));
                    }
                }
            }
        } catch (RuntimeExecutionException e) {
            e = e;
            String str = this.c;
            while (true) {
                if (e instanceof AssetPackException) {
                    errorCode = ((AssetPackException) e).getErrorCode();
                    break;
                }
                e = e.getCause();
                if (e == null) {
                    errorCode = -100;
                    break;
                }
            }
            new Handler(this.b).post(new RunnableC0002b(Collections.singleton(this.a), str, com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme, 0L, 0L, com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme, errorCode));
        }
    }
}
