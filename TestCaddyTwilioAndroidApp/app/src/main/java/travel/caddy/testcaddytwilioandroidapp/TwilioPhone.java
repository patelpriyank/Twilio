package travel.caddy.testcaddytwilioandroidapp;

/**
 * Created by PrPatel on 7/18/2014.
 */

import android.content.Context;
import android.util.Log;

import com.twilio.client.Connection;
import com.twilio.client.Device;
import com.twilio.client.Twilio;
import com.twilio.client.impl.net.HttpHelper;

public class TwilioPhone implements Twilio.InitListener {

    private static final String TAG = "TwilioPhone";
    private Device device;
    private Connection connection;

    public TwilioPhone(Context context)
    {
        Twilio.initialize(context, this /* Twilio.InitListener */);
    }

    @Override
    public void onInitialized() {

        Log.d(TAG, "Twilio SDK is ready");

        try {

            String capabilityToken = HttpHelperUtil.httpGet("http://ec2-54-209-109-97.compute-1.amazonaws.com/api/twilio/gettoken?clientid=TestCaddyAndroidApp");
            device = Twilio.createDevice(capabilityToken, null /* DeviceListener */);
        } catch (Exception e) {
            Log.e(TAG, "Failed to obtain capability token: " + e.getLocalizedMessage());
        }

    }

    @Override
    public void onError(Exception e) {
        Log.e(TAG, "Twilio SDK couldn't start: " + e.getLocalizedMessage());
    }

    @Override
    protected void finalize()
    {
        if (connection != null)
            connection.disconnect();
        if (device != null)
            device.release();
    }

    /** other methods **/
    public void connect()
    {
        connection = device.connect(null /* parameters */, null /* ConnectionListener */);
        if (connection == null)
            Log.w(TAG, "Failed to create new connection");
    }

    public void disconnect()
    {
        if (connection != null) {
            connection.disconnect();
            connection = null;
        }
    }
}