package com.unity3d.player;
/* renamed from: com.unity3d.player.r0  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
final class RunnableC0035r0 implements Runnable {
    final /* synthetic */ UnityPlayer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0035r0(UnityPlayer unityPlayer) {
        this.a = unityPlayer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0008, code lost:
        r1 = (r0 = r2.a).mActivity;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r2 = this;
            com.unity3d.player.UnityPlayer r0 = r2.a
            boolean r0 = com.unity3d.player.UnityPlayer.m38$$Nest$mnativeIsAutorotationOn(r0)
            if (r0 == 0) goto L17
            com.unity3d.player.UnityPlayer r0 = r2.a
            android.app.Activity r1 = com.unity3d.player.UnityPlayer.m20$$Nest$fgetmActivity(r0)
            if (r1 == 0) goto L17
            int r0 = com.unity3d.player.UnityPlayer.m23$$Nest$fgetmInitialScreenOrientation(r0)
            r1.setRequestedOrientation(r0)
        L17:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.RunnableC0035r0.run():void");
    }
}
