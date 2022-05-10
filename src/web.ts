import { WebPlugin } from '@capacitor/core';

import type { StatusBarAreaPlugin } from './definitions';

export class StatusBarAreaWeb extends WebPlugin implements StatusBarAreaPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
