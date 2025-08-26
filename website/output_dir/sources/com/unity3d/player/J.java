package com.unity3d.player;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: base/dex/classes.dex */
public abstract class J implements TextWatcher {
    protected Context a;
    protected UnityPlayer b;
    protected EditText c = createEditText(this);
    protected boolean d;
    protected boolean e;
    protected InterfaceC0045x f;
    protected InterfaceC0046y g;

    public J(Context context, UnityPlayer unityPlayer) {
        this.a = context;
        this.b = unityPlayer;
    }

    public final String a() {
        InputMethodSubtype currentInputMethodSubtype = ((InputMethodManager) this.a.getSystemService("input_method")).getCurrentInputMethodSubtype();
        if (currentInputMethodSubtype == null) {
            return null;
        }
        String a = AbstractC0038t.a(currentInputMethodSubtype);
        if (a == null || a.equals("")) {
            String mode = currentInputMethodSubtype.getMode();
            return mode + " " + currentInputMethodSubtype.getExtraValue();
        }
        return a;
    }

    public void a(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2, boolean z5, boolean z6) {
        this.e = z6;
        setupTextInput(str, i, z, z2, z3, z4, str2, i2);
        a(z5);
    }

    public final void a(String str, boolean z) {
        this.c.setSelection(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme, com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme);
        this.b.reportSoftInputStr(str, com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector, z);
    }

    public abstract void a(boolean z);

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.b.reportSoftInputStr(editable.toString(), com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme, false);
        int selectionStart = this.c.getSelectionStart();
        this.b.reportSoftInputSelection(selectionStart, this.c.getSelectionEnd() - selectionStart);
    }

    public final String b() {
        EditText editText = this.c;
        if (editText == null) {
            return null;
        }
        return editText.getText().toString();
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public abstract void c();

    protected abstract EditText createEditText(J j);

    public boolean d() {
        return this.e;
    }

    public abstract void e();

    public final void f() {
        ((InputMethodManager) this.a.getSystemService("input_method")).showSoftInput(this.c, com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void invokeOnClose() {
        InterfaceC0046y interfaceC0046y = this.g;
        if (interfaceC0046y != null) {
            ((C0011f0) interfaceC0046y).a();
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    protected void setupTextInput(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2) {
        this.c.setOnEditorActionListener(new I(this));
        this.c.setBackgroundColor(-1);
        this.c.setImeOptions(com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.game_view_content_description);
        this.c.setText(str);
        this.c.setHint(str2);
        this.c.setHintTextColor(1627389952);
        EditText editText = this.c;
        int i3 = (z ? 32768 : 524288) | (z2 ? 131072 : com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme) | (z3 ? 128 : com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme);
        if (i >= 0 && i <= 11) {
            int i4 = new int[]{com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector, 16385, 12290, 17, 2, com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.string.FreeformWindowSize_phone, 8289, 33, com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector, 16417, 17, 8194}[i];
            if ((i4 & 2) != 0) {
                i3 = (z3 ? 16 : com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme) | i4;
            } else {
                i3 |= i4;
            }
        }
        editText.setInputType(i3);
        this.c.setImeOptions(33554432);
        if (i2 > 0) {
            EditText editText2 = this.c;
            InputFilter[] inputFilterArr = new InputFilter[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.UnityThemeSelector];
            inputFilterArr[com.spooky.hide.n.seek.game.puzzle.free.sfzsw.R.style.BaseUnityTheme] = new InputFilter.LengthFilter(i2);
            editText2.setFilters(inputFilterArr);
        }
        this.c.addTextChangedListener(this);
        EditText editText3 = this.c;
        editText3.setSelection(editText3.getText().length());
        this.c.setClickable(true);
    }
}
