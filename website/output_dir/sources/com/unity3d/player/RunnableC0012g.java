package com.unity3d.player;
/* renamed from: com.unity3d.player.g  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
final class RunnableC0012g implements Runnable {
    private IAssetPackManagerStatusQueryCallback a;
    private long b;
    private String[] c;
    private int[] d;
    private int[] e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0012g(IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback, long j, String[] strArr, int[] iArr, int[] iArr2) {
        this.a = iAssetPackManagerStatusQueryCallback;
        this.b = j;
        this.c = strArr;
        this.d = iArr;
        this.e = iArr2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onStatusResult(this.b, this.c, this.d, this.e);
    }
}
