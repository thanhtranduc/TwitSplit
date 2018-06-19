package com.thanh.twitsplit.presentation.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.thanh.twitsplit.presentation.R;
import com.thanh.twitsplit.presentation.internal.injection.components.UserComponent;
import com.thanh.twitsplit.presentation.model.TwitMessageModel;
import com.thanh.twitsplit.presentation.presenter.BasePresenter;
import com.thanh.twitsplit.presentation.presenter.TwitMessPresenter;
import com.thanh.twitsplit.presentation.view.TwitMessageView;
import com.thanh.twitsplit.presentation.view.adapter.TwitAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Fragment that shows a list of Users.
 */
public class TwitMessageFragment extends BaseFragment implements TwitMessageView {

    @Inject
    TwitMessPresenter twitMessPresenter;

    TwitAdapter twitAdapter;

    @BindView(R.id.list_post)
    RecyclerView recyclerView;
    @BindView(R.id.imSend)
    ImageView imSend;
    @BindView(R.id.type_message)
    EditText etTypeMessage;

    @Override
    protected BasePresenter getPresenter() {
        return twitMessPresenter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(UserComponent.class).inject(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<TwitMessageModel> models = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        twitAdapter = new TwitAdapter(getActivity(), models);
        recyclerView.setAdapter(twitAdapter);
        imSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = etTypeMessage.getText().toString();
                try {
                    List<String> result = twitMessPresenter.splitTwitPost(message, 50);
                    for (String temp : result) {
                        models.add(new TwitMessageModel(temp));
                    }
                    etTypeMessage.setText("");
                    twitAdapter.setMessageModels(models);
                } catch (IllegalArgumentException e) {
                    showError(e.getMessage());
                }
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_twit_post_list;
    }
}
