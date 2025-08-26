package com.unity3d.player;
/* renamed from: com.unity3d.player.d  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
final class RunnableC0006d implements Runnable {
    private IAssetPackManagerMobileDataConfirmationCallback a;
    private boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0006d(IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback, boolean z) {
        this.a = iAssetPackManagerMobileDataConfirmationCallback;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onMobileDataConfirmationResult(this.b);
    }
}
