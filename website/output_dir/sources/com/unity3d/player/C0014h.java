package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.assetpacks.AssetPackException;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStates;
import java.util.Map;
/* renamed from: com.unity3d.player.h  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
final class C0014h implements OnCompleteListener {
    private IAssetPackManagerStatusQueryCallback a;
    private Looper b = Looper.myLooper();
    private String[] c;

    public C0014h(String[] strArr, IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback) {
        this.a = iAssetPackManagerStatusQueryCallback;
        this.c = strArr;
    }

    public final void onComplete(Task task) {
        int errorCode;
        if (this.a == null) {
            return;
        }
        int i = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        try {
            AssetPackStates assetPackStates = (AssetPackStates) task.getResult();
            Map packStates = assetPackStates.packStates();
            int size = packStates.size();
            String[] strArr = new String[size];
            int[] iArr = new int[size];
            int[] iArr2 = new int[size];
            for (AssetPackState assetPackState : packStates.values()) {
                strArr[i] = assetPackState.name();
                iArr[i] = assetPackState.status();
                iArr2[i] = assetPackState.errorCode();
                i += com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector;
            }
            new Handler(this.b).post(new RunnableC0012g(this.a, assetPackStates.totalBytes(), strArr, iArr, iArr2));
        } catch (RuntimeExecutionException e) {
            e = e;
            String message = e.getMessage();
            String[] strArr2 = this.c;
            int length = strArr2.length;
            int i2 = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
            while (true) {
                int i3 = -100;
                if (i2 >= length) {
                    String[] strArr3 = this.c;
                    int[] iArr3 = new int[strArr3.length];
                    int[] iArr4 = new int[strArr3.length];
                    for (int i4 = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme; i4 < this.c.length; i4 += com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector) {
                        iArr3[i4] = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
                        Throwable th = e;
                        while (true) {
                            if (th instanceof AssetPackException) {
                                errorCode = ((AssetPackException) th).getErrorCode();
                                break;
                            }
                            th = th.getCause();
                            if (th == null) {
                                errorCode = -100;
                                break;
                            }
                        }
                        iArr4[i4] = errorCode;
                    }
                    new Handler(this.b).post(new RunnableC0012g(this.a, 0L, this.c, iArr3, iArr4));
                    return;
                }
                String str = strArr2[i2];
                if (message.contains(str)) {
                    Handler handler = new Handler(this.b);
                    IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback = this.a;
                    String[] strArr4 = new String[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector];
                    strArr4[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = str;
                    int[] iArr5 = new int[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector];
                    iArr5[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
                    int[] iArr6 = new int[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector];
                    while (true) {
                        if (e instanceof AssetPackException) {
                            i3 = ((AssetPackException) e).getErrorCode();
                            break;
                        }
                        e = e.getCause();
                        if (e == null) {
                            break;
                        }
                    }
                    iArr6[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = i3;
                    handler.post(new RunnableC0012g(iAssetPackManagerStatusQueryCallback, 0L, strArr4, iArr5, iArr6));
                    return;
                }
                i2 += com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector;
            }
        }
    }
}
