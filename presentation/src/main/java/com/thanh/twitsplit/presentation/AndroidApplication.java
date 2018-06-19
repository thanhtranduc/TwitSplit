package com.thanh.twitsplit.presentation;

import android.app.Application;

import com.thanh.twitsplit.presentation.internal.injection.components.ApplicationComponent;
import com.thanh.twitsplit.presentation.internal.injection.components.DaggerApplicationComponent;
import com.thanh.twitsplit.presentation.internal.injection.modules.ApplicationModule;

public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
