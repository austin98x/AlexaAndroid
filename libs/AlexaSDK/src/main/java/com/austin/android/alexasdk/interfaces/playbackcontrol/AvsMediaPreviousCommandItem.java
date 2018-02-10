package com.austin.android.alexasdk.interfaces.playbackcontrol;

import com.austin.android.alexasdk.interfaces.AvsItem;

/**
 * {@link com.austin.android.alexasdk.data.Directive} to send a previous command to any app playing media
 *
 * This directive doesn't seem applicable to mobile applications
 *
 * @author will on 5/31/2016.
 */

public class AvsMediaPreviousCommandItem extends AvsItem {
    public AvsMediaPreviousCommandItem(String token) {
        super(token);
    }
}
