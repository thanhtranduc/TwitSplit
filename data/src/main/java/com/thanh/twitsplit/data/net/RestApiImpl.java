package com.thanh.twitsplit.data.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.thanh.twitsplit.data.entity.MessageEntity;
import com.thanh.twitsplit.data.entity.mapper.MessEntityJsonMapper;
import com.thanh.twitsplit.data.exception.NetworkConnectionException;

import java.util.List;

import io.reactivex.Observable;

public class RestApiImpl implements RestApi {

    private final Context context;
    private final MessEntityJsonMapper messEntityJsonMapper;

    /**
     * Constructor of the class
     *
     * @param context              {@link android.content.Context}.
     * @param messEntityJsonMapper {@link MessEntityJsonMapper}.
     */
    public RestApiImpl(Context context, MessEntityJsonMapper messEntityJsonMapper) {
        if (context == null || messEntityJsonMapper == null) {
            throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
        }
        this.context = context.getApplicationContext();
        this.messEntityJsonMapper = messEntityJsonMapper;
    }

    @Override
    public Observable<List<MessageEntity>> messEntityList() {
        return Observable.create(emitter -> {
            if (isThereInternetConnection()) {
                emitter.onComplete();
            } else {
                emitter.onError(new NetworkConnectionException());
            }
        });
    }

    /**
     * Checks if the device has any active internet connection.
     *
     * @return true device with internet connection, otherwise false.
     */
    private boolean isThereInternetConnection() {
        boolean isConnected;

        ConnectivityManager connectivityManager =
                (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());

        return isConnected;
    }
}
