package com.damithdev.jsonex.exception;

import java.io.IOException;

/**
 * Created by Damith on 3/5/2017.
 */

public class NoInternetException extends IOException {

    public NoInternetException(String detailMessage) {
        super(detailMessage);
    }

}
