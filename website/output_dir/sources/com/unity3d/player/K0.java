package com.unity3d.player;
/* loaded from: base/dex/classes.dex */
final class K0 {
    private static boolean e = false;
    private boolean a = false;
    private boolean b = false;
    private boolean c = true;
    private boolean d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d() {
        return e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e() {
        e = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f() {
        e = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(boolean z) {
        return e && !((!z && !this.a) || this.c || this.b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(boolean z) {
        this.a = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(boolean z) {
        this.b = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(boolean z) {
        this.d = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(boolean z) {
        this.c = z;
    }

    public final String toString() {
        return super.toString();
    }
}
