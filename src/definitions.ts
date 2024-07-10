// declare module "@capacitor/core" {
//   interface PluginRegistry {
//     ExamplePlugin: ExamplePlugin
//   }
// }

export interface ExamplePlugin {
  echo(options: options): Promise<options>;
  getOrientation(): Promise<{ orientation: string }>;
  // orientation(): any;
  addListener(eventName: 'orientationChanged', listenerFunc: (info: { orientation: string }) => void): void;
}
export interface options {
  value : string
}