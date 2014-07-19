package travel.caddy.caddytwilioapp;

/**
 * Created by PrPatel on 7/18/2014.
 */

import android.content.Context;
import android.util.Log;

import com.twilio.client.Device;
import com.twilio.client.Twilio;
import com.twilio.client.impl.net.HttpHelper;

public class TwilioPhone implements Twilio.InitListener {

    private static final String TAG = "TwilioPhone";
    private Device device;

    public TwilioPhone(Context context)
    {
        Twilio.initialize(context, this /* Twilio.InitListener */);
    }

    @Override
    public void onInitialized() {

        Log.d(TAG, "Twilio SDK is ready");

        try {

            String capabilityToken = HttpHelper.httpGet("http://companyfoo.com/auth.php");
            device = Twilio.createDevice(capabilityToken, null /* DeviceListener */);
        } catch (Exception e) {
            Log.e(TAG, "Failed to obtain capability token: " + e.getLocalizedMessage());
        }

    }

    @Override
    public void onError(Exception e) {

    }
}
