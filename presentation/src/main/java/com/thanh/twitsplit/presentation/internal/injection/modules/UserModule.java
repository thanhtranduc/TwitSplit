package com.thanh.twitsplit.presentation.internal.injection.modules;

import com.thanh.twitsplit.domain.interactor.GetMessageList;
import com.thanh.twitsplit.domain.interactor.UseCase;
import com.thanh.twitsplit.presentation.internal.injection.PerActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides user related collaborators.
 */
@Module
public class UserModule {

    public UserModule() {
    }

    @Provides
    @PerActivity
    @Named(GetMessageList.NAME)
    UseCase provideGetUserListUseCase(
            GetMessageList getMessageList) {
        return getMessageList;
    }
}
