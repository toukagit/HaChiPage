package com.google.androidgamesdk;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;
/* loaded from: base/dex/classes.dex */
final class c implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ SwappyDisplayManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SwappyDisplayManager swappyDisplayManager, int i) {
        this.b = swappyDisplayManager;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Activity activity;
        activity = this.b.mActivity;
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.preferredDisplayModeId = this.a;
        window.setAttributes(attributes);
    }
}
