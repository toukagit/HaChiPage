package com.unity3d.player;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: base/dex/classes.dex */
final class ReflectionHelper {
    protected static boolean LOG = false;
    protected static final boolean LOGV = false;
    private static E[] a = new E[4096];
    private static long b = 0;
    private static long c = 0;
    private static boolean d = false;

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0075, code lost:
        if (r12.asSubclass(r11) != null) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static float a(java.lang.Class r11, java.lang.Class[] r12, java.lang.Class[] r13) {
        /*
            int r0 = r13.length
            r1 = 1036831949(0x3dcccccd, float:0.1)
            if (r0 != 0) goto L7
            return r1
        L7:
            r0 = 0
            if (r12 != 0) goto Lc
            r2 = r0
            goto Ld
        Lc:
            int r2 = r12.length
        Ld:
            int r2 = r2 + 1
            int r3 = r13.length
            r4 = 0
            if (r2 == r3) goto L14
            return r4
        L14:
            r2 = 1056964608(0x3f000000, float:0.5)
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r12 == 0) goto L4f
            int r5 = r12.length
            r6 = r0
            r7 = r3
        L1d:
            if (r0 >= r5) goto L50
            r8 = r12[r0]
            int r9 = r6 + 1
            r6 = r13[r6]
            boolean r10 = r8.equals(r6)
            if (r10 == 0) goto L2d
            r6 = r3
            goto L4a
        L2d:
            boolean r10 = r8.isPrimitive()
            if (r10 != 0) goto L49
            boolean r10 = r6.isPrimitive()
            if (r10 != 0) goto L49
            java.lang.Class r10 = r8.asSubclass(r6)     // Catch: java.lang.ClassCastException -> L41
            if (r10 == 0) goto L41
            r6 = r2
            goto L4a
        L41:
            java.lang.Class r6 = r6.asSubclass(r8)     // Catch: java.lang.ClassCastException -> L49
            if (r6 == 0) goto L49
            r6 = r1
            goto L4a
        L49:
            r6 = r4
        L4a:
            float r7 = r7 * r6
            int r0 = r0 + 1
            r6 = r9
            goto L1d
        L4f:
            r7 = r3
        L50:
            int r12 = r13.length
            int r12 = r12 + (-1)
            r12 = r13[r12]
            boolean r13 = r11.equals(r12)
            if (r13 == 0) goto L5d
            r1 = r3
            goto L79
        L5d:
            boolean r13 = r11.isPrimitive()
            if (r13 != 0) goto L78
            boolean r13 = r12.isPrimitive()
            if (r13 != 0) goto L78
            java.lang.Class r13 = r11.asSubclass(r12)     // Catch: java.lang.ClassCastException -> L71
            if (r13 == 0) goto L71
            r1 = r2
            goto L79
        L71:
            java.lang.Class r11 = r12.asSubclass(r11)     // Catch: java.lang.ClassCastException -> L78
            if (r11 == 0) goto L78
            goto L79
        L78:
            r1 = r4
        L79:
            float r7 = r7 * r1
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.ReflectionHelper.a(java.lang.Class, java.lang.Class[], java.lang.Class[]):float");
    }

    private static Class a(String str, int[] iArr) {
        while (iArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] < str.length()) {
            int i = iArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme];
            iArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = i + com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector;
            char charAt = str.charAt(i);
            if (charAt != '(' && charAt != ')') {
                if (charAt == 'L') {
                    int indexOf = str.indexOf(59, iArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme]);
                    if (indexOf == -1) {
                        return null;
                    }
                    String substring = str.substring(iArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme], indexOf);
                    iArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = indexOf + com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector;
                    try {
                        return Class.forName(substring.replace('/', '.'));
                    } catch (ClassNotFoundException unused) {
                        return null;
                    }
                } else if (charAt == 'Z') {
                    return Boolean.TYPE;
                } else {
                    if (charAt == 'I') {
                        return Integer.TYPE;
                    }
                    if (charAt == 'F') {
                        return Float.TYPE;
                    }
                    if (charAt == 'V') {
                        return Void.TYPE;
                    }
                    if (charAt == 'B') {
                        return Byte.TYPE;
                    }
                    if (charAt == 'C') {
                        return Character.TYPE;
                    }
                    if (charAt == 'S') {
                        return Short.TYPE;
                    }
                    if (charAt == 'J') {
                        return Long.TYPE;
                    }
                    if (charAt == 'D') {
                        return Double.TYPE;
                    }
                    if (charAt == '[') {
                        return Array.newInstance(a(str, iArr), (int) com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme).getClass();
                    }
                    AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.app_name, "! parseType; " + charAt + " is not known!");
                    return null;
                }
            }
        }
        return null;
    }

    private static synchronized boolean a(E e) {
        int i;
        boolean z;
        synchronized (ReflectionHelper.class) {
            E[] eArr = a;
            i = e.d;
            E e2 = eArr[i & 4095];
            if (e.equals(e2)) {
                e.e = e2.e;
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    private static Class[] a(String str) {
        Class a2;
        int[] iArr = new int[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector];
        int i = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        iArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        ArrayList arrayList = new ArrayList();
        while (iArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] < str.length() && (a2 = a(str, iArr)) != null) {
            arrayList.add(a2);
        }
        Class[] clsArr = new Class[arrayList.size()];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int i2 = i + com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector;
            clsArr[i] = (Class) it.next();
            i = i2;
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized boolean beginProxyCall(long j) {
        boolean z;
        synchronized (ReflectionHelper.class) {
            if (j == b) {
                c++;
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    protected static Object createInvocationError(long j, boolean z) {
        return new F(j, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized void endProxyCall() {
        synchronized (ReflectionHelper.class) {
            long j = c - 1;
            c = j;
            if (0 == j && d) {
                ReflectionHelper.class.notifyAll();
            }
        }
    }

    protected static synchronized void endUnityLaunch() {
        synchronized (ReflectionHelper.class) {
            try {
                b++;
                d = true;
                while (c > 0) {
                    ReflectionHelper.class.wait();
                }
            } catch (InterruptedException unused) {
                AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Interrupted while waiting for all proxies to exit.");
            }
            d = false;
        }
    }

    protected static Constructor getConstructorID(Class cls, String str) {
        int i;
        Constructor<?> constructor;
        E e = new E(cls, "", str);
        if (a(e)) {
            constructor = (Constructor) e.e;
        } else {
            Class[] a2 = a(str);
            float f = 0.0f;
            Constructor<?>[] constructors = cls.getConstructors();
            int length = constructors.length;
            Constructor<?> constructor2 = null;
            for (int i2 = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme; i2 < length; i2 += com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector) {
                Constructor<?> constructor3 = constructors[i2];
                float a3 = a(Void.TYPE, constructor3.getParameterTypes(), a2);
                if (a3 > f) {
                    constructor2 = constructor3;
                    if (a3 == 1.0f) {
                        break;
                    }
                    f = a3;
                }
            }
            synchronized (ReflectionHelper.class) {
                e.e = constructor2;
                E[] eArr = a;
                i = e.d;
                eArr[i & 4095] = e;
            }
            constructor = constructor2;
        }
        if (constructor != null) {
            return constructor;
        }
        throw new NoSuchMethodError("<init>" + str + " in class " + cls.getName());
    }

    protected static Field getFieldID(Class cls, String str, String str2, boolean z) {
        int i;
        Field field;
        Class cls2 = cls;
        E e = new E(cls2, str, str2);
        if (a(e)) {
            field = (Field) e.e;
        } else {
            Class[] a2 = a(str2);
            float f = 0.0f;
            Field field2 = null;
            while (cls2 != null) {
                Field[] declaredFields = cls2.getDeclaredFields();
                int length = declaredFields.length;
                int i2 = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    Field field3 = declaredFields[i2];
                    if (z == Modifier.isStatic(field3.getModifiers()) && field3.getName().compareTo(str) == 0) {
                        float a3 = a(field3.getType(), null, a2);
                        if (a3 > f) {
                            field2 = field3;
                            if (a3 == 1.0f) {
                                f = a3;
                                break;
                            }
                            f = a3;
                        } else {
                            continue;
                        }
                    }
                    i2 += com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector;
                }
                if (f == 1.0f || cls2.isPrimitive() || cls2.isInterface() || cls2.equals(Object.class) || cls2.equals(Void.TYPE)) {
                    break;
                }
                cls2 = cls2.getSuperclass();
            }
            synchronized (ReflectionHelper.class) {
                e.e = field2;
                E[] eArr = a;
                i = e.d;
                eArr[i & 4095] = e;
            }
            field = field2;
        }
        if (field == null) {
            Object[] objArr = new Object[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.FreeformWindowSize_tablet];
            objArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = z ? "static" : "non-static";
            objArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector] = str;
            objArr[2] = str2;
            objArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.FreeformWindowSize_phone] = cls2.getName();
            throw new NoSuchFieldError(String.format("no %s field with name='%s' signature='%s' in class L%s;", objArr));
        }
        return field;
    }

    protected static String getFieldSignature(Field field) {
        Class<?> type = field.getType();
        if (!type.isPrimitive()) {
            return type.isArray() ? type.getName().replace('.', '/') : "L" + type.getName().replace('.', '/') + ";";
        }
        String name = type.getName();
        return "boolean".equals(name) ? "Z" : "byte".equals(name) ? "B" : "char".equals(name) ? "C" : "double".equals(name) ? "D" : "float".equals(name) ? "F" : "int".equals(name) ? "I" : "long".equals(name) ? "J" : "short".equals(name) ? "S" : name;
    }

    protected static Method getMethodID(Class cls, String str, String str2, boolean z) {
        int i;
        Method method;
        E e = new E(cls, str, str2);
        if (a(e)) {
            method = (Method) e.e;
        } else {
            Class[] a2 = a(str2);
            float f = 0.0f;
            Method method2 = null;
            while (cls != null) {
                Method[] declaredMethods = cls.getDeclaredMethods();
                int length = declaredMethods.length;
                int i2 = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    Method method3 = declaredMethods[i2];
                    if (z == Modifier.isStatic(method3.getModifiers()) && method3.getName().compareTo(str) == 0) {
                        float a3 = a(method3.getReturnType(), method3.getParameterTypes(), a2);
                        if (a3 > f) {
                            method2 = method3;
                            if (a3 == 1.0f) {
                                f = a3;
                                break;
                            }
                            f = a3;
                        } else {
                            continue;
                        }
                    }
                    i2 += com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector;
                }
                if (f == 1.0f || cls.isPrimitive() || cls.isInterface() || cls.equals(Object.class) || cls.equals(Void.TYPE)) {
                    break;
                }
                cls = cls.getSuperclass();
            }
            synchronized (ReflectionHelper.class) {
                e.e = method2;
                E[] eArr = a;
                i = e.d;
                eArr[i & 4095] = e;
            }
            method = method2;
        }
        if (method == null) {
            Object[] objArr = new Object[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.FreeformWindowSize_tablet];
            objArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = z ? "static" : "non-static";
            objArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector] = str;
            objArr[2] = str2;
            objArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.FreeformWindowSize_phone] = cls.getName();
            throw new NoSuchMethodError(String.format("no %s method with name='%s' signature='%s' in class L%s;", objArr));
        }
        return method;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeProxyFinalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native Object nativeProxyInvoke(long j, String str, Object[] objArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeProxyJNIFreeGCHandle(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeProxyLogJNIInvokeException(long j);

    protected static Object newProxyInstance(UnityPlayer unityPlayer, long j, Class cls) {
        Class[] clsArr = new Class[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector];
        clsArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = cls;
        return newProxyInstance(unityPlayer, j, clsArr);
    }

    protected static Object newProxyInstance(UnityPlayer unityPlayer, long j, Class[] clsArr) {
        return Proxy.newProxyInstance(ReflectionHelper.class.getClassLoader(), clsArr, new D(unityPlayer, j));
    }
}
