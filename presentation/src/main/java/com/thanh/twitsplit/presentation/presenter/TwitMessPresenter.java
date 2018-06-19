package com.thanh.twitsplit.presentation.presenter;

import com.thanh.twitsplit.domain.MessageTwit;
import com.thanh.twitsplit.domain.exception.DefaultErrorBundle;
import com.thanh.twitsplit.domain.exception.ErrorBundle;
import com.thanh.twitsplit.domain.interactor.DefaultObserver;
import com.thanh.twitsplit.domain.interactor.GetMessageList;
import com.thanh.twitsplit.domain.interactor.Params;
import com.thanh.twitsplit.domain.interactor.UseCase;
import com.thanh.twitsplit.presentation.exception.ErrorMessageFactory;
import com.thanh.twitsplit.presentation.internal.injection.PerActivity;
import com.thanh.twitsplit.presentation.view.TwitMessageView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

@PerActivity
public class TwitMessPresenter extends BasePresenter<TwitMessageView> {


    private final UseCase getTwitList;

    @Inject
    TwitMessPresenter(@Named(GetMessageList.NAME) UseCase getTwitList) {
        this.getTwitList = getTwitList;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {
    }

    public void initialize() {
        //call api if have
    }

    public void loadListTwitHistory() {
        showViewLoading();
        initialize();
        hideViewLoading();
    }

    private void showViewLoading() {
        getView().showLoading();
    }

    private void hideViewLoading() {
        getView().hideLoading();
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(getView().context(),
                errorBundle.getException());
        getView().showError(errorMessage);
    }


    public List<String> splitTwitPost(String s, int capacity) {
        List<String> result = new ArrayList<>();
        if (s == null || s.isEmpty()) throw new IllegalArgumentException("Not empty message");
        int n = s.length();
        if (n <= capacity) {
            result.add(s);
            return result;
        }
        String[] tokens = s.split(" ");
        int len = tokens.length;

        for (int limitLen = 1; limitLen < capacity; limitLen++) {
            result = tryToFit(tokens, len, capacity, limitLen);
            if (!result.isEmpty()) {
                return result;
            }
        }
        throw new IllegalArgumentException("a word must be shorter than capacity 50 character!");
    }

    private List<String> tryToFit(String[] tokens, int len, int capacity, int limitLen) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < len) {
            int lenOfIndex = String.valueOf(result.size() + 1).length();
            if (lenOfIndex > limitLen) {
                return new ArrayList<>();
            }
            int lenOfPrefix = lenOfIndex + limitLen + 2;
            int remain = capacity - lenOfPrefix;
            if (tokens[index].length() > remain) {
                return new ArrayList<>();
            }
            StringBuilder sb = new StringBuilder(tokens[index++]);
            while (index < len && sb.length() + 1 + tokens[index].length() <= remain) {
                sb.append(" ").append(tokens[index++]);
            }
            result.add(sb.toString());
        }
        for (int i = 0; i < result.size(); i++) {
            result.set(i, (i + 1) + "/" + result.size() + " " + result.get(i));
        }
        return result;
    }


    private final class UserListObserver extends DefaultObserver<List<MessageTwit>> {

        @Override
        public void onComplete() {
            TwitMessPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            TwitMessPresenter.this.hideViewLoading();
            TwitMessPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
        }

        @Override
        public void onNext(List<MessageTwit> messageTwits) {
        }
    }
}
