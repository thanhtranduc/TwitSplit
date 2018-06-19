package com.thanh.twitsplit.presentation.presenter;

import com.thanh.twitsplit.presentation.view.CommonBehavior;

public interface Presenter<T extends CommonBehavior> {

    void setView(T t);

    T getView();

    void resume();

    void pause();

    void destroy(int hasCode);
}
