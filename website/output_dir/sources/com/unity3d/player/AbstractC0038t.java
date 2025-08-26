package com.unity3d.player;

import android.view.inputmethod.InputMethodSubtype;
/* renamed from: com.unity3d.player.t  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
abstract class AbstractC0038t {
    public static String a(InputMethodSubtype inputMethodSubtype) {
        return PlatformSupport.NOUGAT_SUPPORT ? inputMethodSubtype.getLanguageTag() : inputMethodSubtype.getLocale();
    }
}
