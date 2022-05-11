import { WebPlugin } from '@capacitor/core';

import {
  AnimationOptions,
  BackgroundColorOptions,
  SetOverlaysWebViewOptions,
  StatusBarAreaPlugin,
  StatusBarHeight,
  StatusBarInfo,
  Style,
  StyleOptions,
} from './definitions';

export class StatusBarAreaWeb extends WebPlugin implements StatusBarAreaPlugin {

  setStyle(options: StyleOptions): Promise<void> {
    console.log('setStyle', options);
    return Promise.resolve();
  }

  setBackgroundColor(options: BackgroundColorOptions): Promise<void> {
    console.log('setBackgroundColor', options);
    return Promise.resolve();
  }

  show(options?: AnimationOptions): Promise<void> {
    console.log('show', options);
    return Promise.resolve();
  }

  hide(options?: AnimationOptions): Promise<void> {
    console.log('hide', options);
    return Promise.resolve();
  }

  setOverlaysWebView(options: SetOverlaysWebViewOptions): Promise<void> {
    console.log('setOverlaysWebView', options);
    return Promise.resolve();
  }

  getHeight(): Promise<StatusBarHeight> {
    return Promise.resolve({height: 0});
  }

  async getInfo(): Promise<StatusBarInfo> {
    return {
      height: 0,
      visible: false,
      style: Style.Default,
      overlays: false,
    };
  }
}
