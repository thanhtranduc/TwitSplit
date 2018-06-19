package com.thanh.twitsplit.presentation.internal.injection.components;

import android.content.Context;

import com.thanh.twitsplit.domain.executor.PostExecutionThread;
import com.thanh.twitsplit.domain.executor.ThreadExecutor;
import com.thanh.twitsplit.domain.repository.UserRepository;
import com.thanh.twitsplit.presentation.internal.injection.modules.ApplicationModule;
import com.thanh.twitsplit.presentation.view.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    //Exposed to sub-graphs.
    Context context();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();

    UserRepository userRepository();
}
