package com.austin.android.alexasdk.interfaces.speaker;

import com.austin.android.alexasdk.interfaces.AvsItem;

/**
* Directive to set the device mute state
*
* {@link com.austin.android.alexasdk.data.Directive} response item type parsed so we can properly
* deal with the incoming commands from the Alexa server.
*
* @author will on 5/21/2016.
*/
public class AvsSetMuteItem extends AvsItem{
    boolean mute;

    /**
     * Create a new AdjustVolume {@link com.austin.android.alexasdk.data.Directive}
     * @param mute whether the device should be mute upon parsing the directive.
     */
    public AvsSetMuteItem(String token, boolean mute){
        super(token);
        this.mute = mute;
    }

    public boolean isMute() {
        return mute;
    }
}
