package com.austin.android.alexasdk.interfaces.speechrecognizer;

/**
 * Directive to prompt the user for a speech input
 *
 * See: {@link AvsExpectSpeechItem}
 *
 * {@link com.austin.android.alexasdk.data.Directive} response item type parsed so we can properly
 * deal with the incoming commands from the Alexa server.
 *
 * @deprecated Check for {@link AvsExpectSpeechItem} instead
 *
 * @author will on 5/21/2016.
 */

@Deprecated
public class AvsListenItem extends AvsExpectSpeechItem {
    public AvsListenItem(){
        this(null, 2000);
    }
    public AvsListenItem(String token, long timeoutInMiliseconds) {
        super(token, timeoutInMiliseconds);
    }

}
