package com.thanh.twitsplit.data.repository.datasource;

import com.thanh.twitsplit.data.entity.MessageEntity;
import com.thanh.twitsplit.data.net.RestApi;

import java.util.List;

import io.reactivex.Observable;

class CloudDataStore implements DataStore {

    private final RestApi restApi;

    CloudDataStore(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public Observable<List<MessageEntity>> messEntityList() {
        return this.restApi.messEntityList();
    }
}
