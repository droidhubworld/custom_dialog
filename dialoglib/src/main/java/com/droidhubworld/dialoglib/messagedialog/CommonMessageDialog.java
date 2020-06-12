package com.droidhubworld.dialoglib.messagedialog;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spanned;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

import com.droidhubworld.dialoglib.R;
import com.droidhubworld.dialoglib.listener.CommonDialogListener;


public class CommonMessageDialog extends DialogFragment implements View.OnClickListener {
    private FrameLayout titleHeader;
    private LinearLayout layoutTitle;
    private boolean hideTitle;
    private ImageView titleIcon;
    private TextView tvTitle, tvMessage;
    private Button btnPositive, btnNegative;
    private View horizontalDivider, verticalDivider;
    private CardView rootLayout;
    private Context mContext;
    private int mBackgroundColor = -1;
    private boolean mCancelable = true;
    private CommonDialogListener callBack = null;
    private int mStyle = -1;
    private String mTitle;
    private int mTitleColor = -1;
    private int mMessageColor = -1;
    private String mMessage;
    private int mTitleGravity = -1;
    private float mTitleSize = -1;
    private int mMessageGravity = -1;
    private float mMessageSize = -1;
    private boolean mShowButtonDivider = true;
    private int mButtonDividerWeight = -1;
    private int mButtonDividerColor = -1;
    private float mDialogWindowWidth = 0;
    private float mDialogWindowHeight = 0;
    private Drawable mPositiveButtonDrawable = null;
    private Drawable mNegativeButtonDrawable = null;

    private String mPositiveButtonText = null;
    private String mNegativeButtonText = null;
    private boolean mShowNegativeButton = true;
    private Drawable mTitleBackgroundDrawable = null;
    private Drawable mTitleIcon = null;
    private int mIconMaxHeight = -1;
    private int mIconMaxWidth = -1;
    private int mIconMinHeight = -1;
    private int mIconMinWidth = -1;
    private int mIconThinColor = -1;
    private float mCornerRadius = 0;
    private int mMessageTypeface = 0;
    private int mTitleTypeface = 0;
    private int mButtonTypeface = 0;
    private float mButtonTextSize = 0;


    private CommonMessageDialog(Context mContext,
                                int mBackgroundColor,
                                boolean mCancelable,
                                CommonDialogListener callBack,
                                int mStyle,
                                String mTitle,
                                boolean hideTitle,
                                String mMessage,
                                int mTitleColor,
                                int mMessageColor,
                                int mTitleGravity,
                                float mTitleSize,
                                int mMessageGravity,
                                float mMessageSize,
                                boolean mShowButtonDivider,
                                int mButtonDividerWeight,
                                int mButtonDividerColor,
                                float mDialogWindowWidth,
                                float mDialogWindowHeight,
                                Drawable mPositiveButtonDrawable,
                                Drawable mNegativeButtonDrawable,
                                String mPositiveButtonText,
                                String mNegativeButtonText,
                                boolean mShowNegativeButton,
                                Drawable mTitleBackgroundDrawable,
                                Drawable mTitleIcon,
                                int mIconMaxHeight,
                                int mIconMaxWidth,
                                int mIconMinHeight,
                                int mIconMinWidth,
                                int mIconThinColor,
                                float mCornerRadius,
                                int mMessageTypeface,
                                int mTitleTypeface,
                                int mButtonTypeface,
                                float mButtonTextSize) {
        this.mContext = mContext;
        this.mBackgroundColor = mBackgroundColor;
        this.mCancelable = mCancelable;
        this.callBack = callBack;
        this.mStyle = mStyle;
        this.mTitle = mTitle;
        this.hideTitle = hideTitle;
        this.mMessage = mMessage;
        this.mTitleColor = mTitleColor;
        this.mMessageColor = mMessageColor;
        this.mTitleGravity = mTitleGravity;
        this.mTitleSize = mTitleSize;
        this.mMessageGravity = mMessageGravity;
        this.mMessageSize = mMessageSize;
        this.mShowButtonDivider = mShowButtonDivider;
        this.mButtonDividerWeight = mButtonDividerWeight;
        this.mButtonDividerColor = mButtonDividerColor;
        this.mDialogWindowWidth = mDialogWindowWidth;
        this.mDialogWindowHeight = mDialogWindowHeight;
        this.mPositiveButtonDrawable = mPositiveButtonDrawable;
        this.mNegativeButtonDrawable = mNegativeButtonDrawable;
        this.mPositiveButtonText = mPositiveButtonText;
        this.mNegativeButtonText = mNegativeButtonText;
        this.mShowNegativeButton = mShowNegativeButton;
        this.mTitleBackgroundDrawable = mTitleBackgroundDrawable;
        this.mTitleIcon = mTitleIcon;
        this.mIconMaxHeight = mIconMaxHeight;
        this.mIconMaxWidth = mIconMaxWidth;
        this.mIconMinHeight = mIconMinHeight;
        this.mIconMinWidth = mIconMinWidth;
        this.mIconThinColor = mIconThinColor;
        this.mCornerRadius = mCornerRadius;
        this.mMessageTypeface = mMessageTypeface;
        this.mTitleTypeface = mTitleTypeface;
        this.mButtonTypeface = mButtonTypeface;
        this.mButtonTextSize = mButtonTextSize;
    }


