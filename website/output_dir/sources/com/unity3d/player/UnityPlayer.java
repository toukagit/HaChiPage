package com.unity3d.player;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.unity3d.player.UnityPermissions;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/* loaded from: base/dex/classes.dex */
public class UnityPlayer extends FrameLayout implements IUnityPlayerLifecycleEvents {
    private static final String ARCORE_ENABLE_METADATA_NAME = "unity.arcore-enable";
    private static final String AUTO_REPORT_FULLY_DRAWN_ENABLE_METADATA_NAME = "unity.auto-report-fully-drawn";
    private static final String LAUNCH_FULLSCREEN = "unity.launch-fullscreen";
    private static final int RUN_STATE_CHANGED_MSG_CODE = 2269;
    private static final String SPLASH_ENABLE_METADATA_NAME = "unity.splash-enable";
    private static final String SPLASH_MODE_METADATA_NAME = "unity.splash-mode";
    public static Activity currentActivity;
    public static Context currentContext;
    private Activity mActivity;
    private Context mContext;
    private Z mGlView;
    Handler mHandler;
    private int mInitialScreenOrientation;
    private boolean mIsFullscreen;
    private boolean mMainDisplayOverride;
    private int mNaturalOrientation;
    private InterfaceC0044w mOnHandleFocusListener;
    private OrientationEventListener mOrientationListener;
    private boolean mProcessKillRequested;
    private boolean mQuitting;
    J mSoftInput;
    private long mSoftInputTimeoutMilliSeconds;
    private K0 mState;
    private V0 mVideoPlayerProxy;
    private GoogleARCoreApi m_ARCoreApi;
    private boolean m_AddPhoneCallListener;
    private AudioVolumeHandler m_AudioVolumeHandler;
    private Camera2Wrapper m_Camera2Wrapper;
    private ClipboardManager m_ClipboardManager;
    private final ConcurrentLinkedQueue m_Events;
    private E0 m_FakeListener;
    private HFPStatus m_HFPStatus;
    private int m_IsNoWindowMode;
    I0 m_MainThread;
    private NetworkConnectivity m_NetworkConnectivity;
    private OrientationLockListener m_OrientationLockListener;
    private F0 m_PhoneCallListener;
    private com.unity3d.player.a.e m_SplashScreen;
    private TelephonyManager m_TelephonyManager;
    private IUnityPlayerLifecycleEvents m_UnityPlayerLifecycleEvents;
    Window m_Window;
    private Uri m_launchUri;
    private Configuration prevConfig;

    /* loaded from: base/dex/classes.dex */
    public static final class SynchronizationTimeout {
        private static final /* synthetic */ SynchronizationTimeout[] $VALUES;
        public static final SynchronizationTimeout Destroy;
        public static final SynchronizationTimeout Pause;
        public static final SynchronizationTimeout SurfaceDetach;
        private int m_TimeoutMilliseconds = 2000;
        final int value;

        static {
            SynchronizationTimeout synchronizationTimeout = new SynchronizationTimeout("Pause", com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme, com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme);
            Pause = synchronizationTimeout;
            SynchronizationTimeout synchronizationTimeout2 = new SynchronizationTimeout("SurfaceDetach", com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector, com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector);
            SurfaceDetach = synchronizationTimeout2;
            SynchronizationTimeout synchronizationTimeout3 = new SynchronizationTimeout("Destroy", 2, 2);
            Destroy = synchronizationTimeout3;
            SynchronizationTimeout[] synchronizationTimeoutArr = new SynchronizationTimeout[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.FreeformWindowSize_phone];
            synchronizationTimeoutArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = synchronizationTimeout;
            synchronizationTimeoutArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector] = synchronizationTimeout2;
            synchronizationTimeoutArr[2] = synchronizationTimeout3;
            $VALUES = synchronizationTimeoutArr;
        }

        private SynchronizationTimeout(String str, int i, int i2) {
            super(str, i);
            this.value = i2;
            this.m_TimeoutMilliseconds = 2000;
        }

        public static void setTimeoutForAll(int i) {
            SynchronizationTimeout[] synchronizationTimeoutArr = (SynchronizationTimeout[]) SynchronizationTimeout.class.getEnumConstants();
            int length = synchronizationTimeoutArr.length;
            for (int i2 = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme; i2 < length; i2 += com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector) {
                synchronizationTimeoutArr[i2].setTimeout(i);
            }
        }

        public static SynchronizationTimeout valueOf(String str) {
            return (SynchronizationTimeout) Enum.valueOf(SynchronizationTimeout.class, str);
        }

        public static SynchronizationTimeout[] values() {
            return (SynchronizationTimeout[]) $VALUES.clone();
        }

