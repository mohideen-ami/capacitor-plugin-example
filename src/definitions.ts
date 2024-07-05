declare module "@capacitor/core" {
  interface PluginRegistry {
    ExamplePlugin: ExamplePlugin
  }
}

export interface ExamplePlugin {
  echo(options: options): Promise<options>;
}
export interface options {
  value : string
}