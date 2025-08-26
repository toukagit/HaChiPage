package com.unity3d.player;
/* renamed from: com.unity3d.player.z  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
final class RunnableC0047z implements Runnable {
    final /* synthetic */ String[] a;
    final /* synthetic */ PermissionFragment b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0047z(PermissionFragment permissionFragment, String[] strArr) {
        this.b = permissionFragment;
        this.a = strArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.reportAllDenied(this.a);
    }
}
