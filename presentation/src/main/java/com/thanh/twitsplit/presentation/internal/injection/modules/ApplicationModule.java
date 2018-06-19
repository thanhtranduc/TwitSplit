package com.thanh.twitsplit.presentation.internal.injection.modules;

import android.content.Context;

import com.thanh.twitsplit.data.executor.JobExecutor;
import com.thanh.twitsplit.data.repository.UserDataRepository;
import com.thanh.twitsplit.domain.executor.PostExecutionThread;
import com.thanh.twitsplit.domain.executor.ThreadExecutor;
import com.thanh.twitsplit.domain.repository.UserRepository;
import com.thanh.twitsplit.presentation.AndroidApplication;
import com.thanh.twitsplit.presentation.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    UserRepository provideUserRepository(UserDataRepository userDataRepository) {
        return userDataRepository;
    }
}
