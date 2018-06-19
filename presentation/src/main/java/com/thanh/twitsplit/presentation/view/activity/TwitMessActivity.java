
package com.thanh.twitsplit.presentation.view.activity;

import android.os.Bundle;
import android.view.Window;

import com.thanh.twitsplit.presentation.R;
import com.thanh.twitsplit.presentation.internal.injection.HasComponent;
import com.thanh.twitsplit.presentation.internal.injection.components.DaggerUserComponent;
import com.thanh.twitsplit.presentation.internal.injection.components.UserComponent;
import com.thanh.twitsplit.presentation.view.fragment.TwitMessageFragment;

/**
 * Activity that shows a list of Users.
 */
public class TwitMessActivity extends BaseActivity implements HasComponent<UserComponent> {

    private UserComponent userComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_layout);
        this.initializeInjector();
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new TwitMessageFragment());
        }
    }

    private void initializeInjector() {
        this.userComponent = DaggerUserComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public UserComponent getComponent() {
        return userComponent;
    }
}
