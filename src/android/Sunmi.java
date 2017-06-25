//package org.apache.cordova.statusbar;
package br.heitorhherzog.cordova.sunmi;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import com.sunmi.printerhelper.utils.AidlUtil;


import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;
import org.json.JSONException;

public class Sunmi extends CordovaPlugin {
    private static final String TAG = "Sunmi";

    /**
     * Sets the context of the Command. This can then be used to do things like
     * get file paths associated with the Activity.
     *
     * @param cordova The context of the main Activity.
     * @param webView The CordovaWebView Cordova is running in.
     */
    @Override
    public void initialize(final CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

    }

    /**
     * Executes the request and returns PluginResult.
     *
     * @param action            The action to execute.
     * @param args              JSONArry of arguments for the plugin.
     * @param callbackContext   The callback id used when calling back into JavaScript.
     * @return                  True if the action was valid, false otherwise.
     */
    @Override
    public boolean execute(final String action, final CordovaArgs args, final CallbackContext callbackContext) throws JSONException {
        final Activity activity = this.cordova.getActivity();
        final Window window = activity.getWindow();

		if ("sendText".equals(action)) {
			String content = args.getString(0);
		     float size =  Integer.parseInt(args.getString(1));
		     boolean isBold = Boolean.parseBoolean(args.getString(2));
		     boolean isUnderLine = Boolean.parseBoolean(args.getString(3));

      //Get Context to send to print service
       Context context=this.cordova.getActivity().getApplicationContext();
       AidlUtil.getInstance().connectPrinterService(context);

       AidlUtil.getInstance().initPrinter();
			 AidlUtil.getInstance().printText(content, size, isBold, isUnderLine);
			 callbackContext.success();
		    return true;
		}

        return false;
    }
}


