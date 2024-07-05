import { WebPlugin } from '@capacitor/core';

import type { ExamplePlugin, options } from './definitions';

export class ExampleWeb extends WebPlugin implements ExamplePlugin {
  async echo(options: options): Promise<options> {
    console.log('ECHO', options);
    return options;
  }
}
