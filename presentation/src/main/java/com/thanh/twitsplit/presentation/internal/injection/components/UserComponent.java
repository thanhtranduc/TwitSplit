package com.thanh.twitsplit.presentation.internal.injection.components;

import com.thanh.twitsplit.presentation.internal.injection.PerActivity;
import com.thanh.twitsplit.presentation.internal.injection.modules.ActivityModule;
import com.thanh.twitsplit.presentation.internal.injection.modules.UserModule;
import com.thanh.twitsplit.presentation.view.fragment.TwitMessageFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, UserModule.class})
public interface UserComponent extends ActivityComponent {
    void inject(TwitMessageFragment twitMessageFragment);
}
