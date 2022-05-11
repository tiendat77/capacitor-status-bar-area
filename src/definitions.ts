export interface StyleOptions {
  /**
   * Style of the text of the status bar.
   */
  style: Style;
}

export enum Style {
  /**
   * Light text for dark backgrounds.
   */
  Dark = 'DARK',

  /**
   * Dark text for light backgrounds.
   */
  Light = 'LIGHT',

  /**
   * On iOS 13 and newer the style is based on the device appearance.
   * If the device is using Dark mode, the statusbar text will be light.
   * If the device is using Light mode, the statusbar text will be dark.
   * On iOS 12 and older the statusbar text will be dark.
   * On Android the default will be the one the app was launched with.
   */
  Default = 'DEFAULT',
}

export interface AnimationOptions {
  /**
   * The type of status bar animation used when showing or hiding.
   *
   * This option is only supported on iOS.
   */
  animation: Animation;
}

export enum Animation {
  /**
   * No animation during show/hide.
   */
  None = 'NONE',

  /**
   * Slide animation during show/hide.
   */
  Slide = 'SLIDE',

  /**
   * Fade animation during show/hide.
   */
  Fade = 'FADE',
}

export interface BackgroundColorOptions {
  /**
   * A hex color to which the status bar color is set.
   *
   * This option is only supported on Android.
   */
  color: string;
}

export interface StatusBarHeight {
  height: number;
}

export interface StatusBarInfo {

  /**
   * The height of the status bar (in pixels).
   */
  height: number;

  /**
   * Whether the status bar is visible or not.
   */
  visible: boolean;

  /**
   * The current status bar style.
   */
  style: Style;

  /**
   * The current status bar color.
   *
   * This option is only supported on Android.
   */
  color?: string;

  /**
   * Whether the statusbar is overlaid or not.
   *
   * This option is only supported on Android.
   */
  overlays?: boolean;
}

export interface SetOverlaysWebViewOptions {
  /**
   * Whether to overlay the status bar or not.
   */
  overlay: boolean;
}

export interface StatusBarAreaPlugin {
  /**
   * Set the current style of the status bar.
   */
  setStyle(options: StyleOptions): Promise<void>;

  /**
   * Set the background color of the status bar.
   *
   * This method is only supported on Android.
   */
  setBackgroundColor(options: BackgroundColorOptions): Promise<void>;

  /**
   * Show the status bar.
   */
  show(options?: AnimationOptions): Promise<void>;

  /**
   * Hide the status bar.
   */
  hide(options?: AnimationOptions): Promise<void>;

  /**
   * Get info about the current state of the status bar.
   */
  getInfo(): Promise<StatusBarInfo>;

  /**
   * Get the current style of the status bar in pixels.
  */
  getHeight(): Promise<StatusBarHeight>;

  /**
   * Set whether or not the status bar should overlay the webview to allow usage
   * of the space underneath it.
   *
   * This method is only supported on Android.
   */
  setOverlaysWebView(options: SetOverlaysWebViewOptions): Promise<void>;
}
