package com.thanh.twitsplit.presentation.exception;

import android.content.Context;

import com.thanh.twitsplit.data.exception.NetworkConnectionException;
import com.thanh.twitsplit.data.exception.UserNotFoundException;
import com.thanh.twitsplit.presentation.R;

/**
 * Factory used to create error messages from an Exception as a condition.
 */
public class ErrorMessageFactory {

    private ErrorMessageFactory() {
        //empty
    }

    public static String create(Context context, Exception exception) {
        String message = context.getString(R.string.exception_message_generic);

        if (exception instanceof NetworkConnectionException) {
            message = context.getString(R.string.exception_message_no_connection);
        } else if (exception instanceof UserNotFoundException) {
            message = context.getString(R.string.exception_message_not_found);
        }

        return message;
    }
}
