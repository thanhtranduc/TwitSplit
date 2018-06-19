package com.thanh.twitsplit.presentation.view;

import android.content.Context;

/**
 * Interface representing a View that will use to load data.
 */
public interface CommonBehavior {
    /**
     * Show a view with a progress bar indicating a loading process.
     */
    void showLoading();

    /**
     * Hide a loading view.
     */
    void hideLoading();


    /**
     * Show an error message
     *
     * @param message A string representing an error.
     */
    void showError(String message);

    /**
     * Get a {@link Context}.
     */
    Context context();
}
