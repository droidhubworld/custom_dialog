# Android-Custom-Dialog
Android Custom Dialog for easily use

#### Click on Image to shee demo
[![Android Custom Dialog](https://img.youtube.com/vi/WFrSCFLoOL8/maxresdefault.jpg)](https://www.youtube.com/watch?v=WFrSCFLoOL8)

###### Step 1. Add it in your root build.gradle at the end of repositories:
```
allprojects {
   repositories {
     ...
     maven { url 'https://jitpack.io' }
    }
   }
]
```
 ###### Step 2. Add the dependency
 ```
dependencies {
        implementation 'com.github.droidhubworld:custom_dialog:0.1.5'
}
```
###### Default Usage
```
dialog = new CommonMessageDialog.Builder(this)
	.title("Default Custom Dialog")
	.message("This Is Default Custom Message")
	.callBack(new CommonDialogListener() {
		@Override
		public void onDialogButtonClick(Boolean isPositive) {

		}
	}).build();
dialog.show("Dialog");
```
###### Custome Usage
```
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
   .iconMaxHeight(32)
   .iconMaxWidth(32)
   .iconMinHeight(18)
   .iconMinWidth(18)
   .iconThinColor(R.color.red)
   .titleIcon(getResources().getDrawable(R.drawable.ic_alert_title))
   .titleBackgroundDrawable(getResources().getDrawable(R.drawable.title_gradient_bg))
   .backgroundColor(R.color.white)
   .positiveButtonDrawable(getResources().getDrawable(R.drawable.default_button_selector))
   .negativeButtonDrawable(getResources().getDrawable(R.drawable.default_button_selector))
   .cancelable(false)
   .dialogWindowWidth(0.9f)
   .dialogWindowHeight(0.3f)
   .style(R.style.dialog_style)
   .buttonDividerColor(R.color.divider)
   .buttonDividerWeight(1)
   .showButtonDivider(true)
   .callBack(new CommonDialogListener() {
       @Override
       public void onDialogButtonClick(Boolean isPositive) {

       }
   }).build();

dialog.show("Dialog");
```

## All Done
