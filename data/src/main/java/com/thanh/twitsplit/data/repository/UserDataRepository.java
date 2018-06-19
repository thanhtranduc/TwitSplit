package com.thanh.twitsplit.data.repository;

import com.thanh.twitsplit.data.entity.mapper.MessEntityDataMapper;
import com.thanh.twitsplit.data.repository.datasource.DataStoreFactory;
import com.thanh.twitsplit.data.repository.datasource.DataStore;
import com.thanh.twitsplit.domain.MessageTwit;
import com.thanh.twitsplit.domain.repository.UserRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


@Singleton
public class UserDataRepository implements UserRepository {

    private final DataStoreFactory dataStoreFactory;
    private final MessEntityDataMapper messEntityDataMapper;

    @Inject
    public UserDataRepository(DataStoreFactory dataStoreFactory,
                       MessEntityDataMapper messEntityDataMapper) {
        this.dataStoreFactory = dataStoreFactory;
        this.messEntityDataMapper = messEntityDataMapper;
    }

    @Override
    public Observable<List<MessageTwit>> messages() {
        //we always get all users from the cloud
        final DataStore dataStore = this.dataStoreFactory.createCloudDataStore();
        return dataStore.messEntityList().map(this.messEntityDataMapper::transform);
    }
}
