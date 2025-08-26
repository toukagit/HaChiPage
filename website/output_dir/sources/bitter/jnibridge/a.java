package bitter.jnibridge;

import com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/* loaded from: base/dex/classes.dex */
final class a implements InvocationHandler {
    private Object[] a = new Object[R.style.BaseUnityTheme];
    private long b;
    private Constructor c;

    public a(long j) {
        this.b = j;
        try {
            Class[] clsArr = new Class[2];
            clsArr[R.style.BaseUnityTheme] = Class.class;
            clsArr[R.style.UnityThemeSelector] = Integer.TYPE;
            Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(clsArr);
            this.c = declaredConstructor;
            declaredConstructor.setAccessible(true);
        } catch (NoClassDefFoundError | NoSuchMethodException unused) {
            this.c = null;
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        synchronized (this.a) {
            long j = this.b;
            if (j == 0) {
                return null;
            }
            try {
                return JNIBridge.invoke(j, method.getDeclaringClass(), method, objArr);
            } catch (NoSuchMethodError e) {
                if (this.c == null) {
                    System.err.println("JNIBridge error: Java interface default methods are only supported since Android Oreo");
                    throw e;
                } else if ((method.getModifiers() & 1024) == 0) {
                    if (objArr == null) {
                        objArr = new Object[R.style.BaseUnityTheme];
                    }
                    Class<?> declaringClass = method.getDeclaringClass();
                    Constructor constructor = this.c;
                    Object[] objArr2 = new Object[2];
                    objArr2[R.style.BaseUnityTheme] = declaringClass;
                    objArr2[R.style.UnityThemeSelector] = 2;
                    return ((MethodHandles.Lookup) constructor.newInstance(objArr2)).in(declaringClass).unreflectSpecial(method, declaringClass).bindTo(obj).invokeWithArguments(objArr);
                } else {
                    throw e;
                }
            }
        }
    }
}