    public static class Builder {
        private Context mContext;
        private int mBackgroundColor = -1;
        private boolean mCancelable = true;
        private CommonDialogListener callBack = null;
        private int mStyle = -1;
        private String mTitle;
        private String mMessage;
        private boolean hideTitle;
        private int mTitleColor = -1;
        private int mTitleGravity = -1;
        private float mTitleSize = -1;
        private int mMessageColor = -1;
        private int mMessageGravity = -1;
        private float mMessageSize = -1;
        private boolean mShowButtonDivider = true;
        private int mButtonDividerWeight = -1;
        private int mButtonDividerColor = -1;
        private float mDialogWindowWidth = 0;
        private float mDialogWindowHeight = 0;
        private Drawable mPositiveButtonDrawable = null;
        private Drawable mNegativeButtonDrawable = null;
        private String mPositiveButtonText = null;
        private String mNegativeButtonText = null;
        private boolean mShowNegativeButton = true;
        private Drawable mTitleBackgroundDrawable = null;
        private Drawable mTitleIcon = null;
        private int mIconMaxHeight = -1;
        private int mIconMaxWidth = -1;
        private int mIconMinHeight = -1;
        private int mIconMinWidth = -1;
        private int mIconThinColor = -1;
        private float mCornerRadius = 0;
        private int mMessageTypeface = 0;
        private int mTitleTypeface = 0;
        private int mButtonTypeface = 0;
        private float mButtonTextSize = 0;

        public Builder(Context mContext) {
            this.mContext = mContext;
        }

        public Builder buttonTypeface(int buttonTypeface) {
            this.mButtonTypeface = buttonTypeface;
            return this;
        }

        public Builder buttonTextSize(float buttonTextSize) {
            this.mButtonTextSize = buttonTextSize;
            return this;
        }

        public Builder titleTypeface(int titleTypeface) {
            this.mTitleTypeface = titleTypeface;
            return this;
        }

        public Builder messageTypeface(int messageTypeface) {
            this.mMessageTypeface = messageTypeface;
            return this;
        }

        public Builder cornerRadius(float cornerRadius) {
            this.mCornerRadius = cornerRadius;
            return this;
        }

        public Builder iconThinColor(int iconThinColor) {
            this.mIconThinColor = iconThinColor;
            return this;
        }

        public Builder iconMinWidth(int iconMinWidth) {
            this.mIconMinWidth = iconMinWidth;
            return this;
        }

        public Builder iconMinHeight(int iconMinHeight) {
            this.mIconMinHeight = iconMinHeight;
            return this;
        }

        public Builder iconMaxHeight(int iconMaxHeight) {
            this.mIconMaxHeight = iconMaxHeight;
            return this;
        }

        public Builder iconMaxWidth(int iconMaxWidth) {
            this.mIconMaxWidth = iconMaxWidth;
            return this;
        }

        public Builder titleBackgroundDrawable(Drawable titleBackgroundDrawable) {
            this.mTitleBackgroundDrawable = titleBackgroundDrawable;
            return this;
        }

        public Builder titleIcon(Drawable titleIcon) {
            this.mTitleIcon = titleIcon;
            return this;
        }

        public Builder positiveButtonText(String positiveButtonText) {
            this.mPositiveButtonText = positiveButtonText;
            return this;
        }

        public Builder negativeButtonText(String negativeButtonText) {
            this.mNegativeButtonText = negativeButtonText;
            return this;
        }

        public Builder showNegativeButton(boolean showNegativeButton) {
            this.mShowNegativeButton = showNegativeButton;
            return this;
        }

        public Builder showButtonDivider(boolean showButtonDivider) {
            this.mShowButtonDivider = showButtonDivider;
            return this;
        }

        public Builder positiveButtonDrawable(Drawable positiveButtonDrawable) {
            this.mPositiveButtonDrawable = positiveButtonDrawable;
            return this;
        }

        public Builder negativeButtonDrawable(Drawable negativeButtonDrawable) {
            this.mNegativeButtonDrawable = negativeButtonDrawable;
            return this;
        }

