package com.austin.android.alexasdk.interfaces.errors;

import com.austin.android.alexasdk.data.Directive;
import com.austin.android.alexasdk.interfaces.AvsItem;

/**
 * Created by will on 6/26/2016.
 */

public class AvsResponseException extends AvsItem {
    Directive directive;
    public AvsResponseException(Directive directive) {
        super(null);
        this.directive = directive;
    }

    public Directive getDirective() {
        return directive;
    }
}
