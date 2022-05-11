# Capacitor Status Bar Area

Forked from [@capacitor/status-bar](https://github.com/ionic-team/capacitor-plugins) with additional feature

The StatusBar API Provides methods for getting height, configuring the style of the Status Bar, along with showing or hiding it.

## Install

```bash
npm install capacitor-status-bar-area
npx cap sync
```

## iOS Note

This plugin requires "View controller-based status bar appearance"
(`UIViewControllerBasedStatusBarAppearance`) set to `YES` in `Info.plist`. Read
about [Configuring iOS](https://capacitorjs.com/docs/ios/configuration) for
help.

The status bar visibility defaults to visible and the style defaults to
`Style.Default`. You can change these defaults by adding
`UIStatusBarHidden` and/or `UIStatusBarStyle` in `Info.plist`.

`setBackgroundColor` and `setOverlaysWebView` are currently not supported on
iOS devices.

## Example

```typescript
import { StatusBar, Style } from 'capacitor-status-bar-area';

// iOS only
window.addEventListener('statusTap', function () {
  console.log('statusbar tapped');
});

// Display content under transparent status bar (Android only)
StatusBar.setOverlaysWebView({ overlay: true });

const setStatusBarStyleDark = async () => {
  await StatusBar.setStyle({ style: Style.Dark });
};

const setStatusBarStyleLight = async () => {
  await StatusBar.setStyle({ style: Style.Light });
};

const hideStatusBar = async () => {
  await StatusBar.hide();
};

const showStatusBar = async () => {
  await StatusBar.show();
};
```

## API

<docgen-index>

* [`setStyle(...)`](#setstyle)
* [`setBackgroundColor(...)`](#setbackgroundcolor)
* [`show(...)`](#show)
* [`hide(...)`](#hide)
* [`getInfo()`](#getinfo)
* [`getHeight()`](#getheight)
* [`setOverlaysWebView(...)`](#setoverlayswebview)
* [Interfaces](#interfaces)
* [Enums](#enums)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### setStyle(...)

```typescript
setStyle(options: StyleOptions) => Promise<void>
```

Set the current style of the status bar.

| Param         | Type                                                  |
| ------------- | ----------------------------------------------------- |
| **`options`** | <code><a href="#styleoptions">StyleOptions</a></code> |

--------------------


### setBackgroundColor(...)

```typescript
setBackgroundColor(options: BackgroundColorOptions) => Promise<void>
```

Set the background color of the status bar.

This method is only supported on Android.

| Param         | Type                                                                      |
| ------------- | ------------------------------------------------------------------------- |
| **`options`** | <code><a href="#backgroundcoloroptions">BackgroundColorOptions</a></code> |

--------------------


### show(...)

```typescript
show(options?: AnimationOptions | undefined) => Promise<void>
```

Show the status bar.

| Param         | Type                                                          |
| ------------- | ------------------------------------------------------------- |
| **`options`** | <code><a href="#animationoptions">AnimationOptions</a></code> |

--------------------


### hide(...)

```typescript
hide(options?: AnimationOptions | undefined) => Promise<void>
```

Hide the status bar.

| Param         | Type                                                          |
| ------------- | ------------------------------------------------------------- |
| **`options`** | <code><a href="#animationoptions">AnimationOptions</a></code> |

--------------------


### getInfo()

```typescript
getInfo() => Promise<StatusBarInfo>
```

Get info about the current state of the status bar.

**Returns:** <code>Promise&lt;<a href="#statusbarinfo">StatusBarInfo</a>&gt;</code>

--------------------


### getHeight()

```typescript
getHeight() => Promise<StatusBarHeight>
```

Get the current style of the status bar in pixels.

**Returns:** <code>Promise&lt;<a href="#statusbarheight">StatusBarHeight</a>&gt;</code>

--------------------


### setOverlaysWebView(...)

```typescript
setOverlaysWebView(options: SetOverlaysWebViewOptions) => Promise<void>
```

Set whether or not the status bar should overlay the webview to allow usage
of the space underneath it.

This method is only supported on Android.

| Param         | Type                                                                            |
| ------------- | ------------------------------------------------------------------------------- |
| **`options`** | <code><a href="#setoverlayswebviewoptions">SetOverlaysWebViewOptions</a></code> |

--------------------


### Interfaces


#### StyleOptions

| Prop        | Type                                    | Description                                               |
| ----------- | --------------------------------------- | --------------------------------------------------------- |
| **`style`** | <code><a href="#style">Style</a></code> | <a href="#style">Style</a> of the text of the status bar. |


#### BackgroundColorOptions

| Prop        | Type                | Description                                                                                 |
| ----------- | ------------------- | ------------------------------------------------------------------------------------------- |
| **`color`** | <code>string</code> | A hex color to which the status bar color is set. This option is only supported on Android. |


#### AnimationOptions

| Prop            | Type                                            | Description                                                                                         |
| --------------- | ----------------------------------------------- | --------------------------------------------------------------------------------------------------- |
| **`animation`** | <code><a href="#animation">Animation</a></code> | The type of status bar animation used when showing or hiding. This option is only supported on iOS. |


#### StatusBarInfo

| Prop           | Type                                    | Description                                                                         |
| -------------- | --------------------------------------- | ----------------------------------------------------------------------------------- |
| **`height`**   | <code>number</code>                     | The height of the status bar (in pixels).                                           |
| **`visible`**  | <code>boolean</code>                    | Whether the status bar is visible or not.                                           |
| **`style`**    | <code><a href="#style">Style</a></code> | The current status bar style.                                                       |
| **`color`**    | <code>string</code>                     | The current status bar color. This option is only supported on Android.             |
| **`overlays`** | <code>boolean</code>                    | Whether the statusbar is overlaid or not. This option is only supported on Android. |


#### StatusBarHeight

| Prop         | Type                |
| ------------ | ------------------- |
| **`height`** | <code>number</code> |


#### SetOverlaysWebViewOptions

| Prop          | Type                 | Description                               |
| ------------- | -------------------- | ----------------------------------------- |
| **`overlay`** | <code>boolean</code> | Whether to overlay the status bar or not. |


### Enums


#### Style

| Members       | Value                  | Description                                                                                                                                                                                                                                                                                                                     |
| ------------- | ---------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **`Dark`**    | <code>'DARK'</code>    | Light text for dark backgrounds.                                                                                                                                                                                                                                                                                                |
| **`Light`**   | <code>'LIGHT'</code>   | Dark text for light backgrounds.                                                                                                                                                                                                                                                                                                |
| **`Default`** | <code>'DEFAULT'</code> | On iOS 13 and newer the style is based on the device appearance. If the device is using Dark mode, the statusbar text will be light. If the device is using Light mode, the statusbar text will be dark. On iOS 12 and older the statusbar text will be dark. On Android the default will be the one the app was launched with. |


#### Animation

| Members     | Value                | Description                       |
| ----------- | -------------------- | --------------------------------- |
| **`None`**  | <code>'NONE'</code>  | No animation during show/hide.    |
| **`Slide`** | <code>'SLIDE'</code> | Slide animation during show/hide. |
| **`Fade`**  | <code>'FADE'</code>  | Fade animation during show/hide.  |

</docgen-api>