        public Builder dialogWindowWidth(float dialogWindowWidth) {
            this.mDialogWindowWidth = dialogWindowWidth;
            return this;
        }

        public Builder dialogWindowHeight(float dialogWindowHeight) {
            this.mDialogWindowHeight = dialogWindowHeight;
            return this;
        }

        public Builder buttonDividerWeight(int buttonDividerWeight) {
            this.mButtonDividerWeight = buttonDividerWeight;
            return this;
        }

        public Builder buttonDividerColor(int buttonDividerColor) {
            this.mButtonDividerColor = buttonDividerColor;
            return this;
        }


        public Builder backgroundColor(int backgroundColor) {
            this.mBackgroundColor = backgroundColor;
            return this;
        }

        public Builder cancelable(boolean mCancelable) {
            this.mCancelable = mCancelable;
            return this;
        }

        public Builder style(int mStyle) {
            this.mStyle = mStyle;
            return this;
        }


        public Builder title(String title) {
            this.mTitle = title;
            return this;
        }

        public CommonMessageDialog.Builder hideTitle(boolean hideTitle) {
            this.hideTitle = hideTitle;
            return this;
        }

        public Builder titleGravity(int titleGravity) {
            this.mTitleGravity = titleGravity;
            return this;
        }

        public Builder titleColor(int titleColor) {
            this.mTitleColor = titleColor;
            return this;
        }

        public Builder messageColor(int messageColor) {
            this.mMessageColor = messageColor;
            return this;
        }

        public Builder titleSize(float titleSize) {
            this.mTitleSize = titleSize;
            return this;
        }

        public Builder message(String message) {
            this.mMessage = message;
            return this;
        }

        public Builder messageGravity(int messageGravity) {
            this.mMessageGravity = messageGravity;
            return this;
        }

        public Builder messageSize(float messageSize) {
            this.mMessageSize = messageSize;
            return this;
        }

        public Builder callBack(CommonDialogListener callBack) {
            this.callBack = callBack;
            return this;
        }

        public CommonMessageDialog build() {
            return new CommonMessageDialog(this.mContext, this.mBackgroundColor, this.mCancelable, this.callBack, mStyle,
                    this.mTitle, this.hideTitle, this.mMessage, this.mTitleColor, this.mMessageColor, this.mTitleGravity, this.mTitleSize, this.mMessageGravity, this.mMessageSize,
                    this.mShowButtonDivider, this.mButtonDividerWeight, this.mButtonDividerColor, this.mDialogWindowWidth, this.mDialogWindowHeight,
                    this.mPositiveButtonDrawable, this.mNegativeButtonDrawable, this.mPositiveButtonText, this.mNegativeButtonText, this.mShowNegativeButton,
                    this.mTitleBackgroundDrawable, this.mTitleIcon, this.mIconMaxHeight, this.mIconMaxWidth, this.mIconMinHeight, this.mIconMinWidth, this.mIconThinColor, this.mCornerRadius,
                    this.mMessageTypeface, this.mTitleTypeface, this.mButtonTypeface, this.mButtonTextSize);
        }
    }

    public void show(String TAG) {
        show(((AppCompatActivity) mContext).getSupportFragmentManager(), TAG);
    }

