package com.unity3d.player;
/* renamed from: com.unity3d.player.s  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
abstract class AbstractC0036s {
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
        if (r0 == false) goto L15;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.app.Activity r5) {
        /*
            if (r5 == 0) goto L52
            android.view.Window r0 = r5.getWindow()
            if (r0 == 0) goto L52
            boolean r0 = com.unity3d.player.PlatformSupport.PIE_SUPPORT
            if (r0 == 0) goto L52
            boolean r0 = com.unity3d.player.PlatformSupport.VANILLA_ICE_CREAM_SUPPORT
            r1 = 0
            if (r0 == 0) goto L12
            goto L32
        L12:
            boolean r0 = com.unity3d.player.PlatformSupport.RED_VELVET_CAKE_SUPPORT
            java.lang.String r2 = "unity.render-outside-safearea"
            r3 = 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L34
            android.content.pm.PackageManager r0 = r5.getPackageManager()     // Catch: java.lang.Exception -> L2f
            java.lang.String r4 = r5.getPackageName()     // Catch: java.lang.Exception -> L2f
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r4, r3)     // Catch: java.lang.Exception -> L2f
            if (r0 == 0) goto L2f
            android.os.Bundle r0 = r0.metaData     // Catch: java.lang.Exception -> L2f
            boolean r0 = r0.getBoolean(r2)     // Catch: java.lang.Exception -> L2f
            goto L30
        L2f:
            r0 = r1
        L30:
            if (r0 == 0) goto L48
        L32:
            r1 = 3
            goto L48
        L34:
            android.content.pm.PackageManager r0 = r5.getPackageManager()     // Catch: java.lang.Exception -> L48
            java.lang.String r4 = r5.getPackageName()     // Catch: java.lang.Exception -> L48
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r4, r3)     // Catch: java.lang.Exception -> L48
            if (r0 == 0) goto L48
            android.os.Bundle r0 = r0.metaData     // Catch: java.lang.Exception -> L48
            boolean r1 = r0.getBoolean(r2)     // Catch: java.lang.Exception -> L48
        L48:
            android.view.Window r5 = r5.getWindow()
            android.view.WindowManager$LayoutParams r5 = r5.getAttributes()
            r5.layoutInDisplayCutoutMode = r1
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.AbstractC0036s.a(android.app.Activity):void");
    }
}
