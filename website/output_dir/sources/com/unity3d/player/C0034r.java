package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Range;
import android.util.Size;
import android.util.SizeF;
import android.view.Surface;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/* renamed from: com.unity3d.player.r  reason: case insensitive filesystem */
/* loaded from: base/dex/classes.dex */
public final class C0034r {
    private static CameraManager B;
    private static String[] C;
    private static Semaphore D = new Semaphore(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector);
    private com.unity3d.player.a.b a;
    private CameraDevice b;
    private HandlerThread c;
    private Handler d;
    private Rect e;
    private Rect f;
    private int g;
    private int h;
    private int k;
    private int l;
    private Range n;
    private Image p;
    private CaptureRequest.Builder q;
    private int t;
    private SurfaceTexture u;
    private float i = -1.0f;
    private float j = -1.0f;
    private boolean m = false;
    private ImageReader o = null;
    private CameraCaptureSession r = null;
    private Object s = new Object();
    private Surface v = null;
    private int A = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.FreeformWindowSize_phone;
    private CameraCaptureSession.CaptureCallback w = new C0024m(this);
    private final CameraDevice.StateCallback x = new C0028o(this);
    private final ImageReader.OnImageAvailableListener y = new C0030p(this);
    private final SurfaceTexture.OnFrameAvailableListener z = new C0032q(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public C0034r(com.unity3d.player.a.b bVar) {
        this.a = null;
        this.a = bVar;
        e();
    }

    public static int a(Context context) {
        return b(context).length;
    }

    public static int a(Context context, int i) {
        try {
            CameraCharacteristics cameraCharacteristics = c(context).getCameraCharacteristics(b(context)[i]);
            float[] fArr = (float[]) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
            SizeF sizeF = (SizeF) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE);
            if (fArr.length > 0) {
                return (int) ((fArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] * 36.0f) / sizeF.getWidth());
            }
        } catch (CameraAccessException e) {
            AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Camera2: CameraAccessException " + e);
        }
        return com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CameraDevice cameraDevice) {
        synchronized (this.s) {
            this.r = null;
        }
        cameraDevice.close();
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj) {
        if (obj != "Focus") {
            if (obj == "Cancel focus") {
                synchronized (this.s) {
                    if (this.r != null) {
                        g();
                    }
                }
                return;
            }
            return;
        }
        this.m = false;
        synchronized (this.s) {
            if (this.r != null) {
                try {
                    this.q.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf((int) com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme));
                    this.q.setTag("Regular");
                    this.r.setRepeatingRequest(this.q.build(), this.w, this.d);
                } catch (CameraAccessException e) {
                    AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Camera2: CameraAccessException " + e);
                }
            }
        }
    }

    private void b() {
        try {
            Semaphore semaphore = D;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (!semaphore.tryAcquire(4L, timeUnit)) {
                AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.app_name, "Camera2: Timeout waiting to lock camera for closing.");
                return;
            }
            this.b.close();
            try {
                if (!D.tryAcquire(4L, timeUnit)) {
                    AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.app_name, "Camera2: Timeout waiting to close camera.");
                }
            } catch (InterruptedException e) {
                AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Camera2: Interrupted while waiting to close camera " + e);
            }
            this.b = null;
            D.release();
        } catch (InterruptedException e2) {
            AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Camera2: Interrupted while trying to lock camera for closing " + e2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
        if (r3.length != 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int[] b(android.content.Context r3, int r4) {
        /*
            r0 = 6
            r1 = 0
            android.hardware.camera2.CameraManager r2 = c(r3)     // Catch: android.hardware.camera2.CameraAccessException -> L51
            java.lang.String[] r3 = b(r3)     // Catch: android.hardware.camera2.CameraAccessException -> L51
            r3 = r3[r4]     // Catch: android.hardware.camera2.CameraAccessException -> L51
            android.hardware.camera2.CameraCharacteristics r3 = r2.getCameraCharacteristics(r3)     // Catch: android.hardware.camera2.CameraAccessException -> L51
            android.hardware.camera2.CameraCharacteristics$Key r4 = android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP
            java.lang.Object r3 = r3.get(r4)
            android.hardware.camera2.params.StreamConfigurationMap r3 = (android.hardware.camera2.params.StreamConfigurationMap) r3
            if (r3 != 0) goto L21
            java.lang.String r3 = "Camera2: configuration map is not available."
            com.unity3d.player.AbstractC0040u.Log(r0, r3)
        L1f:
            r3 = r1
            goto L2d
        L21:
            r4 = 35
            android.util.Size[] r3 = r3.getOutputSizes(r4)
            if (r3 == 0) goto L1f
            int r4 = r3.length
            if (r4 != 0) goto L2d
            goto L1f
        L2d:
            if (r3 == 0) goto L50
            int r4 = r3.length
            int r4 = r4 * 2
            int[] r4 = new int[r4]
            r0 = 0
        L35:
            int r1 = r3.length
            if (r0 >= r1) goto L4f
            int r1 = r0 * 2
            r2 = r3[r0]
            int r2 = r2.getWidth()
            r4[r1] = r2
            int r1 = r1 + 1
            r2 = r3[r0]
            int r2 = r2.getHeight()
            r4[r1] = r2
            int r0 = r0 + 1
            goto L35
        L4f:
            return r4
        L50:
            return r1
        L51:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r2 = "Camera2: CameraAccessException "
            r4.<init>(r2)
            java.lang.StringBuilder r3 = r4.append(r3)
            java.lang.String r3 = r3.toString()
            com.unity3d.player.AbstractC0040u.Log(r0, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.C0034r.b(android.content.Context, int):int[]");
    }

    private static String[] b(Context context) {
        if (C == null) {
            try {
                C = c(context).getCameraIdList();
            } catch (CameraAccessException e) {
                AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Camera2: CameraAccessException " + e);
                C = new String[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme];
            }
        }
        return C;
    }

    public static int c(Context context, int i) {
        try {
            return ((Integer) c(context).getCameraCharacteristics(b(context)[i]).get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        } catch (CameraAccessException e) {
            AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Camera2: CameraAccessException " + e);
            return com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
        }
    }

    private static CameraManager c(Context context) {
        if (B == null) {
            B = (CameraManager) context.getSystemService("camera");
        }
        return B;
    }

    public static boolean d(Context context, int i) {
        try {
            return ((Integer) c(context).getCameraCharacteristics(b(context)[i]).get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() > 0;
        } catch (CameraAccessException e) {
            AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Camera2: CameraAccessException " + e);
            return false;
        }
    }

    private void e() {
        HandlerThread handlerThread = new HandlerThread("CameraBackground");
        this.c = handlerThread;
        handlerThread.start();
        this.d = new Handler(this.c.getLooper());
    }

    public static boolean e(Context context, int i) {
        try {
            return ((Integer) c(context).getCameraCharacteristics(b(context)[i]).get(CameraCharacteristics.LENS_FACING)).intValue() == 0;
        } catch (CameraAccessException e) {
            AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Camera2: CameraAccessException " + e);
            return false;
        }
    }

    private void f() {
        try {
            CameraCaptureSession cameraCaptureSession = this.r;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.stopRepeating();
                this.q.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                this.q.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf((int) com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme));
                this.q.setTag("Cancel focus");
                this.r.capture(this.q.build(), this.w, this.d);
            }
        } catch (CameraAccessException e) {
            AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Camera2: CameraAccessException " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            if (this.h != 0) {
                float f = this.i;
                if (f >= 0.0f && f <= 1.0f) {
                    float f2 = this.j;
                    if (f2 >= 0.0f && f2 <= 1.0f) {
                        this.m = true;
                        int width = this.f.width();
                        int i = this.k;
                        int height = this.f.height();
                        int i2 = this.l;
                        int max = Math.max(this.g + com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector, Math.min((int) (((width - (i * 2)) * this.i) + i), (this.f.width() - this.g) - com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector));
                        int max2 = Math.max(this.g + com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector, Math.min((int) (((1.0d - this.j) * (height - (i2 * 2))) + i2), (this.f.height() - this.g) - com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector));
                        CaptureRequest.Builder builder = this.q;
                        CaptureRequest.Key key = CaptureRequest.CONTROL_AF_REGIONS;
                        MeteringRectangle[] meteringRectangleArr = new MeteringRectangle[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector];
                        int i3 = this.g;
                        int i4 = i3 * 2;
                        meteringRectangleArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = new MeteringRectangle(max - i3, max2 - i3, i4, i4, 999);
                        builder.set(key, meteringRectangleArr);
                        this.q.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf((int) com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector));
                        this.q.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf((int) com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector));
                        this.q.setTag("Focus");
                        this.r.capture(this.q.build(), this.w, this.d);
                    }
                }
            }
            this.q.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf((int) com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.FreeformWindowSize_tablet));
            this.q.setTag("Regular");
            CameraCaptureSession cameraCaptureSession = this.r;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.setRepeatingRequest(this.q.build(), this.w, this.d);
            }
        } catch (CameraAccessException e) {
            AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Camera2: CameraAccessException " + e);
        }
    }

    public final void a() {
        if (this.b != null) {
            i();
            b();
            this.w = null;
            this.v = null;
            this.u = null;
            Image image = this.p;
            if (image != null) {
                image.close();
                this.p = null;
            }
            ImageReader imageReader = this.o;
            if (imageReader != null) {
                imageReader.close();
                this.o = null;
            }
        }
        this.c.quit();
        try {
            this.c.join(4000L);
            this.c = null;
            this.d = null;
        } catch (InterruptedException e) {
            this.c.interrupt();
            AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Camera2: Interrupted while waiting for the background thread to finish " + e);
        }
    }

    public final boolean a(float f, float f2) {
        if (this.h > 0) {
            if (this.m) {
                AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.app_name, "Camera2: Setting manual focus point already started.");
                return false;
            }
            this.i = f;
            this.j = f2;
            synchronized (this.s) {
                if (this.r != null && this.A != 2) {
                    f();
                }
            }
            return true;
        }
        return false;
    }

    public final boolean a(Context context, int i, int i2, int i3, int i4, int i5, Surface surface) {
        Rect rect;
        int i6 = i4;
        try {
            CameraCharacteristics cameraCharacteristics = B.getCameraCharacteristics(b(context)[i]);
            if (((Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue() == 2) {
                AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.app_name, "Camera2: only LEGACY hardware level is supported.");
            }
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            Size[] sizeArr = null;
            if (streamConfigurationMap == null) {
                AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Camera2: configuration map is not available.");
            } else {
                Size[] outputSizes = streamConfigurationMap.getOutputSizes(35);
                if (outputSizes != null && outputSizes.length != 0) {
                    sizeArr = outputSizes;
                }
            }
            if (sizeArr == null || sizeArr.length == 0) {
                return false;
            }
            double d = i2;
            double d2 = i3;
            int i7 = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
            int i8 = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
            int i9 = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
            double d3 = Double.MAX_VALUE;
            while (i7 < sizeArr.length) {
                int width = sizeArr[i7].getWidth();
                int height = sizeArr[i7].getHeight();
                CameraCharacteristics cameraCharacteristics2 = cameraCharacteristics;
                double d4 = d;
                double abs = Math.abs(Math.log(d2 / height)) + Math.abs(Math.log(d / width));
                if (abs < d3) {
                    i8 = height;
                    d3 = abs;
                    i9 = width;
                }
                i7 += com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector;
                cameraCharacteristics = cameraCharacteristics2;
                d = d4;
            }
            CameraCharacteristics cameraCharacteristics3 = cameraCharacteristics;
            this.e = new Rect(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme, com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme, i9, i8);
            Range[] rangeArr = (Range[]) cameraCharacteristics3.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
            if (rangeArr == null || rangeArr.length == 0) {
                AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Camera2: target FPS ranges are not avialable.");
                return false;
            }
            int i10 = -1;
            int i11 = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
            double d5 = Double.MAX_VALUE;
            while (true) {
                if (i11 < rangeArr.length) {
                    int intValue = ((Integer) rangeArr[i11].getLower()).intValue();
                    int intValue2 = ((Integer) rangeArr[i11].getUpper()).intValue();
                    float f = i6;
                    if (f + 0.1f > intValue && f - 0.1f < intValue2) {
                        break;
                    }
                    if (r8 < d5) {
                        i10 = i11;
                        d5 = r8;
                    }
                    i11 += com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector;
                } else {
                    i6 = ((Integer) (i6 > ((Integer) rangeArr[i10].getUpper()).intValue() ? rangeArr[i10].getUpper() : rangeArr[i10].getLower())).intValue();
                }
            }
            this.n = new Range(Integer.valueOf(i6), Integer.valueOf(i6));
            try {
                Semaphore semaphore = D;
                TimeUnit timeUnit = TimeUnit.SECONDS;
                if (!semaphore.tryAcquire(4L, timeUnit)) {
                    AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.app_name, "Camera2: Timeout waiting to lock camera for opening.");
                    return false;
                }
                try {
                    B.openCamera(b(context)[i], this.x, this.d);
                    try {
                    } catch (InterruptedException e) {
                        AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Camera2: Interrupted while waiting to open camera " + e);
                    }
                    if (!D.tryAcquire(4L, timeUnit)) {
                        AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.app_name, "Camera2: Timeout waiting to open camera.");
                        return false;
                    }
                    D.release();
                    this.t = i5;
                    this.v = surface;
                    int intValue3 = ((Integer) cameraCharacteristics3.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue();
                    this.h = intValue3;
                    if (intValue3 > 0) {
                        this.f = (Rect) cameraCharacteristics3.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
                        float width2 = this.e.width() / this.e.height();
                        if (width2 > rect.width() / this.f.height()) {
                            this.k = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
                            this.l = (int) ((this.f.height() - (this.f.width() / width2)) / 2.0f);
                        } else {
                            this.l = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme;
                            this.k = (int) ((this.f.width() - (this.f.height() * width2)) / 2.0f);
                        }
                        this.g = Math.min(this.f.width(), this.f.height()) / 20;
                    }
                    return this.b != null;
                } catch (CameraAccessException e2) {
                    AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Camera2: CameraAccessException " + e2);
                    D.release();
                    return false;
                }
            } catch (InterruptedException e3) {
                AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Camera2: Interrupted while trying to lock camera for opening " + e3);
                return false;
            }
        } catch (CameraAccessException e4) {
            AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Camera2: CameraAccessException " + e4);
            return false;
        }
    }

    public final Rect c() {
        return this.e;
    }

    public final void d() {
        synchronized (this.s) {
            CameraCaptureSession cameraCaptureSession = this.r;
            if (cameraCaptureSession != null) {
                try {
                    cameraCaptureSession.stopRepeating();
                    this.A = 2;
                } catch (CameraAccessException e) {
                    AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Camera2: CameraAccessException " + e);
                }
            }
        }
    }

    public void h() {
        Surface surface;
        if (this.t != 0) {
            if (this.v == null) {
                SurfaceTexture surfaceTexture = new SurfaceTexture(this.t);
                this.u = surfaceTexture;
                surfaceTexture.setDefaultBufferSize(this.e.width(), this.e.height());
                this.u.setOnFrameAvailableListener(this.z, this.d);
                surface = new Surface(this.u);
                this.v = surface;
            }
        } else if (this.v == null && this.o == null) {
            ImageReader newInstance = ImageReader.newInstance(this.e.width(), this.e.height(), 35, 2);
            this.o = newInstance;
            newInstance.setOnImageAvailableListener(this.y, this.d);
            this.p = null;
            surface = this.o.getSurface();
            this.v = surface;
        }
        try {
            CameraCaptureSession cameraCaptureSession = this.r;
            if (cameraCaptureSession == null) {
                CameraDevice cameraDevice = this.b;
                Surface[] surfaceArr = new Surface[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector];
                surfaceArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = this.v;
                cameraDevice.createCaptureSession(Arrays.asList(surfaceArr), new C0026n(this), this.d);
            } else if (this.A == 2) {
                cameraCaptureSession.setRepeatingRequest(this.q.build(), this.w, this.d);
            }
            this.A = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector;
        } catch (CameraAccessException e) {
            AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Camera2: CameraAccessException " + e);
        }
    }

    public final void i() {
        synchronized (this.s) {
            CameraCaptureSession cameraCaptureSession = this.r;
            if (cameraCaptureSession != null) {
                try {
                    cameraCaptureSession.abortCaptures();
                } catch (CameraAccessException e) {
                    AbstractC0040u.Log(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description, "Camera2: CameraAccessException " + e);
                }
                this.r.close();
                this.r = null;
                this.A = com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.FreeformWindowSize_phone;
            }
        }
    }
}
