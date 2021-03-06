package com.austin.android.alexa;

import android.app.Application;
import android.util.Log;

import com.austin.android.alexa.utility.SigningKey;

/**
 * An application to handle all our initialization for the Alexa library before we
 * launch our VoiceLaunchActivity
 */
public class AlexaApplication extends Application {

    //Our Application instance if we need to reference it directly
    private static AlexaApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        //if we run in DEBUG mode, we can get our signing key in the LogCat
        if(BuildConfig.DEBUG) {
            Log.i("AlexaApplication", SigningKey.getCertificateMD5Fingerprint(this));
        }
    }

    /**
     * Return a reference to our mInstance instance
     * @return our current application instance, created in onCreate()
     */
    public static AlexaApplication getInstance() {
        return mInstance;
    }
}
