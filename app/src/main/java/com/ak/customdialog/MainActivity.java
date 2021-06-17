package com.ak.customdialog;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.droidhubworld.dialoglib.listener.CommonDialogListener;
import com.droidhubworld.dialoglib.messagedialog.CommonMessageDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CommonMessageDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_showCustomDialog).setOnClickListener(this);
        findViewById(R.id.btn_showDefaultDialog).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_showCustomDialog:
                dialog = new CommonMessageDialog.Builder(this)
                        .title("Custom Dialog")
                        .titleGravity(Gravity.CENTER)
                        .titleSize(22)
                        .cornerRadius(5.0f)
                        .titleColor(R.color.black)
                        .messageColor(R.color.black)
                        .message("This is Custom Message Dialog")
                        .messageGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL)
                        .messageSize(18)
                        .buttonTextSize(16)
                        .buttonTypeface(Typeface.NORMAL)
                        .titleTypeface(Typeface.BOLD)
                        .messageTypeface(Typeface.NORMAL)
                        .showNegativeButton(true)
                        .negativeButtonText("No")
                        .positiveButtonText("YES")
                        .iconTitleMaxHeight(32)
                        .iconTitleMaxWidth(32)
                        .iconTitleMinHeight(18)
                        .iconTitleMinWidth(18)
                        .iconTitleThinColor(R.color.red)
                        .titleIcon(getResources().getDrawable(R.drawable.ic_alert_title))
                        .titleBackgroundDrawable(getResources().getDrawable(R.drawable.title_gradient_bg))
                        .backgroundColor(R.color.red)
                        .positiveButtonDrawable(getResources().getDrawable(R.drawable.default_button_selector))
                        .negativeButtonDrawable(getResources().getDrawable(R.drawable.default_button_selector))
                        .positiveButtonTextColor(R.color.red)
                        .negativeButtonTextColor(R.color.red)
                        .show3rdButton(true)
                        .m3rdButtonText("Cancel")
                        .m3rdButtonTextColor(R.color.red)
                        .cancelable(true)
                        .dialogWindowWidth(0.9f)
                        //.dialogWindowHeight(0.3f)
                        .style(R.style.dialogStyle)
                        .buttonDividerColor(R.color.divider)
                        .buttonDividerWeight(1)
                        .showButtonDivider(true)
                        .callBack(new CommonDialogListener() {
                            @Override
                            public void onDialogButtonClick(Boolean isPositive, Object viewTag) {
                                Log.e("CLICK ON : ", viewTag.toString());
                            }
                        }).build();
                dialog.show("Dialog");
                break;
            case R.id.btn_showDefaultDialog:
                dialog = new CommonMessageDialog.Builder(this)
                        .title("Default Custom Dialog")
                        .message("This Is Default Custom Message")
                        .callBack(new CommonDialogListener() {
                            @Override
                            public void onDialogButtonClick(Boolean isPositive, Object viewTag) {
                                Log.e("CLICK ON : ", viewTag.toString());
                            }
                        }).build();
                dialog.show("Dialog");
                break;
        }
    }
}
