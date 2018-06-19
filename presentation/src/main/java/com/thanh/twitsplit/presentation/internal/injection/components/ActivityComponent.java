package com.thanh.twitsplit.presentation.internal.injection.components;

import android.app.Activity;

import com.thanh.twitsplit.presentation.internal.injection.PerActivity;
import com.thanh.twitsplit.presentation.internal.injection.modules.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
interface ActivityComponent {
    //Exposed to sub-graphs.
    Activity activity();
}
