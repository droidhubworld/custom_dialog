package com.droidhubworld.dialoglib.messagedialog;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.droidhubworld.dialoglib.R;
import com.droidhubworld.dialoglib.listener.CommonDialogListener;


public class CommonMessageDialog extends BaseDialog implements View.OnClickListener {
    private FrameLayout titleHeader;
    private LinearLayout layoutTitle;
    private boolean hideTitle;
    private ImageView mIcon;
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
    private int mPositiveButtonTextColor = -1;
    private int mNegativeButtonTextColor = -1;
    private boolean mShowNegativeButton = true;
    private Drawable mTitleBackgroundDrawable = null;
    private Drawable mTitleIcon = null;
    private boolean mHideIcon;
    private int mIconHeight = -1;
    private int mIconWidth = -1;
    private int mIconTitleMaxHeight = -1;
    private int mIconTitleMaxWidth = -1;
    private int mIconTitleMinHeight = -1;
    private int mIconTitleMinWidth = -1;
    private int mIconTitleThinColor = -1;
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
                                int mPositiveButtonTextColor,
                                int mNegativeButtonTextColor,
                                boolean mShowNegativeButton,
                                Drawable mTitleBackgroundDrawable,
                                Drawable mTitleIcon,
                                boolean mHideIcon,
                                int mIconHeight,
                                int mIconWidth,
                                int mIconTitleMaxHeight,
                                int mIconTitleMaxWidth,
                                int mIconTitleMinHeight,
                                int mIconTitleMinWidth,
                                int mIconTitleThinColor,
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
        this.mPositiveButtonTextColor = mPositiveButtonTextColor;
        this.mNegativeButtonTextColor = mNegativeButtonTextColor;
        this.mShowNegativeButton = mShowNegativeButton;
        this.mTitleBackgroundDrawable = mTitleBackgroundDrawable;
        this.mTitleIcon = mTitleIcon;
        this.mHideIcon = mHideIcon;
        this.mIconHeight = mIconHeight;
        this.mIconWidth = mIconWidth;
        this.mIconTitleMaxHeight = mIconTitleMaxHeight;
        this.mIconTitleMaxWidth = mIconTitleMaxWidth;
        this.mIconTitleMinHeight = mIconTitleMinHeight;
        this.mIconTitleMinWidth = mIconTitleMinWidth;
        this.mIconTitleThinColor = mIconTitleThinColor;
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
        private int mPositiveButtonTextColor = -1;
        private int mNegativeButtonTextColor = -1;
        private boolean mShowNegativeButton = true;
        private Drawable mTitleBackgroundDrawable = null;
        private Drawable mTitleIcon = null;
        private boolean mHideIcon = false;
        private int mIconHeight = -1;
        private int mIconWidth = -1;
        private int mIconTitleMaxHeight = -1;
        private int mIconTitleMaxWidth = -1;
        private int mIconTitleMinHeight = -1;
        private int mIconTitleMinWidth = -1;
        private int mIconTitleThinColor = -1;
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

        public Builder iconTitleThinColor(int iconThinColor) {
            this.mIconTitleThinColor = iconThinColor;
            return this;
        }

        public Builder iconTitleMinWidth(int iconMinWidth) {
            this.mIconTitleMinWidth = iconMinWidth;
            return this;
        }

        public Builder iconTitleMinHeight(int iconMinHeight) {
            this.mIconTitleMinHeight = iconMinHeight;
            return this;
        }

        public Builder hideIcon(boolean mHideIcon) {
            this.mHideIcon = mHideIcon;
            return this;
        }

        public Builder iconHeight(int iconHeight) {
            this.mIconHeight = mIconHeight;
            return this;
        }

        public Builder iconWidth(int iconWidth) {
            this.mIconWidth = iconWidth;
            return this;
        }

        public Builder iconTitleMaxHeight(int iconMaxHeight) {
            this.mIconTitleMaxHeight = iconMaxHeight;
            return this;
        }

        public Builder iconTitleMaxWidth(int iconMaxWidth) {
            this.mIconTitleMaxWidth = iconMaxWidth;
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

        public Builder positiveButtonTextColor(int positiveButtonTextColor) {
            this.mPositiveButtonTextColor = positiveButtonTextColor;
            return this;
        }

        public Builder negativeButtonTextColor(int negativeButtonTextColor) {
            this.mNegativeButtonTextColor = negativeButtonTextColor;
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
                    this.mPositiveButtonDrawable, this.mNegativeButtonDrawable, this.mPositiveButtonText, this.mNegativeButtonText, this.mPositiveButtonTextColor, this.mNegativeButtonTextColor, this.mShowNegativeButton,
                    this.mTitleBackgroundDrawable, this.mTitleIcon, this.mHideIcon, this.mIconHeight, this.mIconWidth, this.mIconTitleMaxHeight, this.mIconTitleMaxWidth, this.mIconTitleMinHeight, this.mIconTitleMinWidth, this.mIconTitleThinColor, this.mCornerRadius,
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
    public int getLayoutId() {
        return mStyle;
    }

    @Override
    public boolean isCancelable() {
        return mCancelable;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.common_message_dialog, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        titleHeader = view.findViewById(R.id.layout_titleHeader);
        layoutTitle = view.findViewById(R.id.layout_title);
        mIcon = view.findViewById(R.id.img_icon);
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
        /*if (mStyle > -1)
            getDialog().getWindow().getAttributes().windowAnimations = mStyle;*/
        if (mCornerRadius > -1) {
            rootLayout.setRadius(mCornerRadius);
        }
        if (mTitleIcon != null) {
            titleIcon.setImageDrawable(mTitleIcon);
        }
        if (mIconTitleThinColor > -1) {
            titleIcon.setColorFilter(ContextCompat.getColor(mContext, mIconTitleThinColor), android.graphics.PorterDuff.Mode.SRC_IN);
        }
        if (mIconHeight > -1) {
            mIcon.setMaxHeight(mIconHeight);
        }
        if (mHideIcon) {
            mIcon.setVisibility(View.VISIBLE);
        } else {
            mIcon.setVisibility(View.GONE);
        }
        if (mIconTitleMaxHeight > -1) {
            titleIcon.setMaxHeight(mIconTitleMaxHeight);
        }
        if (mIconTitleMinHeight > -1) {
            titleIcon.setMinimumHeight(mIconTitleMinHeight);
        }
        if (mIconTitleMinWidth > -1) {
            titleIcon.setMinimumWidth(mIconTitleMinWidth);
        }
        if (mIconWidth > -1) {
            mIcon.setMaxWidth(mIconHeight);
        }
        if (mIconTitleMaxWidth > -1) {
            titleIcon.setMaxWidth(mIconTitleMaxWidth);
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

        if (mNegativeButtonTextColor > -1) {
            btnNegative.setTextColor(mContext.getResources().getColor(mNegativeButtonTextColor));
        }
        if (mPositiveButtonText != null) {
            btnPositive.setText(mPositiveButtonText);
        }
        if (mPositiveButtonTextColor > -1) {
            btnPositive.setTextColor(mContext.getResources().getColor(mPositiveButtonTextColor));
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
