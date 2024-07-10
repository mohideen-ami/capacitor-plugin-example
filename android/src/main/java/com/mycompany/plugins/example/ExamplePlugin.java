package com.mycompany.plugins.example;

import android.content.Context;
import android.hardware.SensorManager;
import android.util.Log;
import android.view.OrientationEventListener;
import android.widget.Toast;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "Example")
public class ExamplePlugin extends Plugin {

    private Example implementation = new Example();
    private OrientationEventListener orientationEventListener;
    private int lastOrientation = -1;
    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value android", implementation.echo(value));
        call.resolve(ret);
    }

    @Override
    public void load() {
        Context context = getContext();
        if (context != null) {
            orientationEventListener = new OrientationEventListener(context) {
                @Override
                public void onOrientationChanged(int orientation) {
                    if (orientation == ORIENTATION_UNKNOWN) {
                        return;
                    }

                    int newOrientation = context.getResources().getConfiguration().orientation;
                    if (newOrientation != lastOrientation) {
                        lastOrientation = newOrientation;
                        Log.d("OrientationPlugin", "Orientation changed: " + newOrientation);
                        JSObject ret = new JSObject();
                        ret.put("orientation", newOrientation);
                        notifyListeners("orientationChanged", ret);
                    }
                }
            };

            if (orientationEventListener.canDetectOrientation()) {
                orientationEventListener.enable();
            } else {
                orientationEventListener.disable();
            }
        }
    }
    

    @PluginMethod
    public void getOrientation(PluginCall call) {
        Context context = getContext();
        if (context != null) {
            int orientation = context.getResources().getConfiguration().orientation;

            Log.d("orientation", String.valueOf(orientation));
            JSObject ret = new JSObject();
            ret.put("orientation", orientation);
            call.resolve(ret);
        } else {
            call.reject("Context is null");
        }
    }

     @Override
    protected void handleOnDestroy() {
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        super.handleOnDestroy();
    }

}
