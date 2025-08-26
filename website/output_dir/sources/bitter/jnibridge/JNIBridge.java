package bitter.jnibridge;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/* loaded from: base/dex/classes.dex */
public class JNIBridge {
    static void disableInterfaceProxy(Object obj) {
        Object[] objArr;
        if (obj != null) {
            a aVar = (a) Proxy.getInvocationHandler(obj);
            objArr = aVar.a;
            synchronized (objArr) {
                aVar.b = 0L;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native Object invoke(long j, Class cls, Method method, Object[] objArr);

    static Object newInterfaceProxy(long j, Class[] clsArr) {
        return Proxy.newProxyInstance(JNIBridge.class.getClassLoader(), clsArr, new a(j));
    }
}
