package com.thanh.twitsplit.presentation.presenter;

import com.thanh.twitsplit.presentation.view.CommonBehavior;

import java.lang.ref.WeakReference;

/**
 * Created by Alex.Tran
 */
public class BasePresenter<T extends CommonBehavior> implements Presenter<T> {

    private volatile WeakReference<T> mView;
    private long mViewHashcode;

    @Override
    public void setView(T viewObject) {
        final WeakReference<T> previousView = this.mView;

        if (previousView != null) {
            this.mView = null;
        }

        this.mView = new WeakReference<>(viewObject);
        mViewHashcode = mView.get().hashCode();
    }

    @Override
    public T getView() {
        if (mView != null) {
            return mView.get();
        }
        return null;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy(int hasCode) {
        if (hasCode == mViewHashcode) {
            final WeakReference<T> previousView = this.mView;
            if (previousView == mView) {
                this.mView = null;
            } else {
                throw new IllegalStateException("Unexpected view! previousView = " + previousView + ", view to unbind = " + mView);
            }
        }
    }
}
