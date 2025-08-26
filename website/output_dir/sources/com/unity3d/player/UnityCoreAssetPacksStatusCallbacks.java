package com.unity3d.player;
/* loaded from: base/dex/classes.dex */
class UnityCoreAssetPacksStatusCallbacks implements IAssetPackManagerDownloadStatusCallback, IAssetPackManagerStatusQueryCallback {
    private final native void nativeStatusQueryResult(String str, int i, int i2);

    @Override // com.unity3d.player.IAssetPackManagerStatusQueryCallback
    public void onStatusResult(long j, String[] strArr, int[] iArr, int[] iArr2) {
        for (int i = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme; i < iArr.length; i += com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector) {
            nativeStatusQueryResult(strArr[i], iArr[i], iArr2[i]);
        }
    }

    @Override // com.unity3d.player.IAssetPackManagerDownloadStatusCallback
    public void onStatusUpdate(String str, int i, long j, long j2, int i2, int i3) {
        nativeStatusQueryResult(str, i, i3);
    }
}
