package com.thanh.twitsplit.data.repository.datasource;

import android.content.Context;
import android.support.annotation.NonNull;

import com.thanh.twitsplit.data.entity.mapper.MessEntityJsonMapper;
import com.thanh.twitsplit.data.net.RestApi;
import com.thanh.twitsplit.data.net.RestApiImpl;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Factory that creates different implementations of {@link DataStore}.
 */
@Singleton
public class DataStoreFactory {

    private final Context context;

    @Inject
    DataStoreFactory(@NonNull Context context) {
        this.context = context.getApplicationContext();
    }

    public DataStore createCloudDataStore() {
        final MessEntityJsonMapper messEntityJsonMapper = new MessEntityJsonMapper();
        final RestApi restApi = new RestApiImpl(this.context, messEntityJsonMapper);

        return new CloudDataStore(restApi);
    }
}
