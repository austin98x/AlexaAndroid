package com.austin.android.alexasdk.interfaces.playbackcontrol;

import com.austin.android.alexasdk.interfaces.AvsItem;

/**
 * Directive to stop device playback
 *
 * {@link com.austin.android.alexasdk.data.Directive} response item type parsed so we can properly
 * deal with the incoming commands from the Alexa server.
 *
 * @author will on 5/21/2016.
 */
public class AvsStopItem extends AvsItem {
    public AvsStopItem(String token) {
        super(token);
    }
}
