package com.unity3d.player;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: base/dex/classes.dex */
public final class D implements InvocationHandler {
    private Runnable a;
    private UnityPlayer b;
    private long c;
    final /* synthetic */ long d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public D(UnityPlayer unityPlayer, long j) {
        long j2;
        this.d = j;
        j2 = ReflectionHelper.b;
        this.a = new G(j2, j);
        this.b = unityPlayer;
        this.c = j2;
    }

    private static Object a(Object obj, Method method, Object[] objArr, F f) {
        long j;
        long j2;
        if (objArr == null) {
            try {
                try {
                    objArr = new Object[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme];
                } catch (NoClassDefFoundError unused) {
                    AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, String.format("Java interface default methods are only supported since Android Oreo", new Object[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme]));
                    j2 = f.a;
                    ReflectionHelper.nativeProxyLogJNIInvokeException(j2);
                    f.a = 0L;
                    return null;
                }
            } finally {
                j = f.a;
                if (j != 0) {
                    ReflectionHelper.nativeProxyJNIFreeGCHandle(j);
                }
            }
        }
        Class<?> declaringClass = method.getDeclaringClass();
        Class[] clsArr = new Class[2];
        clsArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = Class.class;
        clsArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector] = Integer.TYPE;
        Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(clsArr);
        declaredConstructor.setAccessible(true);
        Object[] objArr2 = new Object[2];
        objArr2[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = declaringClass;
        objArr2[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector] = 2;
        return ((MethodHandles.Lookup) declaredConstructor.newInstance(objArr2)).in(declaringClass).unreflectSpecial(method, declaringClass).bindTo(obj).invokeWithArguments(objArr);
    }

    protected void finalize() {
        this.b.queueGLThreadEvent(this.a);
        super.finalize();
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        Object nativeProxyInvoke;
        boolean z;
        long j;
        if (!ReflectionHelper.beginProxyCall(this.c)) {
            AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Scripting proxy object was destroyed, because Unity player was unloaded.");
            return null;
        }
        try {
            nativeProxyInvoke = ReflectionHelper.nativeProxyInvoke(this.d, method.getName(), objArr);
            if (nativeProxyInvoke instanceof F) {
                F f = (F) nativeProxyInvoke;
                z = f.b;
                if (z && (method.getModifiers() & 1024) == 0) {
                    return a(obj, method, objArr, f);
                }
                j = f.a;
                ReflectionHelper.nativeProxyLogJNIInvokeException(j);
                return null;
            }
            return nativeProxyInvoke;
        } finally {
            ReflectionHelper.endProxyCall();
        }
    }
}
