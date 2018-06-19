package com.thanh.twitsplit.presentation.presenter;

import com.thanh.twitsplit.domain.interactor.UseCase;
import com.thanh.twitsplit.presentation.view.TwitMessageView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Alex.Tran
 */
public class TwitMessPresenterTest {

    @Mock
    TwitMessPresenter twitMessPresenter;
    @Mock
    TwitMessageView twitMessageView;
    @Mock
    UseCase useCase;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        twitMessPresenter = spy(new TwitMessPresenter(useCase));
        twitMessPresenter.setView(twitMessageView);
    }


    @Test(expected = IllegalArgumentException.class)
    public void throwIllegalArgumentExceptionWhenStringInputEmpty() {
        twitMessPresenter.splitTwitPost("", 50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwIllegalArgumentExceptionWhenStringInputNull() {
        twitMessPresenter.splitTwitPost(null, 50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwIllegalArgumentExceptionWhenStringInputOver50CharacterNoWhiteSpace() {
        String s = "1234567890" +
                "1234567890" +
                "1234567890" +
                "1234567890" +
                "12345678901";
        twitMessPresenter.splitTwitPost(s, 50);
    }

    @Test
    public void returnResultWhenInputStringLessThan50Character() {
        String s = "this is twit mess";
        List<String> result = twitMessPresenter.splitTwitPost(s, 50);
        assertEquals(1, result.size());
        assertEquals(s, result.get(0));
    }

    @Test
    public void returnListResultWhenInputStringMoreThan50Character() {
        String s = "I can't believe Tweeter now supports chunking my messages, so I don't have to do it myself.";
        List<String> result = twitMessPresenter.splitTwitPost(s, 50);
        assertEquals(2, result.size());
    }


    @Test
    public void loadHistorySuccess() {
        twitMessPresenter.loadListTwitHistory();
        verify(twitMessageView, times(1)).showLoading();
        verify(twitMessPresenter, times(1)).initialize();
        verify(twitMessageView, times(1)).hideLoading();
    }
}