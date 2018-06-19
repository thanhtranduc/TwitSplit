package com.thanh.twitsplit.data.repository.datasource;

import com.thanh.twitsplit.data.entity.MessageEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Interface that represents a data store from where data is retrieved.
 */
public interface DataStore {
    /**
     * Get an {@link Observable} which will emit a List of {@link MessageEntity}.
     */
    Observable<List<MessageEntity>> messEntityList();
}