    public void hide() {
        this.dismiss();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setCancelable(mCancelable);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.common_message_dialog, container, false);
        // request a window without the title
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        titleHeader = view.findViewById(R.id.layout_titleHeader);
        layoutTitle = view.findViewById(R.id.layout_title);
        titleIcon = view.findViewById(R.id.icon_titleIcon);
        rootLayout = view.findViewById(R.id.layout_rootLayout);
        tvMessage = view.findViewById(R.id.tv_message);
        tvTitle = view.findViewById(R.id.tv_title);
        horizontalDivider = view.findViewById(R.id.view_horizontalDivider);
        verticalDivider = view.findViewById(R.id.view_verticalDivider);
        tvTitle.setText(mTitle);
        tvMessage.setText(mMessage);
        btnPositive = view.findViewById(R.id.btn_positive);
        btnNegative = view.findViewById(R.id.btn_negative);
        btnPositive.setOnClickListener(this);
        btnNegative.setOnClickListener(this);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mStyle > -1)
            getDialog().getWindow().getAttributes().windowAnimations = mStyle;
        if (mCornerRadius > -1) {
            rootLayout.setRadius(mCornerRadius);
        }
        if (mTitleIcon != null) {
            titleIcon.setImageDrawable(mTitleIcon);
        }
        if (mIconThinColor > -1) {
            titleIcon.setColorFilter(ContextCompat.getColor(mContext, mIconThinColor), android.graphics.PorterDuff.Mode.SRC_IN);
        }
        if (mIconMaxHeight > -1) {
            titleIcon.setMaxHeight(mIconMaxHeight);
        }
        if (mIconMinHeight > -1) {
            titleIcon.setMinimumHeight(mIconMinHeight);
        }
        if (mIconMinWidth > -1) {
            titleIcon.setMinimumWidth(mIconMinWidth);
        }
        if (mIconMaxWidth > -1) {
            titleIcon.setMaxWidth(mIconMaxWidth);
        }
        if (mBackgroundColor > -1) {
            rootLayout.setCardBackgroundColor(mContext.getResources().getColor(mBackgroundColor));
        }
        if (mTitleBackgroundDrawable != null) {
            titleHeader.setBackground(mTitleBackgroundDrawable);
        }

        if (!mShowNegativeButton) {
            verticalDivider.setVisibility(View.GONE);
            btnNegative.setVisibility(View.GONE);
        }

        if (mNegativeButtonText != null) {
            btnNegative.setText(mNegativeButtonText);
        }

        if (mPositiveButtonText != null) {
            btnPositive.setText(mPositiveButtonText);
        }

        if (!mShowButtonDivider) {
            horizontalDivider.setVisibility(View.GONE);
            verticalDivider.setVisibility(View.GONE);
        }

        if (mButtonDividerColor > -1) {
            horizontalDivider.setBackgroundResource(mButtonDividerColor);
            verticalDivider.setBackgroundResource(mButtonDividerColor);
        }

        if (mButtonDividerWeight > -1) {
            LinearLayout.LayoutParams paramHorizontal = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    mButtonDividerWeight
            );
            horizontalDivider.setLayoutParams(paramHorizontal);
            LinearLayout.LayoutParams paramVertical = new LinearLayout.LayoutParams(
                    mButtonDividerWeight,
                    ViewGroup.LayoutParams.MATCH_PARENT
            );
            verticalDivider.setLayoutParams(paramVertical);
        }

        if (mTitleColor > -1) {
            tvTitle.setTextColor(mContext.getResources().getColor(mTitleColor));
        }

        tvTitle.setVisibility((!hideTitle) ? View.VISIBLE : View.GONE);

        if (mTitleGravity > -1) {
            FrameLayout.LayoutParams paramsTitleHeader = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.MATCH_PARENT);
            paramsTitleHeader.gravity = mTitleGravity;
            layoutTitle.setLayoutParams(paramsTitleHeader);
        }

        if (mTitleSize > -1) {
            tvTitle.setTextSize(mTitleSize);
        }

        if (mMessageColor > -1) {
            tvMessage.setTextColor(mContext.getResources().getColor(mMessageColor));
        }

        if (mMessageGravity > -1) {
            tvMessage.setGravity(mMessageGravity);
        }

        if (mMessageSize > -1) {
            tvMessage.setTextSize(mMessageSize);
        }
        if (mMessageTypeface > -1) {
            tvMessage.setTypeface(tvMessage.getTypeface(), mMessageTypeface);
        }
        if (mTitleTypeface > -1) {
            tvTitle.setTypeface(tvTitle.getTypeface(), mTitleTypeface);
        }
        if (mButtonTypeface > -1) {
            btnPositive.setTypeface(btnPositive.getTypeface(), mButtonTypeface);
            btnNegative.setTypeface(btnNegative.getTypeface(), mButtonTypeface);
        }
        if (mButtonTextSize > 0) {
            btnPositive.setTextSize(mButtonTextSize);
            btnNegative.setTextSize(mButtonTextSize);
        }
        if (mPositiveButtonDrawable != null) {
            btnPositive.setBackground(mPositiveButtonDrawable);
        }

        if (mNegativeButtonDrawable != null) {
            btnNegative.setBackground(mNegativeButtonDrawable);
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        // The absolute width of the available display size in pixels.
        int displayWidth = displayMetrics.widthPixels;
        // The absolute height of the available display size in pixels.
        int displayHeight = displayMetrics.heightPixels;

        // Initialize a new window manager layout parameters
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();

        // Copy the alert dialog window attributes to new layout parameter instance
        layoutParams.copyFrom(getDialog().getWindow().getAttributes());

        if (mDialogWindowWidth != 0) {
            layoutParams.width = (int) (displayWidth * mDialogWindowWidth);
        }
        if (mDialogWindowHeight != 0) {
            layoutParams.height = (int) (displayHeight * mDialogWindowHeight);
        }

        // Apply the newly created layout parameters to the alert dialog window
        getDialog().getWindow().setAttributes(layoutParams);


    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_positive) {
            if (callBack != null) {
                callBack.onDialogButtonClick(true);
            }
            dismiss();
        }
        if (v.getId() == R.id.btn_negative) {
            if (callBack != null) {
                callBack.onDialogButtonClick(false);
            }
            dismiss();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
