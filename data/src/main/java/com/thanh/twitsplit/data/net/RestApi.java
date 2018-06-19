package com.thanh.twitsplit.data.net;

import com.thanh.twitsplit.data.entity.MessageEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * RestApi for retrieving data from the network.
 */
public interface RestApi {
    Observable<List<MessageEntity>> messEntityList();
}