        public int getTimeout() {
            return this.m_TimeoutMilliseconds;
        }

        public void setTimeout(int i) {
            this.m_TimeoutMilliseconds = i;
        }
    }

    static {
        new X().a();
    }

    public UnityPlayer(Context context) {
        this(context, null);
    }

    public UnityPlayer(Context context, IUnityPlayerLifecycleEvents iUnityPlayerLifecycleEvents) {
        super(context);
        this.mHandler = new Handler();
        this.mInitialScreenOrientation = -1;
        this.mMainDisplayOverride = false;
        this.mIsFullscreen = true;
        this.mState = new K0();
        this.m_Events = new ConcurrentLinkedQueue();
        this.mOrientationListener = null;
        this.m_MainThread = new I0(this);
        this.m_AddPhoneCallListener = false;
        this.m_PhoneCallListener = new F0(this);
        this.m_ARCoreApi = null;
        this.m_FakeListener = new E0();
        this.m_Camera2Wrapper = null;
        this.m_HFPStatus = null;
        this.m_AudioVolumeHandler = null;
        this.m_OrientationLockListener = null;
        this.m_launchUri = null;
        this.m_NetworkConnectivity = null;
        this.m_UnityPlayerLifecycleEvents = null;
        this.m_IsNoWindowMode = -1;
        this.mSoftInputTimeoutMilliSeconds = 1000L;
        this.mProcessKillRequested = true;
        this.mSoftInput = null;
        this.m_UnityPlayerLifecycleEvents = iUnityPlayerLifecycleEvents == null ? this : iUnityPlayerLifecycleEvents;
        X.a(getUnityNativeLibraryPath(context));
        currentContext = context;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            this.mActivity = activity;
            currentActivity = activity;
            this.mInitialScreenOrientation = activity.getRequestedOrientation();
            this.m_launchUri = this.mActivity.getIntent().getData();
        }
        this.mContext = context;
        EarlyEnableFullScreenIfEnabled();
        Configuration configuration = getResources().getConfiguration();
        this.prevConfig = configuration;
        this.mNaturalOrientation = getNaturalOrientation(configuration.orientation);
        if (this.mActivity != null && getSplashEnabled()) {
            com.unity3d.player.a.e eVar = new com.unity3d.player.a.e(this.mContext, com.unity3d.player.a.d.a()[getSplashMode()]);
            this.m_SplashScreen = eVar;
            addView(eVar);
        }
        preloadJavaPlugins();
        String loadNative = loadNative(getUnityNativeLibraryPath(this.mContext));
        if (!K0.d()) {
            AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Your hardware does not support this application.");
            AlertDialog create = new AlertDialog.Builder(this.mContext).setTitle("Failure to initialize!").setPositiveButton("OK", new DialogInterface$OnClickListenerC0027n0(this)).setMessage("Your hardware does not support this application.\n\n" + loadNative + "\n\n Press OK to quit.").create();
            create.setCancelable(false);
            create.show();
            return;
        }
        initJni(context);
        this.mState.d(true);
        Z z = new Z(context, this);
        this.mGlView = z;
        addView(z);
        bringChildToFront(this.m_SplashScreen);
        this.mQuitting = false;
        Activity activity2 = this.mActivity;
        if (activity2 != null) {
            this.m_Window = activity2.getWindow();
        }
        hideStatusBar();
        this.m_TelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
        this.m_ClipboardManager = (ClipboardManager) this.mContext.getSystemService("clipboard");
        this.m_Camera2Wrapper = new Camera2Wrapper(this.mContext);
        this.m_HFPStatus = new HFPStatus(this.mContext);
        this.m_MainThread.start();
    }

    public void DisableStaticSplashScreen() {
        runOnUiThread(new w0(this));
    }

    private void EarlyEnableFullScreenIfEnabled() {
        View decorView;
        Activity activity = this.mActivity;
        if (activity != null && activity.getWindow() != null && ((getLaunchFullscreen() || this.mActivity.getIntent().getBooleanExtra("android.intent.extra.VR_LAUNCH", false)) && (decorView = this.mActivity.getWindow().getDecorView()) != null)) {
            decorView.setSystemUiVisibility(7);
        }
        AbstractC0036s.a(this.mActivity);
    }

    private String GetGlViewContentDescription(Context context) {
        return context.getResources().getString(context.getResources().getIdentifier("game_view_content_description", "string", context.getPackageName()));
    }

    private boolean IsWindowTranslucent() {
        Activity activity = this.mActivity;
        if (activity == null) {
            return false;
        }
        Resources.Theme theme = activity.getTheme();
        int[] iArr = new int[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector];
        iArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = 16842840;
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(iArr);
        boolean z = obtainStyledAttributes.getBoolean(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    public static void UnitySendMessage(String str, String str2, String str3) {
        if (!K0.d()) {
            AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.app_name, "Native libraries not loaded - dropping message for " + str + "." + str2);
            return;
        }
        try {
            nativeUnitySendMessage(str, str2, str3.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
        }
    }

    private void checkResumePlayer() {
        Activity activity = this.mActivity;
        if (this.mState.a(activity != null ? MultiWindowSupport.isInMultiWindowMode(activity) : false)) {
            this.mState.c(true);
            queueGLThreadEvent(new RunnableC0001a0(this));
            this.m_MainThread.a(G0.b);
        }
    }

    public void dismissSoftInput() {
        J j = this.mSoftInput;
        if (j != null) {
            j.c();
            nativeReportKeyboardConfigChanged();
        }
    }

    public void finish() {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        this.mActivity.finish();
    }

    private boolean getARCoreEnabled() {
        try {
            return getApplicationInfo().metaData.getBoolean(ARCORE_ENABLE_METADATA_NAME);
        } catch (Exception unused) {
            return false;
        }
    }

    private ActivityInfo getActivityInfo() {
        return this.mActivity.getPackageManager().getActivityInfo(this.mActivity.getComponentName(), 128);
    }

    private ApplicationInfo getApplicationInfo() {
        return this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 128);
    }

    public boolean getAutoReportFullyDrawnEnabled() {
        try {
            return getApplicationInfo().metaData.getBoolean(AUTO_REPORT_FULLY_DRAWN_ENABLE_METADATA_NAME);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean getHaveAndroidWindowSupport() {
        if (this.m_IsNoWindowMode == -1) {
            this.m_IsNoWindowMode = nativeGetNoWindowMode() ? 1 : 0;
        }
        return this.m_IsNoWindowMode == com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector;
    }

    private boolean getLaunchFullscreen() {
        try {
            return getApplicationInfo().metaData.getBoolean(LAUNCH_FULLSCREEN);
        } catch (Exception unused) {
            return false;
        }
    }

    private int getNaturalOrientation(int i) {
        int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        return ((rotation == 0 || rotation == 2) && i == 2) ? com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme : ((rotation == com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector || rotation == com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.FreeformWindowSize_phone) && i == com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector) ? com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme : com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector;
    }

    private String getProcessName() {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.mContext.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    private long getSoftInputTimeout() {
        return Math.round(this.mSoftInputTimeoutMilliSeconds * Math.max(1.0f, Settings.System.getFloat(this.mContext.getContentResolver(), "animator_duration_scale", 0.0f)));
    }

    public boolean getSplashEnabled() {
        try {
            return getApplicationInfo().metaData.getBoolean(SPLASH_ENABLE_METADATA_NAME);
        } catch (Exception unused) {
            return false;
        }
    }

    private static String getUnityNativeLibraryPath(Context context) {
        return context.getApplicationInfo().nativeLibraryDir;
    }

    private void hidePreservedContent() {
        runOnUiThread(new RunnableC0007d0(this));
    }

    private void hideStatusBar() {
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.getWindow().setFlags(1024, 1024);
        }
    }

    private final native void initJni(Context context);

    private static String loadNative(String str) {
        String str2 = str + "/libmain.so";
        try {
            try {
                try {
                    System.load(str2);
                } catch (SecurityException e) {
                    return logLoadLibMainError(str2, e.toString());
                }
            } catch (UnsatisfiedLinkError e2) {
                return logLoadLibMainError(str2, e2.toString());
            }
        } catch (UnsatisfiedLinkError unused) {
            System.loadLibrary("main");
        }
        if (NativeLoader.load(str)) {
            K0.e();
            return "";
        }
        AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "NativeLoader.load failure, Unity libraries were not loaded.");
        return "NativeLoader.load failure, Unity libraries were not loaded.";
    }

    private static String logLoadLibMainError(String str, String str2) {
        String str3 = "Failed to load 'libmain.so'\n\n" + str2;
        AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, str3);
        return str3;
    }

    private final native void nativeApplicationUnload();

    private final native boolean nativeDone();

    public final native void nativeFocusChanged(boolean z);

    private final native boolean nativeGetNoWindowMode();

    private final native void nativeHidePreservedContent();

    private final native boolean nativeInjectEvent(InputEvent inputEvent, int i);

    public final native boolean nativeIsAutorotationOn();

    public final native void nativeLowMemory();

    public final native void nativeMuteMasterAudio(boolean z);

    public final native void nativeOrientationChanged(int i, int i2);

    public final native boolean nativePause();

    public final native void nativeRecreateGfxState(int i, Surface surface);

    public final native boolean nativeRender();

    public final native void nativeReportKeyboardConfigChanged();

    private final native void nativeRestartActivityIndicator();

    public final native void nativeResume();

    public final native void nativeSendSurfaceChangedEvent();

    public final native void nativeSetInputArea(int i, int i2, int i3, int i4);

    public final native void nativeSetInputSelection(int i, int i2);

    public final native void nativeSetInputString(String str);

    public final native void nativeSetKeyboardIsVisible(boolean z);

    public final native void nativeSetLaunchURL(String str);

    public final native void nativeSoftInputCanceled();

    public final native void nativeSoftInputClosed();

    public final native void nativeSoftInputLostFocus();

    private static native void nativeUnitySendMessage(String str, String str2, byte[] bArr);

    private void pauseUnity() {
        reportSoftInputStr(null, com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector, true);
        if (!this.mState.c() || this.mState.b()) {
            return;
        }
        if (K0.d()) {
            Semaphore semaphore = new Semaphore(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme);
            Runnable b0 = isFinishing() ? new B0(this, semaphore) : new C0(this, semaphore);
            I0 i0 = this.m_MainThread;
            if (i0.a != null) {
                i0.a(G0.a);
                Message.obtain(i0.a, b0).sendToTarget();
            }
            try {
                SynchronizationTimeout synchronizationTimeout = SynchronizationTimeout.Pause;
                if (!semaphore.tryAcquire(synchronizationTimeout.getTimeout(), TimeUnit.MILLISECONDS)) {
                    AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.app_name, "Timeout (" + synchronizationTimeout.getTimeout() + " ms) while trying to pause the Unity Engine.");
                }
            } catch (InterruptedException unused) {
                AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.app_name, "UI thread got interrupted while trying to pause the Unity Engine.");
            }
        }
        this.mState.c(false);
        this.mState.e(true);
        if (this.m_AddPhoneCallListener) {
            this.m_TelephonyManager.listen(this.m_PhoneCallListener, com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme);
        }
    }

    private static void preloadJavaPlugins() {
        try {
            Class.forName("com.unity3d.JavaPluginPreloader");
        } catch (ClassNotFoundException unused) {
        } catch (LinkageError e) {
            AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Java class preloading failed: " + e.getMessage());
        }
    }

    public void queueDestroy() {
        AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.FreeformWindowSize_tablet, "Queue Destroy");
        runOnUiThread(new A0(this));
    }

    private void queueGLThreadEvent(J0 j0) {
        if (isFinishing()) {
            return;
        }
        queueGLThreadEvent((Runnable) j0);
    }

    private void raiseFocusListener(boolean z) {
        InterfaceC0044w interfaceC0044w = this.mOnHandleFocusListener;
        if (interfaceC0044w != null) {
            RunnableC0013g0 runnableC0013g0 = ((C0009e0) interfaceC0044w).a;
            runnableC0013g0.b = true;
            if (runnableC0013g0.a) {
                runnableC0013g0.c.release();
            }
        }
    }

    public void shutdown() {
        this.mProcessKillRequested = nativeDone();
        this.mState.d(false);
    }

    private void swapViews(View view, View view2) {
        boolean z;
        if (this.mState.b()) {
            z = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        } else {
            setupUnityToBePaused();
            z = true;
        }
        if (view != null) {
            ViewParent parent = view.getParent();
            if (!(parent instanceof UnityPlayer) || ((UnityPlayer) parent) != this) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                }
                addView(view);
                bringChildToFront(view);
                view.setVisibility(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme);
            }
        }
        if (view2 != null && view2.getParent() == this) {
            view2.setVisibility(8);
            removeView(view2);
        }
        if (z) {
            setupUnityToBeResumed();
        }
    }

    private static void unloadNative() {
        if (K0.d()) {
            if (!NativeLoader.unload()) {
                throw new UnsatisfiedLinkError("Unable to unload libraries from libmain.so");
            }
            K0.f();
        }
    }

    private boolean updateDisplayInternal(int i, Surface surface) {
        if (K0.d() && this.mState.a()) {
            Semaphore semaphore = new Semaphore(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme);
            y0 y0Var = new y0(this, i, surface, semaphore);
            if (i == 0) {
                I0 i0 = this.m_MainThread;
                Handler handler = i0.a;
                if (surface == null) {
                    if (handler != null) {
                        i0.a(G0.d);
                        Message.obtain(i0.a, y0Var).sendToTarget();
                    }
                } else if (handler != null) {
                    Message.obtain(handler, y0Var).sendToTarget();
                    i0.a(G0.e);
                }
            } else {
                y0Var.run();
            }
            if (surface == null && i == 0) {
                try {
                    SynchronizationTimeout synchronizationTimeout = SynchronizationTimeout.SurfaceDetach;
                    if (semaphore.tryAcquire(synchronizationTimeout.getTimeout(), TimeUnit.MILLISECONDS)) {
                        return true;
                    }
                    AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.app_name, "Timeout (" + synchronizationTimeout.getTimeout() + " ms) while trying detaching primary window.");
                    return true;
                } catch (InterruptedException unused) {
                    AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.app_name, "UI thread got interrupted while trying to detach the primary window from the Unity Engine.");
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    protected void addPhoneCallListener() {
        this.m_AddPhoneCallListener = true;
        this.m_TelephonyManager.listen(this.m_PhoneCallListener, 32);
    }

    public boolean addViewToPlayer(View view, boolean z) {
        swapViews(view, z ? this.mGlView : null);
        boolean z2 = true;
        boolean z3 = view.getParent() == this ? com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector : com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        boolean z4 = (z && this.mGlView.getParent() == null) ? com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector : com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        boolean z5 = this.mGlView.getParent() == this ? com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector : com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        if (!z3 || (!z4 && !z5)) {
            z2 = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        }
        if (!z2) {
            if (!z3) {
                AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "addViewToPlayer: Failure adding view to hierarchy");
            }
            if (!z4 && !z5) {
                AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "addViewToPlayer: Failure removing old view from hierarchy");
            }
        }
        return z2;
    }

    public void configurationChanged(Configuration configuration) {
        int diff = this.prevConfig.diff(configuration);
        if ((diff & 256) != 0 || (diff & 1024) != 0 || (diff & 2048) != 0 || (diff & 128) != 0) {
            nativeHidePreservedContent();
        }
        this.prevConfig = new Configuration(configuration);
        V0 v0 = this.mVideoPlayerProxy;
        if (v0 != null) {
            v0.a();
        }
    }

    public void destroy() {
        Camera2Wrapper camera2Wrapper = this.m_Camera2Wrapper;
        if (camera2Wrapper != null) {
            camera2Wrapper.a();
            this.m_Camera2Wrapper = null;
        }
        HFPStatus hFPStatus = this.m_HFPStatus;
        if (hFPStatus != null) {
            hFPStatus.b();
            this.m_HFPStatus = null;
        }
        NetworkConnectivity networkConnectivity = this.m_NetworkConnectivity;
        if (networkConnectivity != null) {
            networkConnectivity.a();
            this.m_NetworkConnectivity = null;
        }
        this.mQuitting = true;
        if (!this.mState.b()) {
            setupUnityToBePaused();
        }
        this.m_MainThread.a(G0.c);
        try {
            this.m_MainThread.join(SynchronizationTimeout.Destroy.getTimeout());
        } catch (InterruptedException unused) {
            this.m_MainThread.interrupt();
        }
        if (K0.d()) {
            removeAllViews();
        }
        if (this.mProcessKillRequested) {
            this.m_UnityPlayerLifecycleEvents.onUnityPlayerQuitted();
            kill();
        }
        unloadNative();
    }

    protected void disableLogger() {
        AbstractC0040u.a = true;
    }

    public boolean displayChanged(int i, Surface surface) {
        if (i == 0) {
            this.mMainDisplayOverride = surface != null;
            runOnUiThread(new z0(this));
        }
        return updateDisplayInternal(i, surface);
    }

    public void executeGLThreadJobs() {
        while (true) {
            Runnable runnable = (Runnable) this.m_Events.poll();
            if (runnable == null) {
                return;
            }
            runnable.run();
        }
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    protected String getClipboardText() {
        ClipData primaryClip = this.m_ClipboardManager.getPrimaryClip();
        return primaryClip != null ? primaryClip.getItemAt(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme).coerceToText(this.mContext).toString() : "";
    }

    protected String getKeyboardLayout() {
        J j = this.mSoftInput;
        if (j == null) {
            return null;
        }
        return j.a();
    }

    public String getLaunchURL() {
        Uri uri = this.m_launchUri;
        if (uri != null) {
            return uri.toString();
        }
        return null;
    }

    protected int getNetworkConnectivity() {
        NetworkConnectivity networkConnectivity = this.m_NetworkConnectivity;
        if (networkConnectivity != null) {
            return networkConnectivity.b();
        }
        this.m_NetworkConnectivity = PlatformSupport.NOUGAT_SUPPORT ? new NetworkConnectivityNougat(this.mContext) : new NetworkConnectivity(this.mContext);
        return this.m_NetworkConnectivity.b();
    }

    public String getNetworkProxySettings(String str) {
        String str2;
        String str3;
        if (!str.startsWith("http:")) {
            if (str.startsWith("https:")) {
                str2 = "https.proxyHost";
                str3 = "https.proxyPort";
            }
            return null;
        }
        str2 = "http.proxyHost";
        str3 = "http.proxyPort";
        String property = System.getProperties().getProperty(str2);
        if (property != null && !"".equals(property)) {
            StringBuilder sb = new StringBuilder(property);
            String property2 = System.getProperties().getProperty(str3);
            if (property2 != null && !"".equals(property2)) {
                sb.append(":").append(property2);
            }
            String property3 = System.getProperties().getProperty("http.nonProxyHosts");
            if (property3 != null && !"".equals(property3)) {
                sb.append('\n').append(property3);
            }
            return sb.toString();
        }
        return null;
    }

    public float getScreenBrightness() {
        Window window = this.m_Window;
        if (window == null) {
            return 1.0f;
        }
        float f = window.getAttributes().screenBrightness;
        if (f < 0.0f) {
            int i = Settings.System.getInt(getContext().getContentResolver(), "screen_brightness", 255);
            return PlatformSupport.PIE_SUPPORT ? (float) Math.max(0.0d, Math.min(1.0d, ((Math.log(i) * 19.811d) - 9.411d) / 100.0d)) : i / 255.0f;
        }
        return f;
    }

    public Bundle getSettings() {
        return Bundle.EMPTY;
    }

    protected int getSplashMode() {
        try {
            return getApplicationInfo().metaData.getInt(SPLASH_MODE_METADATA_NAME);
        } catch (Exception unused) {
            return com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        }
    }

    protected int getUaaLLaunchProcessType() {
        String processName = getProcessName();
        return (processName == null || processName.equals(this.mContext.getPackageName())) ? com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme : com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector;
    }

    public View getView() {
        return this;
    }

    protected void hideSoftInput() {
        if (this.mSoftInput == null) {
            return;
        }
        reportSoftInputArea(new Rect());
        reportSoftInputIsVisible(false);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            dismissSoftInput();
            return;
        }
        Semaphore semaphore = new Semaphore(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme);
        postOnUiThread(new RunnableC0013g0(this, semaphore, this));
        try {
            try {
                if (!semaphore.tryAcquire(getSoftInputTimeout(), TimeUnit.MILLISECONDS)) {
                    AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Timeout (" + getSoftInputTimeout() + " ms) while waiting softinput hiding operation.");
                }
            } catch (InterruptedException unused) {
                AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "UI thread got interrupted while waiting softinput hiding operation.");
            }
        } finally {
            this.mSoftInput = null;
        }
    }

    public void init(int i, boolean z) {
    }

    protected boolean initializeGoogleAr() {
        if (this.m_ARCoreApi == null && this.mActivity != null && getARCoreEnabled()) {
            GoogleARCoreApi googleARCoreApi = new GoogleARCoreApi();
            this.m_ARCoreApi = googleARCoreApi;
            googleARCoreApi.initializeARCore(this.mActivity);
            if (this.mState.b()) {
                return false;
            }
            this.m_ARCoreApi.resumeARCore();
            return false;
        }
        return false;
    }

    public boolean injectEvent(InputEvent inputEvent) {
        return injectEvent(inputEvent, com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme);
    }

    public boolean injectEvent(InputEvent inputEvent, int i) {
        if (K0.d()) {
            return nativeInjectEvent(inputEvent, i);
        }
        return false;
    }

    public boolean isFinishing() {
        if (this.mQuitting) {
            return true;
        }
        Activity activity = this.mActivity;
        if (activity != null) {
            this.mQuitting = activity.isFinishing();
        }
        return this.mQuitting;
    }

    protected boolean isUaaLUseCase() {
        String callingPackage;
        Activity activity = this.mActivity;
        return (activity == null || (callingPackage = activity.getCallingPackage()) == null || !callingPackage.equals(this.mContext.getPackageName())) ? false : true;
    }

    protected void kill() {
        Process.killProcess(Process.myPid());
    }

    protected boolean loadLibrary(String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (Exception | UnsatisfiedLinkError unused) {
            return false;
        }
    }

    public void lowMemory() {
        if (K0.d()) {
            queueGLThreadEvent(new D0(this));
        }
    }

    public void newIntent(Intent intent) {
        this.m_launchUri = intent.getData();
        this.m_MainThread.a(G0.i);
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (this.mGlView.c()) {
            return false;
        }
        return injectEvent(motionEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    public void onPause() {
        MultiWindowSupport.saveMultiWindowMode(this.mActivity);
        if (MultiWindowSupport.isInMultiWindowMode(this.mActivity)) {
            return;
        }
        setupUnityToBePaused();
    }

    public void onResume() {
        if (!MultiWindowSupport.isInMultiWindowMode(this.mActivity) || MultiWindowSupport.isMultiWindowModeChangedToTrue(this.mActivity)) {
            setupUnityToBeResumed();
        }
    }

    public void onStart() {
        if (MultiWindowSupport.isInMultiWindowMode(this.mActivity)) {
            setupUnityToBeResumed();
        }
    }

    public void onStop() {
        if (MultiWindowSupport.isInMultiWindowMode(this.mActivity)) {
            setupUnityToBePaused();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mGlView.c()) {
            return false;
        }
        return injectEvent(motionEvent);
    }

    @Override // com.unity3d.player.IUnityPlayerLifecycleEvents
    public void onUnityPlayerQuitted() {
    }

    @Override // com.unity3d.player.IUnityPlayerLifecycleEvents
    public void onUnityPlayerUnloaded() {
    }

    public void pause() {
        setupUnityToBePaused();
    }

    protected void pauseJavaAndCallUnloadCallback() {
        runOnUiThread(new RunnableC0037s0(this));
    }

    void postOnUiThread(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void queueGLThreadEvent(Runnable runnable) {
        if (K0.d()) {
            if (Thread.currentThread() == this.m_MainThread) {
                runnable.run();
            } else {
                this.m_Events.add(runnable);
            }
        }
    }

    public void quit() {
        destroy();
    }

    public void removeViewFromPlayer(View view) {
        swapViews(this.mGlView, view);
        boolean z = true;
        boolean z2 = view.getParent() == null ? com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector : com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        boolean z3 = this.mGlView.getParent() == this ? com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector : com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        if (!z2 || !z3) {
            z = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        }
        if (z) {
            return;
        }
        if (!z2) {
            AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "removeViewFromPlayer: Failure removing view from hierarchy");
        }
        if (z3) {
            return;
        }
        AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "removeVireFromPlayer: Failure agging old view to hierarchy");
    }

    public void reportError(String str, String str2) {
        AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, str + ": " + str2);
    }

    public void reportSoftInputArea(Rect rect) {
        queueGLThreadEvent((J0) new C0029o0(this, rect));
    }

    public void reportSoftInputIsVisible(boolean z) {
        queueGLThreadEvent((J0) new C0031p0(this, z));
    }

    public void reportSoftInputSelection(int i, int i2) {
        queueGLThreadEvent((J0) new C0025m0(this, i, i2));
    }

    public void reportSoftInputStr(String str, int i, boolean z) {
        if (i == com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector) {
            hideSoftInput();
        }
        queueGLThreadEvent((J0) new C0023l0(this, z, str, i));
    }

    protected void requestUserAuthorization(String str) {
        if (str == null || str.isEmpty() || this.mActivity == null) {
            return;
        }
        UnityPermissions.ModalWaitForPermissionResponse modalWaitForPermissionResponse = new UnityPermissions.ModalWaitForPermissionResponse();
        Activity activity = this.mActivity;
        String[] strArr = new String[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector];
        strArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = str;
        UnityPermissions.requestUserPermissions(activity, strArr, modalWaitForPermissionResponse);
        modalWaitForPermissionResponse.waitForResponse();
    }

    public void resume() {
        setupUnityToBeResumed();
    }

    void runOnAnonymousThread(Runnable runnable) {
        new Thread(runnable).start();
    }

    void runOnUiThread(Runnable runnable) {
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.runOnUiThread(runnable);
        } else if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.mHandler.post(runnable);
        } else {
            runnable.run();
        }
    }

    public void sendSurfaceChangedEvent() {
        if (K0.d() && this.mState.a()) {
            x0 x0Var = new x0(this);
            Handler handler = this.m_MainThread.a;
            if (handler != null) {
                Message.obtain(handler, x0Var).sendToTarget();
            }
        }
    }

    protected void setCharacterLimit(int i) {
        runOnUiThread(new RunnableC0017i0(this, i));
    }

    protected void setClipboardText(String str) {
        this.m_ClipboardManager.setPrimaryClip(ClipData.newPlainText("Text", str));
    }

    protected void setHideInputField(boolean z) {
        runOnUiThread(new RunnableC0019j0(this, z));
    }

    public void setMainSurfaceViewAspectRatio(float f) {
        if (this.mGlView != null) {
            runOnUiThread(new RunnableC0041u0(this, f));
        }
    }

    public void setOnHandleFocusListener(InterfaceC0044w interfaceC0044w) {
        this.mOnHandleFocusListener = interfaceC0044w;
    }

    public void setScreenBrightness(float f) {
        float max = Math.max(0.04f, f);
        if (this.m_Window == null || getScreenBrightness() == max) {
            return;
        }
        runOnUiThread(new RunnableC0043v0(this, max));
    }

    protected void setSelection(int i, int i2) {
        runOnUiThread(new RunnableC0021k0(this, i, i2));
    }

    protected void setSoftInputStr(String str) {
        runOnUiThread(new RunnableC0015h0(this, str));
    }

    public void setupUnityToBePaused() {
        GoogleARCoreApi googleARCoreApi = this.m_ARCoreApi;
        if (googleARCoreApi != null) {
            googleARCoreApi.pauseARCore();
        }
        V0 v0 = this.mVideoPlayerProxy;
        if (v0 != null) {
            v0.b();
        }
        AudioVolumeHandler audioVolumeHandler = this.m_AudioVolumeHandler;
        if (audioVolumeHandler != null) {
            audioVolumeHandler.a();
            this.m_AudioVolumeHandler = null;
        }
        OrientationLockListener orientationLockListener = this.m_OrientationLockListener;
        if (orientationLockListener != null) {
            orientationLockListener.a();
            this.m_OrientationLockListener = null;
        }
        pauseUnity();
    }

    protected void setupUnityToBeResumed() {
        GoogleARCoreApi googleARCoreApi = this.m_ARCoreApi;
        if (googleARCoreApi != null) {
            googleARCoreApi.resumeARCore();
        }
        this.mState.e(false);
        V0 v0 = this.mVideoPlayerProxy;
        if (v0 != null) {
            v0.c();
        }
        checkResumePlayer();
        if (K0.d()) {
            nativeRestartActivityIndicator();
        }
        if (this.m_AudioVolumeHandler == null) {
            this.m_AudioVolumeHandler = new AudioVolumeHandler(this.mContext);
        }
        if (this.m_OrientationLockListener == null && K0.d()) {
            this.m_OrientationLockListener = new OrientationLockListener(this.mContext);
        }
        this.prevConfig = getResources().getConfiguration();
    }

    protected void showSoftInput(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2, boolean z5, boolean z6) {
        Semaphore semaphore = new Semaphore(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme);
        postOnUiThread(new RunnableC0005c0(this, this, str, i, z, z2, z3, z4, str2, i2, z5, z6, semaphore));
        try {
            if (semaphore.tryAcquire(getSoftInputTimeout(), TimeUnit.MILLISECONDS)) {
                return;
            }
            AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Timeout (" + getSoftInputTimeout() + " ms) while waiting softinput showing operation.");
        } catch (InterruptedException unused) {
            AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "UI thread got interrupted while waiting softinput showing operation.");
        }
    }

    protected boolean showVideoPlayer(String str, int i, int i2, int i3, boolean z, int i4, int i5) {
        if (this.mVideoPlayerProxy == null) {
            this.mVideoPlayerProxy = new V0(this);
        }
        boolean a = this.mVideoPlayerProxy.a(this.mContext, str, i, i2, i3, z, i4, i5, new C0033q0(this));
        if (a) {
            runOnUiThread(new RunnableC0035r0(this));
        }
        return a;
    }

    protected boolean skipPermissionsDialog() {
        Activity activity = this.mActivity;
        if (activity != null) {
            return UnityPermissions.skipPermissionsDialog(activity);
        }
        return false;
    }

    public boolean startOrientationListener(int i) {
        String str;
        if (this.mOrientationListener != null) {
            str = "Orientation Listener already started.";
        } else {
            C0039t0 c0039t0 = new C0039t0(this, this.mContext, i);
            this.mOrientationListener = c0039t0;
            if (c0039t0.canDetectOrientation()) {
                this.mOrientationListener.enable();
                return true;
            }
            str = "Orientation Listener cannot detect orientation.";
        }
        AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.app_name, str);
        return false;
    }

    public boolean stopOrientationListener() {
        OrientationEventListener orientationEventListener = this.mOrientationListener;
        if (orientationEventListener == null) {
            AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.app_name, "Orientation Listener was not started.");
            return false;
        }
        orientationEventListener.disable();
        this.mOrientationListener = null;
        return true;
    }

    protected void toggleGyroscopeSensor(boolean z) {
        SensorManager sensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(11);
        if (z) {
            sensorManager.registerListener(this.m_FakeListener, defaultSensor, com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector);
        } else {
            sensorManager.unregisterListener(this.m_FakeListener);
        }
    }

    public void unload() {
        nativeApplicationUnload();
    }

    public void updateGLDisplay(int i, Surface surface) {
        if (this.mMainDisplayOverride) {
            return;
        }
        updateDisplayInternal(i, surface);
    }

    public void windowFocusChanged(boolean z) {
        J j;
        this.mState.b(z);
        if (!this.mState.a() || ((j = this.mSoftInput) != null && !j.d())) {
            raiseFocusListener(z);
            return;
        }
        this.m_MainThread.a(z ? G0.g : G0.f);
        raiseFocusListener(z);
        checkResumePlayer();
    }
}
