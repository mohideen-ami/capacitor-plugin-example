import { WebPlugin } from '@capacitor/core';

import type { ExamplePlugin, options } from './definitions';

export class ExampleWeb extends WebPlugin implements ExamplePlugin {

  constructor(){
    super();
    this.initOrientationChangeListener();
  }

  initOrientationChangeListener() {
    window.addEventListener('orientationchange', () => {
      const orientation = window.screen.orientation.type;
      this.notifyListeners('orientationChanged', { orientation });
    });
  }

  async echo(options: options): Promise<options> {
    console.log('ECHO', options);
    return options;
  }

  async getOrientation(): Promise<{ orientation: string }> {
    const orientation = window.screen.orientation.type;
    return { orientation };
  }
  
  // orientation(){
  //   console.log('ori')
  //   window.addEventListener("orientationchange", function(event: any){
  //     console.log(
  //       `the orientation of the device is now ${event.target.screen.orientation.angle}`,
  //     );
  //     return event.target.screen.orientation.angle;
  //   })
  // }
}
