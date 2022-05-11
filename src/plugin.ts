import { registerPlugin } from '@capacitor/core';

import type { StatusBarAreaPlugin } from './definitions';

const StatusBarArea = registerPlugin<StatusBarAreaPlugin>('StatusBarArea', {
  web: () => import('./web').then(m => new m.StatusBarAreaWeb()),
});


export { StatusBarArea };
